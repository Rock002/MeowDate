package com.example.MeowDate.repository;

import com.example.MeowDate.models.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    @Query("SELECT m FROM ChatMessage m WHERE (m.senderId = :user1Id AND m.receiverId = :user2Id) " +
            "OR (m.senderId = :user2Id AND m.receiverId = :user1Id) ORDER BY m.timestamp ASC")
    List<ChatMessage> findChatBetweenUsers(@Param("user1Id") Long user1Id,
                                           @Param("user2Id") Long user2Id);

//    List<ChatMessage> findUnreadMessages(@Param("userId") Long userId);
//
//    List<ChatMessage> findRecentChats(@Param("userId") Long userId);
//
//    Long countOfUnreadMessages(@Param("senderId") Long senderId,
//                               @Param("receiverId") Long receiverId);
}
