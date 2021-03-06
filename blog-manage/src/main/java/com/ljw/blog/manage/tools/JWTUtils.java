package com.ljw.blog.manage.tools;

import com.ljw.blog.common.model.SysUser;
import com.ljw.blog.common.tools.MapTransformUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static com.ljw.blog.common.constant.JwtCon.*;

/**
 * @Author: lujunwei
 * @Date: 14:41 2019/5/1
 * @Desc:
 */
public class JWTUtils {

    /**
     * 创建JWT
     */
    public static String createJWT(Map<String, Object> claims, Long time) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        Date now = new Date(System.currentTimeMillis());

        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();//生成JWT的时间
        //下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder() //这里其实就是new一个JwtBuilder，设置jwt的body
                .setClaims(claims)          //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setId(JWT_ID)                  //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setIssuer("ROOT")
                .setIssuedAt(now)           //iat: jwt的签发时间
                //.setSubject()             // sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .signWith(signatureAlgorithm, secretKey);//设置签名使用的签名算法和签名使用的秘钥
        if (time >= 0) {
            long expMillis = nowMillis + time;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);     //设置过期时间
        }
        return builder.compact();
    }

    /**
     * 验证jwt
     */
    public static Claims verifyJwt(String token) {
        //签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey();
        Claims claims;
        try {
            claims = Jwts.parser()  //得到DefaultJwtParser
                    .setSigningKey(key)//设置签名的秘钥
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;

    }


    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.decodeBase64(JWT_SECRET);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    /**
     * 根据userId和openid生成token
     */
    public static String generateToken(SysUser sysUser) {
        Map<String,Object> claims = new HashMap<>();
        claims.put(JWT_TOKEN_SYS_USER_ID,sysUser.getId());
        return createJWT(claims, TOKEN_EXPIRED_TIME);
    }



    public static void main(String[] args) {
        SysUser sysUser = new SysUser();
        sysUser.setId(20190016);
        String s = generateToken(sysUser);
        //System.out.println(s);
         Claims claims = verifyJwt("eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJST09UIiwiand0VG9rZW5TeXNVc2VySWQiOjIwMTkwMDE2LCJleHAiOjE1NTcyOTg4MTgsImlhdCI6MTU1NzI5ODgxMiwianRpIjoiYTQyMTkyYWQtNTcxMi00Yjg5LWFlM2EtOTBhNDI4OGM1MTRiIn0.b4k075yJhqTFDAO7G_vIxZOybycjeAcfqlECMct6XGA\n");
        System.out.println(claims);
        //claims.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRED_TIME));
    }
}
