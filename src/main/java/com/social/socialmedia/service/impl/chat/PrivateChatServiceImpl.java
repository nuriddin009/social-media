package com.social.socialmedia.service.impl.chat;

import com.social.socialmedia.entity.chat.PrivateChat;
import com.social.socialmedia.entity.user.User;
import com.social.socialmedia.repository.PrivateChatRepository;
import com.social.socialmedia.repository.UserRepository;
import com.social.socialmedia.service.demo.PrivateChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PrivateChatServiceImpl implements PrivateChatService {


    private final PrivateChatRepository privateChatRepository;
    private final UserRepository userRepository;

    public Optional<String> getChatRoomId(
            UUID senderId,
            UUID recipientId,
            boolean createNewRoomIfNotExists
    ) {
        return privateChatRepository.findBySenderIdAndRecipientId(senderId, recipientId)
                .map(PrivateChat::getChatId)
                .or(() -> {
                    if ( createNewRoomIfNotExists ) {
                        var chatId = createChatId(senderId, recipientId);
                        return Optional.of(chatId);
                    }

                    return Optional.empty();
                });
    }

    private String createChatId(UUID senderId, UUID recipientId) {
        var chatId = String.format("%s_%s", senderId, recipientId);
        User user1 = userRepository.findById(senderId).orElseThrow();
        User user2 = userRepository.findById(recipientId).orElseThrow();


        privateChatRepository.save(PrivateChat.builder()
                .chatId(chatId)
                .sender(user1)
                .recipient(user2)
                .build());

        privateChatRepository.save(PrivateChat.builder()
                .chatId(chatId)
                .sender(user2)
                .recipient(user1)
                .build());

        return chatId;
    }


}
