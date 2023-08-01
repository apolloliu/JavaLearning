import java.math.BigInteger;

class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        BigInteger b = new BigInteger(word);
        int[] res = new int[n];
        BigInteger tot = new BigInteger("0");
        BigInteger mod = BigInteger.valueOf(m);
        for(int i = 0; i < n; i++) {
            tot = tot.multiply(new BigInteger("10"));
            tot = tot.add(BigInteger.valueOf(word.charAt(i) - '0'));
            if (tot.mod(mod).equals(BigInteger.valueOf(0))) res[i] = 1;

        }
        return res;
    }
}