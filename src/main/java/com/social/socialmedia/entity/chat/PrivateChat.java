package com.social.socialmedia.entity.chat;

import com.social.socialmedia.entity.template.BaseEntity;
import com.social.socialmedia.entity.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class PrivateChat extends BaseEntity {
    @ManyToOne
    private User sender;
    @ManyToOne
    private User recipient;
    private String chatId;
}
