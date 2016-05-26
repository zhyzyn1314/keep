package com.zhy.service;

import com.zhy.bean.Seckill;
import com.zhy.dto.Exposer;
import com.zhy.dto.SeckillExecution;
import com.zhy.exception.seckill.SeckillCloseException;
import com.zhy.exception.seckill.SeckillException;

import java.util.List;

public interface SeckillService {

    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个记录
     *
     * @return
     */
    Seckill getSeckillById(long seckillId);

    /**
     * 秒杀开始时候输出秒杀接口地址
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution excuteSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, SeckillException;
}
