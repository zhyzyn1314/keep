package com.zhy.exception.seckill;

/**
 * 秒杀已经关闭
 * Created by Administrator on 2016/5/20.
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
