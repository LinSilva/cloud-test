package com.lxh.common.utils;

import com.lxh.common.auth.ResponseCode;
import io.jsonwebtoken.*;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

/**
 * User: LinXiaoHui
 * Date: 2018/5/2
 */
public class JWTUtils {
    private static final int EXPIRES = 7200000;
    private static final RSAPublicKey PUBLIC_KEY = RSAUtils.getPublicKey();
    private static final RSAPrivateKey PRIVATE_KEY = RSAUtils.getPrivateKey();

    private JWTUtils(){}

    public static String getToken(String id){
        long expire = System.currentTimeMillis() + EXPIRES;
        return Jwts.builder().setSubject(id)
                .setExpiration(new Date(expire))
                .signWith(SignatureAlgorithm.RS512, PRIVATE_KEY).compact();
    }

    public static JWTResult checkToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(PUBLIC_KEY).parseClaimsJws(token).getBody();
            String sub = claims.get("sub", String.class);
            return new JWTResult(true, sub, "合法请求", ResponseCode.SUCCESS_CODE.getCode());
        } catch (ExpiredJwtException e) {
            // 在解析JWT字符串时，如果‘过期时间字段’已经早于当前时间，将会抛出ExpiredJwtException异常，说明本次请求已经失效
            return new JWTResult(false, null, "token已过期", ResponseCode.TOKEN_TIMEOUT_CODE.getCode());
        } catch (SignatureException e) {
            // 在解析JWT字符串时，如果密钥不正确，将会解析失败，抛出SignatureException异常，说明该JWT字符串是伪造的
            return new JWTResult(false, null, "非法请求", ResponseCode.NO_AUTH_CODE.getCode());
        } catch (Exception e) {
            return new JWTResult(false, null, "非法请求", ResponseCode.NO_AUTH_CODE.getCode());
        }
    }

    public static class JWTResult {
        private boolean status;
        private String uid;
        private String msg;
        private int code;

        public JWTResult() {
            super();
        }

        public JWTResult(boolean status, String uid, String msg, int code) {
            super();
            this.status = status;
            this.uid = uid;
            this.msg = msg;
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
