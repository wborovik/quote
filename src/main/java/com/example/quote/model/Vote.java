package com.example.quote.model;

import com.example.quote.model.common.AuditEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
//import org.hibernate.envers.Audited;

@Getter
@Setter
@Entity
//@Audited
public class Vote extends AuditEntity {
    private int vote = 0;
}