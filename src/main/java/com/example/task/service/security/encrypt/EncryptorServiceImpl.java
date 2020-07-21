package com.example.task.service.security.encrypt;

import com.example.task.exception.EncryptorException;
import com.example.task.service.security.key.AesKeyGenerator;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

@Service
public class EncryptorServiceImpl implements EncryptorService {

    @Override
    public String encrypt(String data) {
        Key key = AesKeyGenerator.generateKey();
        try {
            Cipher cipher = Cipher.getInstance(AesKeyGenerator.ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedValue = cipher.doFinal(data.getBytes());
            return new BASE64Encoder().encode(encryptedValue);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |
                BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            throw new EncryptorException("Can not encrypt data " + data);
        }
    }
}
