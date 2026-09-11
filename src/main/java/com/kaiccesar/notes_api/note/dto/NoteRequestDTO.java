package com.kaiccesar.notes_api.note.dto;

import jakarta.validation.constraints.NotBlank;

public record NoteRequestDTO(

        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Content is required")
        String content
) { }
