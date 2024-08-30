package com.sparta.board11.dto.board.response;

import com.sparta.board11.dto.comment.response.CommentResponseDto;
import com.sparta.board11.entity.Comment;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BoardSimpleResponseDto {

    private final Long id;
    private final String title;
    private final List<CommentResponseDto> comments;

    public BoardSimpleResponseDto(Long id, String title, List<Comment> comments) {
        List<CommentResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : comments) {
            dtoList.add(new CommentResponseDto(comment.getContents(), comment.getId()));
        }
        this.id = id;
        this.title = title;
        this.comments = dtoList;
    }
}
