package com.social.socialmedia.entity.message;


import com.social.socialmedia.entity.chat.PrivateChat;
import com.social.socialmedia.entity.template.BaseEntity;
import com.social.socialmedia.entity.user.User;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class PrivateMessage {

    @Id
    private String id;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User recipient;
    private String text;
    private String chatId;
}
