package com.springbook.booksale.service;

import com.springbook.booksale.entity.ChatdetailEntity;

public interface ChatDetailService {
    ChatdetailEntity createChatDetail(ChatdetailEntity chatdetailEntity);
    ChatdetailEntity getAllChatDetail(int pageNo, int pageSize, String sortBy, String sortDir);
    ChatdetailEntity getChatDetailById(long id);
    void deleteChatDetailById(long id);
    ChatdetailEntity updateChatDetail(ChatdetailEntity chatdetailEntity, long id);
}
