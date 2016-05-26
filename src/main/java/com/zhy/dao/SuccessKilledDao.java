package com.zhy.dao;

import com.zhy.bean.SuccessKilled;
import org.apache.ibatis.annotations.Param;

public interface SuccessKilledDao {

    /**
     * 插入购买明细，可以排重
     *
     * @param seckilled
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    SuccessKilled queryByIdWithSeckill(@Param("seckillId") Long seckillId, @Param("userPhone") long userPhone);
}
