package com.yafimchyk.draft.service;

import com.yafimchyk.draft.dto.NoteDTO;
import com.yafimchyk.draft.entity.Note;
import com.yafimchyk.draft.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {


    private final NoteRepository noteRepository;

    public Note create(NoteDTO noteDTO) {
        Note note = Note.builder()
                .name(noteDTO.getName())
                .content(noteDTO.getContent())
                .build();

        return noteRepository.save(note);
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
