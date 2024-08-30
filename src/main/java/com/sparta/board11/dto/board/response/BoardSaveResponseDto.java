package com.sparta.board11.dto.board.response;

import lombok.Getter;

import java.util.List;

@Getter
public class BoardSaveResponseDto {
    private final String contents;
    private final Long id;
    private final String title;

    public BoardSaveResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
