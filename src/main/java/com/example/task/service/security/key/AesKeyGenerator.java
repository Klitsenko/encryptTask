package com.example.task.service.security.key;

import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

@Component
public class AesKeyGenerator {
    public static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "1234567891234567";

    public static Key generateKey() {
        byte[] keyValue = SECRET_KEY.getBytes();
        return new SecretKeySpec(keyValue, ALGORITHM);
    }
}
