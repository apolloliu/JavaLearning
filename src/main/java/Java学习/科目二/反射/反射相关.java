package Java学习.科目二.反射;

import java.io.*;
import java.sql.Ref;

public class 反射相关 {
    public static void main(String[] args) throws IOException {
//        Reflection reflection = new Reflection();
//        Class<? extends Reflection> aClass = reflection.getClass();
//        Class aClass1 = Reflection.class;
//        for(var m : aClass1.getDeclaredFields()){
//            System.out.println(m.getModifiers());
//        }
//        DataInputStream in = new DataInputStream(InputStream.nullInputStream());
//        long l = in.readLong();
//        System.out.println(l);
//        StringBuffer strinVgBuffer = new StringBuffer();
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
//        InputStream inputStream = new FileInputStream(ByteArrayInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
//        System.out.println(s);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(s);
    }
}

class Reflection {
   private int a;
   public static int b;
   public static final int d = 10;

   protected int c;
}
