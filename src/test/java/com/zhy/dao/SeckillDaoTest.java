package com.zhy.dao;

import com.zhy.bean.Seckill;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 配置spring和junit整合，junit启动时加载spring ioc容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 告诉spring配置文件位置
 */
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class SeckillDaoTest extends TestCase {

    @Resource
    private SeckillDao seckillDao;

    @Test
    public void testReduceNumber() throws Exception {
        long id = 1000;
        int result = seckillDao.reduceNumber(id, new Date());
        System.out.println(result);
    }

    @Test
    public void testQueryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill);
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0, 10);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }
}