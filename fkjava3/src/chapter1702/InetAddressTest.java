package chapter1702;

import java.net.InetAddress;

public class InetAddressTest {
	public static void main(String[] args) throws Exception{
		InetAddress ip=InetAddress.getByName("www.crazyit.org");
		System.out.println(ip.isReachable(2000));
		System.out.println(ip.getHostAddress());
		InetAddress local=InetAddress.getByAddress(new byte[]{127,0,0,1});
		System.out.println(local.isReachable(5000));
		System.out.println(local.getCanonicalHostName());
	}
}
