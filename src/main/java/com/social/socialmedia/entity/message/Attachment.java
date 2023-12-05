package com.social.socialmedia.entity.message;

import com.social.socialmedia.entity.template.BaseEntity;
import com.social.socialmedia.entity.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Attachment extends BaseEntity {

    @ManyToOne
    private User user;
    @Column(name = "object_name")
    private String objectName;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "size")
    private Long size;
    @Column(name = "url", columnDefinition = "varchar")
    private String url;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
