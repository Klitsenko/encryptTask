package com.example.task.service.log;

import com.example.task.service.security.decrypt.DecryptorService;
import com.example.task.service.security.encrypt.EncryptorService;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LoggingServiceImpl implements LoggingService {
    private static final Logger LOG = Logger.getLogger(LoggingServiceImpl.class);

    private EncryptorService encryptorService;
    private DecryptorService decryptorService;

    public LoggingServiceImpl(EncryptorService encryptorService, DecryptorService decryptorService) {
        this.encryptorService = encryptorService;
        this.decryptorService = decryptorService;
    }

    @Async
    public void logData(String data) {
        String encrytedData = encryptorService.encrypt(data);
        LOG.debug("Encrypted data = " + encrytedData);
        String decryptedData = decryptorService.decrypt(encrytedData);
        LOG.debug("Decrypted data = " + decryptedData);
    }
}
