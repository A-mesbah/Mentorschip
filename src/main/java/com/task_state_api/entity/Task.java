package com.task_state_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    @Id
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "STATE")
    private State state = State.DRAFT;
}
