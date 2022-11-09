package com.springbook.booksale.service.impl;

import com.springbook.booksale.entity.ChatdetailEntity;
import com.springbook.booksale.repository.ChatDetailRespository;
import com.springbook.booksale.service.ChatDetailService;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatDetailServiceImpl implements ChatDetailService {
    @Autowired
    ChatDetailRespository chatDetailRespository;

    @Override
    public ChatdetailEntity createChatDetail(ChatdetailEntity chatdetailEntity) {
        return null;
    }

    @Override
    public ChatdetailEntity getAllChatDetail(int pageNo, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public ChatdetailEntity getChatDetailById(long id) {
        return null;
    }

    @Override
    public void deleteChatDetailById(long id) {

    }

    @Override
    public ChatdetailEntity updateChatDetail(ChatdetailEntity chatdetailEntity, long id) {
        return null;
    }
}
