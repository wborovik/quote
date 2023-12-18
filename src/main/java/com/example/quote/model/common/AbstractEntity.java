package com.example.quote.model.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_sequence")
    @SequenceGenerator(name = "global_sequence", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
}