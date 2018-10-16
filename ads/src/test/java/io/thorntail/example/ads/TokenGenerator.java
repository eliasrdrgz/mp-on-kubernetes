package io.thorntail.example.ads;

import io.smallrye.jwt.KeyUtils;
import org.jboss.shrinkwrap.impl.base.io.IOUtil;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;
import java.security.PrivateKey;

/**
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 10/13/18
 */
public class TokenGenerator {

    @Test
    @Ignore
    public void generateToken() throws Exception {
        System.out.println(createToken("ad-admin"));
    }

    public static final String SUBJECT = "24400320";

    public static String createToken(String groupName) throws Exception {
        JwtClaims claims = new JwtClaims();
        claims.setIssuer("http://server.example.com");
        claims.setSubject(SUBJECT);
        claims.setStringListClaim("groups", groupName);
        claims.setClaim("upn", "jdoe@example.com");
        // WARNING: do not use expiration dates so far in the future in real world
        claims.setExpirationTimeMinutesInTheFuture(24 * 60 * 20);

        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        jws.setKey(getPrivateKey());
        return jws.getCompactSerialization();
    }

    private static PrivateKey getPrivateKey() throws Exception {
        InputStream is = TokenGenerator.class.getResourceAsStream("/jwt-keys/privateKey.pem");
        return KeyUtils.decodePrivateKey(new String(IOUtil.asByteArray(is)));
    }
}
