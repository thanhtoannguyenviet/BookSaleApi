package com.springbook.booksale.service.impl;

import com.springbook.booksale.entity.ChatroomEntity;
import com.springbook.booksale.repository.ChatRoomResponsitory;
import com.springbook.booksale.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatRoomServiceImpl implements ChatRoomService {
    @Autowired
    ChatRoomResponsitory chatRoomResponsitory;

    @Override
    public ChatroomEntity createChatroom(ChatroomEntity chatroomEntity) {
        return chatRoomResponsitory.save(chatroomEntity);
    }

    @Override
    public ChatroomEntity getAllChatroom(int pageNo, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public ChatroomEntity getChatroomById(long id) {
        return null;
    }

    @Override
    public void deleteChatroomById(long id) {

    }

    @Override
    public ChatroomEntity updateChatroom(ChatroomEntity chatroomEntity, long id) {
        return null;
    }
}
