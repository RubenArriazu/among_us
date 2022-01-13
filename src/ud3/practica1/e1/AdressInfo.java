package ud3.practica1.e1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AdressInfo {

	public static void main(String[] args) {
		InetAddress inetAddress;
		try {
			inetAddress = InetAddress.getByName(args[0]);
			infoAdress(inetAddress);
		} catch (UnknownHostException e) {
			System.err.println("Unknow host");
		}
	}

	public static void infoAdress(InetAddress inetAddress) {
		System.out.println("Host adress: " + inetAddress.getHostAddress());
		System.out.println("Host name: " + inetAddress.getHostName());
		System.out.println("Adress: " + inetAddress.getAddress());
		System.out.println("Canonical host name: " + inetAddress.getCanonicalHostName());
		try {
			for (InetAddress ip : InetAddress.getAllByName(inetAddress.getHostName())) {
				System.out.println(ip);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
