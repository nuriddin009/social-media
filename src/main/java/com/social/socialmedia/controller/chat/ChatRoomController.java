package com.social.socialmedia.controller.chat;

import com.social.socialmedia.entity.message.PrivateMessage;
import com.social.socialmedia.payload.response.ChatNotification;
import com.social.socialmedia.service.message.PrivateMessageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ChatRoomController {

    private final SimpMessagingTemplate messagingTemplate;
    private final PrivateMessageServiceImpl privateMessageService;


    @MessageMapping("/chat")
    public void processMessage(@Payload PrivateMessage message) {
        PrivateMessage save = privateMessageService.save(message);
        messagingTemplate.convertAndSendToUser(
                save.getRecipient().getId().toString(), "/queue/messages",
                new ChatNotification(
                        message.getId(),
                        message.getSender().getId(),
                        message.getRecipient().getId(),
                        message.getText()
                )
        );
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<PrivateMessage>> findChatMessages(@PathVariable UUID senderId,
                                                                 @PathVariable UUID recipientId) {
        return ResponseEntity
                .ok(privateMessageService.findChatMessages(senderId, recipientId));
    }

}
