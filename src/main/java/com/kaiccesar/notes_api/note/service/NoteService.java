package com.kaiccesar.notes_api.note.service;

import com.kaiccesar.notes_api.note.dto.NoteRequestDTO;
import com.kaiccesar.notes_api.note.dto.NoteResponseDTO;
import com.kaiccesar.notes_api.note.model.NoteModel;
import com.kaiccesar.notes_api.note.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository repository;

    public List<NoteResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(noteModel -> new NoteResponseDTO(
                        noteModel.getId(),
                        noteModel.getTitle(),
                        noteModel.getContent(),
                        noteModel.getCreateAt(),
                        noteModel.getUpdateAt()
                ))
                .toList();
    }

    public NoteResponseDTO create(NoteRequestDTO requestDTO){
        NoteModel note = new NoteModel();

        note.setTitle(requestDTO.title());
        note.setContent(requestDTO.content());
        note.setCreateAt(LocalDateTime.now());

        NoteModel createdNote = repository.save(note);

        return new NoteResponseDTO(
                createdNote.getId(),
                createdNote.getTitle(),
                createdNote.getContent(),
                createdNote.getCreateAt(),
                createdNote.getUpdateAt()
        );
    }
}
