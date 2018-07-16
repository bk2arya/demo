package com.example.demo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class Utility {

	
	public static String getHash(byte[] bytes, String algorithm) {
		
		String hash = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(bytes);
			byte[] digestedBytes = messageDigest.digest();
			hash = DatatypeConverter.printBase64Binary(digestedBytes).toLowerCase();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return hash;
	}
	
	public static void main(String[] args) {
		
		String ph="scybhaxvtlxtsx/6mekeoa==";
		System.out.println(ph.equals(getHash("password123".getBytes(), "MD5")) ? "True" : "false");
		
		//to find hash of a file.
		try {
			File imageFile = new File("C:\\Users\\badarikrishna.sg\\Desktop\\skype.png");
			byte[] byteArray = Files.readAllBytes(imageFile.toPath());
			System.out.println(getHash(byteArray, "MD5"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
