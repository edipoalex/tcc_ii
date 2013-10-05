package br.com.droid.util;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptographyMD5 {

	public static String encrypt(String valor) {
		String s = null;
		try {
			if (valor != null) {
				MessageDigest md = MessageDigest.getInstance("MD5");
				BigInteger hash = new BigInteger(1, md.digest(valor.getBytes()));
				s = hash.toString(16);
				if (s.length() %2 != 0)
				s = "0" + s;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return s;
	}
}
