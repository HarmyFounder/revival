package com.yafimchyk.draft.service;

import com.yafimchyk.draft.dto.NoteDTO;
import com.yafimchyk.draft.entity.MyUser;
import com.yafimchyk.draft.entity.Note;
import com.yafimchyk.draft.repository.MyUserRepository;
import com.yafimchyk.draft.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {


    private final MyUserRepository myUserRepository;

    private final NoteRepository noteRepository;

    public Note create(NoteDTO noteDTO) {

        MyUser user = myUserRepository.findById(noteDTO.getUserId()).get();

        Note note = Note.builder()
                .name(noteDTO.getName())
                .content(noteDTO.getContent())
                .user(user)
                .build();

        return noteRepository.save(note);
    }

    public List<Note> findAllByUser(MyUser user) {
        return noteRepository.findByUser(user);
    }

    public List<Note> getAll(){
        return noteRepository.findAll();
    }

    public Note getById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note update(Note note) {
        return noteRepository.save(note);
    }

    public void delete(Long id) {
        noteRepository.deleteById(id);
    }



}
