package com.javenliu.springcloud.common.id;

import java.util.UUID;

public class IdUtils {
    public static String getObjectId() {
        return UUID.randomUUID().toString();
    }
}
