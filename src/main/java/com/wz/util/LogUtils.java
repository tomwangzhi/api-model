package com.wz.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtils {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static void doAfterReturning(Object ret) {
        try {
            String returenJson = objectMapper.writeValueAsString(ret);
            log.info(returenJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
