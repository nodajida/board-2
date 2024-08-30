package com.sparta.board11.dto.board.request;

import lombok.Getter;

@Getter
public class BoardSaveRequestDto {

    private String title;
    private String contents;
    private String username;
}
