package com.atguigu.java;

/**
 * @author FLD
 * @create 2020-03-31 10:43
 */
public class StringMethodTest {
    public static void main(String[] args) {
        /*String s1="hELlo";
        System.out.println(s1.length());
        System.out.println(s1.charAt(1));
        String s2 = s1.toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        String s3="   h e llo world        ";
        String s4 = s3.trim();
        System.out.println(s4);
        String s1="HelloWorld";
        String s2="helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        String s3="abc";
        String s4 = s3.concat("def");
        System.out.println(s4);
        String s5="abc";
        String s6=new String("abe");
        System.out.println(s5.compareTo(s6));
        String s7="我是小布丁";
        String s8 = s7.substring(2,4);
        System.out.println(s8);*/
        /*String s1="helloworld";
        boolean b1 = s1.endsWith("ld");
        System.out.println(b1);
        boolean b2 = s1.startsWith("he");
        System.out.println(b2);
        boolean b3 = s1.startsWith("ll",2);
        System.out.println(b3);*/
        /*String s1,s2;
        Scanner scan=new Scanner(System.in);
        s1=scan.next();
        s2=scan.next();
        int len1=s1.length();
        int len2=s2.length();
        int ans=0,i=0;
        while(i<=len1-len2){
            int temp=s1.indexOf(s2,i);
            if(temp!=-1) {
                ans++;
                i=temp+1;
            }
            else{
                break;
            }
        }
        System.out.println(ans);*/
        /*String s2="hellorworld";
        System.out.println(s1.indexOf("lo"));
        System.out.println(s1.indexOf("lo",0));
        System.out.println(s2.lastIndexOf("or",6));*/
        String s1="北京尚硅谷教育北京";
        String s2 = s1.replace('北', '东');
        System.out.println(s2);
        String s3 = s1.replace("北京", "上海");
        System.out.println(s3);

    }
}
