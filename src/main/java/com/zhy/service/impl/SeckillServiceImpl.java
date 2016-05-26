package com.zhy.service.impl;

import com.zhy.bean.Seckill;
import com.zhy.dao.SeckillDao;
import com.zhy.dao.SuccessKilledDao;
import com.zhy.dto.Exposer;
import com.zhy.dto.SeckillExecution;
import com.zhy.exception.seckill.SeckillCloseException;
import com.zhy.exception.seckill.SeckillException;
import com.zhy.service.SeckillService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/20.
 */
public class SeckillServiceImpl implements SeckillService {

    private static Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);

    @Resource
    private SeckillDao seckillDao;

    @Resource
    private SuccessKilledDao successKilledDao;

    private final String salt = "zhyzyn13142016^jh";

    @Override
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 4);
    }

    @Override
    public Seckill getSeckillById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    @Override
    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }
        long startTime = seckill.getStartTime().getTime();
        long endTime = seckill.getEndTime().getTime();
        long nowTime = new Date().getTime();
        if(nowTime > endTime || nowTime < startTime){
            return new Exposer(false, seckillId, startTime, endTime, nowTime);
        }
        // md5 不可逆
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    private String getMD5(long seckillId){
        String base = seckillId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    public SeckillExecution excuteSeckill(long seckillId, long userPhone, String md5) throws SeckillException, SeckillCloseException, SeckillException {
        return null;
    }
}
