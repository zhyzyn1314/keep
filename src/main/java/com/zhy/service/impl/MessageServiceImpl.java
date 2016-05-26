package com.zhy.service.impl;

import com.zhy.bean.Message;
import com.zhy.dao.MessageDao;
import com.zhy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService{

    @Autowired
    public MessageDao messageDao;

    @Override
    public List<Message> getMessage() {
        return messageDao.getMessage();
    }
}
