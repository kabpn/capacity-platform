package jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

public class ParseJwtTest {
    public static void main(String[] args) {
        Claims claims = Jwts.parser()
                .setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiLlsI_pqawyIiwiY3JlYXRlZCI6MTU3MDY5MjM3Mzg0OCwiaWQiOiIxMTEiLCJleHAiOjE1NzA2OTI5NzR9.GP3Kvqq-MRFS5B4bq3B5WrI8Bgx2tZZJRYNr_jKTxalwdyuZMCGK7YGQ5Zzdu9ZtLQQzSyjkdzlHCNChBt56cQ")
                .getBody();
        System.out.println("用户id："+claims.get("id"));
        System.out.println("创建："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.get("created")));
        System.out.println("用户名："+claims.getSubject());
//        System.out.println("登录时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("用户角色："+claims.get("role"));
    }
}
