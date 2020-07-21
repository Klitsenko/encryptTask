package com.example.task.service.security.decrypt;

import com.example.task.exception.DecryptorException;
import com.example.task.service.security.key.AesKeyGenerator;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

@Service
public class DecryptorServiceImpl implements DecryptorService {

    @Override
    public String decrypt(String data) {
        Key key = AesKeyGenerator.generateKey();
        try {
            Cipher cipher = Cipher.getInstance(AesKeyGenerator.ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedValue = new BASE64Decoder().decodeBuffer(data);
            return new String(cipher.doFinal(decodedValue));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                IOException | BadPaddingException | IllegalBlockSizeException e) {
            throw new DecryptorException("Can not decrypt data " + data);
        }
    }
}
