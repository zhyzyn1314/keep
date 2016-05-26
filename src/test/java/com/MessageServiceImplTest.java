package com;

import com.zhy.bean.Message;
import com.zhy.service.MessageService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml", "classpath:spring/spring-mybatis.xml" })
public class MessageServiceImplTest extends TestCase {

    @Autowired
    private MessageService messageService;

    @Test
    public void testGetMessage() throws Exception {
        List<Message> messages = messageService.getMessage();
        for (Message message : messages) {
            System.out.println(message.toString());
        }
    }
}