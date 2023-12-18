package com.example.quote.model;

import com.example.quote.model.common.AuditEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Quote extends AuditEntity {
    @NotBlank
    private String quote;
    @ManyToOne
    private UserAccount user;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Vote vote;
}