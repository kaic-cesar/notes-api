package com.kaiccesar.notes_api.note.dto;

import java.time.LocalDateTime;

public record NoteResponseDTO(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) { }
