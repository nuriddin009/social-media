package com.social.socialmedia.repository;

import com.social.socialmedia.entity.message.PrivateMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrivateMessageRepository extends MongoRepository<PrivateMessage, String> {

    List<PrivateMessage> findByChatId(String chatId);
}
