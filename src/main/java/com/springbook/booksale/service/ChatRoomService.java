package com.springbook.booksale.service;


import com.springbook.booksale.entity.ChatroomEntity;

public interface ChatRoomService {
    ChatroomEntity createChatroom(ChatroomEntity chatroomEntity);
    ChatroomEntity getAllChatroom(int pageNo, int pageSize, String sortBy, String sortDir);
    ChatroomEntity getChatroomById(long id);
    void deleteChatroomById(long id);
    ChatroomEntity updateChatroom(ChatroomEntity chatroomEntity, long id);
}
