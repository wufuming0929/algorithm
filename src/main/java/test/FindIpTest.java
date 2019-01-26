package test;

/**
 * 项目名称：algorithm
 * 包： test
 * 类名称：D耳膜.java
 * 类描述：
 * 创建人：wufuming
 * 创建时间：2019年01月21日
 */
public class FindIpTest {

    public static void main(String[] arges) {
        String[] arr = {"202.102.135.0", "202.102.136.255", "202.102.49.15", "202.102.51.251", "202.102.133.0", "202.102.133.255"};
        System.out.println(transferIpToDigit("202.102.133.0"));
        System.out.println(transferDigitToIp(transferIpToDigit("202.102.133.0")));
    }

    /**
     * ip地址转32位整数
     */
    private static int transferIpToDigit(String ip) {
        String[] ips = ip.split("\\.");
        int fi = Integer.parseInt(ips[0]);
        int se = Integer.parseInt(ips[1]);
        int th = Integer.parseInt(ips[2]);
        int fo = Integer.parseInt(ips[3]);
        return fi << 24 | se << 16 | th << 8 | fo;
    }

    /**
     * 32位整数转ip地址
     */
    private static String transferDigitToIp(int digit) {
        int t = 255;
        String[] ips = new String[4];
        ips[0] = String.valueOf(digit & t);
        ips[1] = String.valueOf((digit >>> 8) & t);
        ips[2] = String.valueOf((digit >>> 16) & t);
        ips[3] = String.valueOf((digit >>> 24) & t);
        StringBuilder sb = new StringBuilder();
        for(int i=ips.length-1;i>=0;i--){
            sb.append(ips[i]);
            sb.append(".");
        }
        String ip = sb.toString();
        return ip.substring(0, ip.lastIndexOf("."));
    }

}