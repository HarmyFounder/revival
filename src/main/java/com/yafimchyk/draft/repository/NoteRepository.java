package com.yafimchyk.draft.repository;

import com.yafimchyk.draft.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.InterfaceAddress;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
