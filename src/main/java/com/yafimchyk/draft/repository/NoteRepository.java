package com.yafimchyk.draft.repository;

import com.yafimchyk.draft.entity.MyUser;
import com.yafimchyk.draft.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.InterfaceAddress;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUser(MyUser user);
}
