package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Module {

    @Id
    @GeneratedValue
    private Long id;
    private String moduleUUID;

}
