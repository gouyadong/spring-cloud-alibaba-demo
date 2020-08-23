package com.vdcloud.service;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gouyadong
 */
@Slf4j
public class BlockHandler {
    public static String blockHandler(BlockException ex) {
        log.error("{}", ex);
        return "接口被限流或者降级了...";
    }
}
