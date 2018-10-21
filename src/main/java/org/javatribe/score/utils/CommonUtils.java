package org.javatribe.score.utils;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;

public class CommonUtils {
	/*
	 * 密文，用于加密解密Signature
	 */
	private static final String JWT_SECRET = "fnarip*fudsgf_pbwei_65fa9sdf_jcewdiudsad56161bfof_1564d16";
	/**
	 * 创建jwt
	 *
	 * @param judgeName
	 * @param ttlMillis 过期的时间长度
	 * @return
	 * @throws Exception
	 */
	public static String createJWT(String judgeName, long ttlMillis) throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis=System.currentTimeMillis();//签发jwt的时间
		SecretKey key = generalKey();
		JwtBuilder builder = Jwts.builder()
				.setIssuedAt(new Date())
				.setSubject(judgeName)
				.signWith(signatureAlgorithm, key)
				.setExpiration(new Date(nowMillis + ttlMillis));

		return builder.compact();
	}
	private static SecretKey generalKey() {
		String stringKey =CommonUtils.JWT_SECRET;//秘钥
		byte[] encodedKey = Base64.decodeBase64(stringKey);
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		return key;
	}
	/**
	 * 验证token
	 * @param jwt
	 * @return
	 * @throws Exception
	 */
	public static Claims parseJWT(String jwt) throws Exception{
		SecretKey key = generalKey();
		Claims claims = Jwts.parser()
				.setSigningKey(key)
				.parseClaimsJws(jwt).getBody();
		return claims;
	}
	public static void main(String[] args) {
		try {
			String token=CommonUtils.createJWT("jnxj", 30*1000L);
			Thread.sleep(3000);
			System.out.println(CommonUtils.parseJWT(token).getSubject());
		}catch (ExpiredJwtException e) {
			System.out.println("token过期");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
