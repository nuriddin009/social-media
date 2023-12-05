package com.social.socialmedia.entity.user;

import com.social.socialmedia.entity.template.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile extends BaseEntity {

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
