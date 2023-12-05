package com.social.socialmedia.service.message;

import com.social.socialmedia.entity.message.PrivateMessage;
import com.social.socialmedia.repository.PrivateMessageRepository;
import com.social.socialmedia.service.demo.PrivateMessageService;
import com.social.socialmedia.service.impl.chat.PrivateChatServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PrivateMessageServiceImpl implements PrivateMessageService {

    private final PrivateMessageRepository privateMessageRepository;
    private final PrivateChatServiceImpl privateChatService;

    public PrivateMessage save(PrivateMessage chatMessage) {
        var chatId = privateChatService
                .getChatRoomId(chatMessage.getSender().getId(), chatMessage.getRecipient().getId(), true)
                .orElseThrow();
        chatMessage.setChatId(chatId);
        privateMessageRepository.save(chatMessage);
        return chatMessage;
    }

    public List<PrivateMessage> findChatMessages(UUID senderId, UUID recipientId) {
        var chatId = privateChatService.getChatRoomId(senderId, recipientId, false);
        return chatId.map(privateMessageRepository::findByChatId).orElse(new ArrayList<>());
    }


}
