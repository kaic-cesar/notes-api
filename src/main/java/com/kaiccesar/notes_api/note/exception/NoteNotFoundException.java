package com.kaiccesar.notes_api.note.exception;

public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(Long id){
        super("Note not found with id: " + id);
    }
}
