package com.sparta.board11.service;

import com.sparta.board11.dto.comment.response.CommentSaveResponseDto;
import com.sparta.board11.dto.comment.response.CommentResponseDto;
import com.sparta.board11.dto.comment.request.CommentSaveRequestDto;
import com.sparta.board11.entity.Board;
import com.sparta.board11.entity.Comment;
import com.sparta.board11.repository.BoardRepository;
import com.sparta.board11.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long boardId, CommentSaveRequestDto commentSaveRequestDto) {

        Board board = boardRepository.findById(boardId).orElseThrow(() -> new NullPointerException("아 보드 없다고"));

        Comment newComment = new Comment(commentSaveRequestDto.getContents(), board);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getContents());
    }

    public List<CommentResponseDto> getComments() {
        List<Comment> commentList = commentRepository.findAll();

        List<CommentResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            dtoList.add(new CommentResponseDto(comment.getId(), comment.getContents()));
        }
        return dtoList;
    }
}
