package com.rayfocus.oauth2.util;

import java.util.Arrays;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderUtil {
	
	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public static void main(String[] args) {
		
		String[] toEncode = {"userPassword","adminPassword","secretbook"};
		
		Arrays.asList(toEncode).forEach(p -> {
			String encodedValue = passwordEncoder.encode(p);
			System.out.println("Encoded value for "+p +" : "+encodedValue);
		});
	}
}

/**Result
 * 
Encoded value for userPassword : $2a$10$5X18hZRhgv01yfNJhWKsSuTxzg8pyaexFzyiDVbAxUlfWTOhH/nRu
Encoded value for adminPassword : $2a$10$yD8fbccawNsL.VKqp6EpOuW9fmXs3lLtRrRAYD2GJ1Fo/3FcE4Oxa
Encoded value for secretbook : $2a$10$nCWllJYSzQKl/ef3myAX3uv.zOL.kwB05L0RgQZ18aH8qDcj248ri
 * 
 */
