package com.emobile.smis.web.utils;

import java.security.Security;

import org.bouncycastle.crypto.digests.RIPEMD256Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;

public class CipherUtil {
	private static final String INTERNAL_PASSWORD_TOKEN = "124A7BDF5C701B69B4BACD05F1538EA2";
	
	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	public static String toHexString(byte[] data) {
		return new String(Hex.encode(data)).toUpperCase();
	}
	
	public static String passwordDigest(String userId, String password) {
		String upperUserId = userId.toUpperCase();
		String lowerPassword = password.toLowerCase();
		String mixedData = mixString(upperUserId, lowerPassword);;
		/*while (mixedData.length() < INTERNAL_PASSWORD_TOKEN.length()) {
			mixedData = mixString(mixedData, mixString(lowerPassword, upperUserId));
		}*/

		String temp1 = new String(Base64.encode(mixedData.getBytes()));
		String temp2 = mixString((new StringBuilder(INTERNAL_PASSWORD_TOKEN)).reverse().toString(), temp1);

		RIPEMD256Digest digester = new RIPEMD256Digest();
		byte[] resBuf = new byte[digester.getDigestSize()];
		byte[] input = temp2.getBytes();
		digester.update(input, 0, input.length);
		digester.doFinal(resBuf, 0);

		String result = toHexString(resBuf);

		return result.toUpperCase();
	}
	
	private static String mixString(String data1, String data2) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Math.max(data1.length(), data2.length()); i++) {
			if (i < data1.length())
				sb.append(data1.substring(i, i + 1));
			if (i < data2.length())
				sb.append(data2.substring(i, i + 1));
		}
		return sb.toString();
	}
	
	private static String convertToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}
	
	public static String hashSHA1(String input) {
		SHA1Digest digester = new SHA1Digest();
		byte[] resBuf = new byte[digester.getDigestSize()];
		byte[] resPass = input.getBytes();
		digester.update(resPass, 0, resPass.length);
		digester.doFinal(resBuf, 0);

		return convertToHex(resBuf);
	}

}
