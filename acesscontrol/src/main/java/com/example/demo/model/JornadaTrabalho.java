package com.example.demo.model;



import lombok.*;
//import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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

public class JornadaTrabalho {
    @Id
    @GeneratedValue
    private long id;
    private String descricao;
}

