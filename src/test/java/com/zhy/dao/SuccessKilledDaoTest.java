package com.zhy.dao;

import com.zhy.bean.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void testInsertSuccessKilled() throws Exception {
        long id = 1000L;
        long userPhone = 18500936025L;
        int insertCount = successKilledDao.insertSuccessKilled(id, userPhone);
        System.out.println("insertCount:" + insertCount);
    }

    @Test
    public void testQueryByIdWithSeckill() throws Exception {
        long id = 1000L;
        long userPhone = 18500936025L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, userPhone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}