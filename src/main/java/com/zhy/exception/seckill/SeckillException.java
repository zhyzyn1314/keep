package com.zhy.exception.seckill;

/**
 * Created by Administrator on 2016/5/20.
 */
public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
