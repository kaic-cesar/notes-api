package com.kaiccesar.notes_api.note.controller;

import com.kaiccesar.notes_api.note.dto.NoteRequestDTO;
import com.kaiccesar.notes_api.note.dto.NoteResponseDTO;
import com.kaiccesar.notes_api.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    @Autowired
    NoteService service;

    @PostMapping
    public ResponseEntity<NoteResponseDTO> create(@RequestBody NoteRequestDTO requestDTO){
        NoteResponseDTO responseDTO = service.create(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
