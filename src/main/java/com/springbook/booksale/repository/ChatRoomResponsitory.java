package com.springbook.booksale.repository;

import com.springbook.booksale.entity.ChatroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomResponsitory extends JpaRepository<ChatroomEntity, Long> {
}

