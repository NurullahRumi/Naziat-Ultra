package com.projects.naziat.ultra.entity;

import com.projects.naziat.ultra.constant.AppConstant;
import com.projects.naziat.ultra.constant.EntityConstant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", nullable = false, updatable = false)
    private UUID id;

    @CreatedDate
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @CreatedBy
    @Column(name = "created_by",updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @LastModifiedBy
    @Column(name = "update_by")
    private String updateBy;

    @PrePersist
    void onCreate(){
        this.createdAt = OffsetDateTime.now();
        if (this.createdBy == null){
            this.createdBy = AppConstant.ANONYMOUS_USER;
        }
    }

    @PreUpdate
    void onUpdate(){
        this.updatedAt = OffsetDateTime.now();
    }
}
