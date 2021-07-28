package com.example.encryption.decryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESTest {

	private static String keyStr = "1234567891234567";
	public static final String VIPARA = "1234567891234567";

	public static void main(String[] args) {
		String str = "Akshay123";

		byte[] encrypted = encrypt(str);
		byte[] decrypted = decrypt(encrypted);

		System.out.println("Original:" + str);
		System.out.println("Ciphertext:" + ParseSystemUtil.parseByte2HexStr(encrypted));
		System.out.println("Decrypted:" + new String(decrypted));
	}

	public static byte[] encrypt(String content) {
		try {
			IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
			SecretKeySpec key = new SecretKeySpec(keyStr.getBytes(), "AES");// Convert to AES private key
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// Create a cipher
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);// Initialize the cipher in encryption mode
			byte[] result = cipher.doFinal(byteContent);// encryption
			return result;
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] decrypt(byte[] content) {
		try {
			IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
			SecretKeySpec key = new SecretKeySpec(keyStr.getBytes(), "AES");// Convert to AES private key
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// Create a cipher
			cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);// Initialize the cipher in decryption mode
			byte[] result = cipher.doFinal(content);
			return result;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
		return null;
	}

}
