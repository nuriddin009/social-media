package com.social.socialmedia.repository;

import com.social.socialmedia.entity.chat.PrivateChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PrivateChatRepository extends JpaRepository<PrivateChat, UUID> {
    Optional<PrivateChat> findBySenderIdAndRecipientId(UUID senderId, UUID recipientId);
}
