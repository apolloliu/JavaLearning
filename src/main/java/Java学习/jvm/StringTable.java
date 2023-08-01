package Java学习.jvm;

public class StringTable {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        String s5 = "a" + "b";
        String s6 = s1 + "b";
        String s7 = "a" + s2;
        String s8 = s4.intern();
        String s9 = s5.intern();
        String s10 = s6.intern();
        String s11 = s7.intern();
        System.out.println(s3 == s4); // false
        System.out.println(s3 == s5); // true
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s3 == s8); // true
        System.out.println(s3 == s9); // true
        System.out.println(s3 == s10); // true
        System.out.println(s3 == s11); // true
    }
}
