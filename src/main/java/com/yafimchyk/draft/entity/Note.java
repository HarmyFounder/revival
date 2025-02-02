package com.yafimchyk.draft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;
    String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Внешний ключ
    private MyUser user;

}
