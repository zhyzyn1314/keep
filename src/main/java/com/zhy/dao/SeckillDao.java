package com.zhy.dao;


import com.zhy.bean.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SeckillDao {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber (@Param("seckillId")long seckillId, @Param("killTime")Date killTime);

    /**
     * 查询单个秒杀
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 查询秒杀列表
     * @param offet
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offet")int offet, @Param("limit")int limit);
}
