package com.vdcloud.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gouyadong
 */
@Slf4j
public class FallBackHandler {

    public static String fallback(Throwable ex) {
        log.error("{}", ex);
        return "接口发生异常了...";
    }
}
