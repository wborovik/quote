package com.example.quote.model.common;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
//import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity extends AbstractEntity {
    @NotNull
    @CreatedDate
    private LocalDateTime created;
    //    @Audited
    @LastModifiedDate
    private LocalDateTime changed;

    @PrePersist
    private void prePersist() {
        if (Objects.nonNull(changed) && changed.equals(created)) {
            changed = null;
        }
    }

    @PreUpdate
    private void preUpdate() {
        prePersist();
    }
}