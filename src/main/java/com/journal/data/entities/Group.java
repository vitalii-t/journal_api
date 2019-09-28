package com.journal.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupId_generator")
    private Long id;

    private String identifier;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "group")
    private List<User> users;

}