//import java.util.concurrent.CountDownLatch;
//
//public class DistributedLock {
//    private static final String LOCK_PATH = "/lock";
//    private static final int SESSION_TIMEOUT = 5000;
//    private static final int CONNECTION_TIMEOUT = 5000;
//    private static final String CONNECTION_STRING = "127.0.0.1:2181";
//
//    private ZooKeeper zk;
//    private CountDownLatch connectedSemaphore = new CountDownLatch(1);
//    private String thisPath;
//    private String waitPath;
//
//    public DistributedLock() {
//        try {
//            zk = new ZooKeeper(CONNECTION_STRING, SESSION_TIMEOUT, new Watcher() {
//                @Override
//                public void process(WatchedEvent event) {
//                    if (event.getState() == Event.KeeperState.SyncConnected) {
//                        connectedSemaphore.countDown();
//                    }
//                }
//            });
//            connectedSemaphore.await();
//            Stat stat = zk.exists(LOCK_PATH, false);
//            if (stat == null) {
//                zk.create(LOCK_PATH, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void acquireDistributedLock() {
//        try {
//            thisPath = zk.create(LOCK_PATH + "/", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
//            System.out.println("Success to acquire lock for " + thisPath);
//            List<String> subNodes = zk.getChildren(LOCK_PATH, false);
//            Collections.sort(subNodes);
//            if (thisPath.equals(LOCK_PATH + "/" + subNodes.get(0))) {
//                doAction();
//            } else {
//                waitForLock(subNodes.get(0));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void waitForLock(String lower) throws KeeperException, InterruptedException {
//        Stat stat = zk.exists(LOCK_PATH + "/" + lower, true);
//        if (stat != null) {
//            System.out.println("Thread " + Thread.currentThread().getId() + " waiting for " + LOCK_PATH + "/" + lower);
//            synchronized (mutex) {
//                mutex.wait();
//            }
//            doAction();
//        } else {
//            List<String> subNodes = zk.getChildren(LOCK_PATH, false);
//            Collections.sort(subNodes);
//            if (thisPath.equals(LOCK_PATH + "/" + subNodes.get(0))) {
//                doAction();
//            } else {
//                waitForLock(subNodes.get(0));
//            }
//        }
//    }
//
//    private void doAction() {
//        System.out.println("Thread " + Thread.currentThread().getId() + " do action");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void releaseDistributedLock() {
//        try {
//            System.out.println("release the lock for " + thisPath);
//            zk.delete(thisPath, -1);
//            thisPath = null;
//            zk.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        DistributedLock lock = new DistributedLock();
//        lock.acquireDistributedLock();
//        lock.releaseDistributedLock();
//    }
//}
