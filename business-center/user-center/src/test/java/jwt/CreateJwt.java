package jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreateJwt {
    public static void main(String[] args) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", "小马2");
        claims.put("created",new Date() );
        claims.put("id","111");
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 600 * 1000))
                .signWith(SignatureAlgorithm.HS512, "itcast");
        System.out.println(jwtBuilder.compact());
    }
}
