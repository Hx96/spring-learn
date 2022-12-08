package com.hx.common;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class JSON {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * 解析对象
     *
     * @param json  json
     * @param clazz clazz
     * @return {@link T}
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        return parseObject(OBJECT_MAPPER, json, clazz);
    }

    @SneakyThrows
    public static <T> T parseObject(ObjectMapper objectMapper, String json, Class<T> clazz) {
        return objectMapper.readValue(json, clazz);
    }
}
