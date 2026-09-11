package com.kaiccesar.notes_api.note.controller;

import com.kaiccesar.notes_api.note.dto.NoteRequestDTO;
import com.kaiccesar.notes_api.note.dto.NoteResponseDTO;
import com.kaiccesar.notes_api.note.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    @Autowired
    NoteService service;

    @GetMapping
    public ResponseEntity<List<NoteResponseDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<NoteResponseDTO> create(@Valid @RequestBody NoteRequestDTO requestDTO){
        NoteResponseDTO responseDTO = service.create(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody NoteRequestDTO requestDTO
    ){
        NoteResponseDTO responseDTO = service.update(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
