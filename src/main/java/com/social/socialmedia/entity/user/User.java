package com.social.socialmedia.entity.user;

import com.social.socialmedia.entity.constants.UserStatus;
import com.social.socialmedia.entity.template.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User extends BaseEntity {

    @Size(max = 64)
    @Column(nullable = false)
    private String firstname;
    @Size(max = 64)
    private String lastname;
    @Column(unique = true)
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @OneToOne(fetch = FetchType.LAZY)
    private UserProfile userProfile;
}
