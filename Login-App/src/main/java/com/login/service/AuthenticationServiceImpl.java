package com.login.service;

import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import de.taimos.totp.TOTP;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Value("${qrcode.path}")
	private String filepath;
	
	@Override
	public String generateSecretKey() {
		SecureRandom random = new SecureRandom();
	    byte[] bytes = new byte[20];
	    random.nextBytes(bytes);
	    Base32 base32 = new Base32();
	    return base32.encodeToString(bytes);
	}
	
	
	private String getTOTPCode(String secretKey) {
		Base32 base32 = new Base32();
	    byte[] bytes = base32.decode(secretKey);
	    String hexKey = Hex.encodeHexString(bytes);
	    return TOTP.getOTP(hexKey);
	}
	
	private String getGoogleAuthBarCode(String secretKey, String account, String issuer) {
		try {
	        return "otpauth://totp/"
	                + URLEncoder.encode(issuer + ":" + account, "UTF-8").replace("+", "%20")
	                + "?secret=" + URLEncoder.encode(secretKey, "UTF-8").replace("+", "%20")
	                + "&issuer=" + URLEncoder.encode(issuer, "UTF-8").replace("+", "%20");
	    } catch (UnsupportedEncodingException e) {
	        return null;
	    }
	}

	@Override
	public Boolean authenticateTOTPCode(String userOtp, String secretkey) {
		String Totp = this.getTOTPCode(secretkey);
		if(Totp.equals(userOtp))
			return true;
		return false;
	}

	@Override
	public String createQRCode(String secretkey, String username) {
		try {
			String path= filepath+username+".png";
			String barcode = this.getGoogleAuthBarCode(secretkey, username, "LoginApp");
			BitMatrix matrix = new MultiFormatWriter().encode(barcode, BarcodeFormat.QR_CODE, 300, 300);
		    FileOutputStream out = new FileOutputStream(path);
		    MatrixToImageWriter.writeToStream(matrix, "png", out);
		    out.close();
		    return path;
		} catch( Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}


	@Override
	public void deleteQRCode(String username) {
		try {
			String path= filepath+username+".png";
			Files.deleteIfExists(Paths.get(path));
		}catch(Exception e) {
			System.out.println("Some error!!"+e.getMessage());
		}
		
	}


}
