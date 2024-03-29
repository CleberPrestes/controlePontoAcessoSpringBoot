package com.example.demo.model;

import lombok.*;
//import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class NivelAcesso {
    @Id
    private long id;
    private String descricao;
}
