package java;

import org.junit.Test;

/**
 * @author FLD
 * @create 2020-04-02 11:34
 */
public class IDEADebug {
    @Test
    public void testStringBuffer(){
        String str=null;
        StringBuffer sb=new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);
        /*StringBuffer sb1=new StringBuffer(str);
        System.out.println(sb1);*/
    }
}
