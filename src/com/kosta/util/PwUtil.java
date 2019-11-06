package com.kosta.util;

import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Properties;

public class PwUtil {

	private static Properties proFile = new Properties();
	
	static {
		try {
		proFile.load(new FileInputStream("src/com/kosta/property/En_password.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean PWCheck(String password) {
		if (Encryption(password).equals(proFile.getProperty("password"))) {
			return true;
		}
		return false;
	}
	
	
	public String Encryption(String password) {
		
		MessageDigest digest = null; 
		byte[] hash = null;
		StringBuffer hexString = new StringBuffer();
		
		
		try {	
			digest = MessageDigest.getInstance("SHA-256");
			hash = digest.digest(password.getBytes("UTF-8"));
			
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(hexString);
		
		return hexString.toString();
	}
	
}
