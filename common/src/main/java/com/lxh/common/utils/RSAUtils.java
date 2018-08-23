package com.lxh.common.utils;

import sun.security.rsa.RSAKeyFactory;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 * User: LinXiaoHui
 * Date: 2018/5/2
 */
public class RSAUtils {
    private static final String MODULUS = "120749774428185480467622030722535804071445078993623309709775427878906293937338059423076695854937532244466465395164541641368876529295825453848760144835049363522545908104302024165873971414491110512342791594610742544380402908598585190494003507524195754273822268813447403290817343077571516216147839402414940310061";

    private static final String PUBLIC_EXPONENT = "65537";

    private static final String PRIVATE_EXPONENT = "73923469942286919561803730971048133587965873619209827001168953680477872428610977313161774128992838682156392947263251899461404460204267953359475632559803617319478756560848229397545070273747796303141458040475889804016062973476403760709402857872540300632704514872361476749953797952016730690123983122643596231873";

    private RSAUtils(){}

    public static RSAPrivateKey getPrivateKey(){
        try {
            BigInteger modulus = new BigInteger(MODULUS);
            BigInteger privateExponent = new BigInteger(PRIVATE_EXPONENT);
            return (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new RSAPrivateKeySpec(modulus, privateExponent));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static RSAPublicKey getPublicKey(){
        try {
            BigInteger modulus = new BigInteger(MODULUS);
            BigInteger publicExponent = new BigInteger(PUBLIC_EXPONENT);
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(modulus, publicExponent));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
