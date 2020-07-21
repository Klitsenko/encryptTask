package com.example.task.log;

import com.example.task.exception.RequestExecutionException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Component
public class LoggingInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger LOG = Logger.getLogger(LoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(
            HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution requestExecution) {
        try {
            logRequest(httpRequest, body);
            ClientHttpResponse response = requestExecution.execute(httpRequest, body);
            logResponse(response);
            return response;
        } catch (IOException e) {
            throw new RequestExecutionException("Can not execute request");
        }
    }

    public void logRequest(HttpRequest httpRequest, byte[] body) {
        LOG.debug("Request method: {}" + httpRequest.getMethod());
        LOG.debug("Request body  : {}" + new String(body, StandardCharsets.UTF_8));
    }

    public void logResponse(ClientHttpResponse httpResponse) throws IOException {
        LOG.debug("Response body: {}" +
                StreamUtils.copyToString(httpResponse.getBody(), Charset.defaultCharset()));
    }
}
