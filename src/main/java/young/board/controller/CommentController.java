package young.board.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import young.board.dto.BoardDto;
import young.board.dto.CommentDto;
import young.board.service.BoardService;
import young.board.service.CommentService;

import java.util.List;

@Controller
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final BoardService boardService;

    //댓글 리스트 조회
    @GetMapping("/post/{boardID}/comment")
    public void comList(Model model) {
        List<CommentDto> commentList = commentService.getCommentList();

        model.addAttribute("commentList", commentList);

    }

    //댓글 추가하기
    @PostMapping("/post/{boardID}/comment")
    public void writeCom(@PathVariable Long boardID, @RequestBody CommentDto commentDto) {
        commentService.saveComment(boardID, commentDto);


    }

    //댓글 수정하기
    @PutMapping("/post/{boardID}/comment/{commentID}")
    public void updateCom(@PathVariable Long boardID,@PathVariable Long commentID,
                            @RequestBody Model model) {

        CommentDto commentDto = commentService.getComment(commentID);

        commentService.saveComment(boardID, commentDto);
    }

    //댓글 삭제
    @DeleteMapping("/post/{boardID}/comment/{commentID}")
    public void deleteCom(@PathVariable Long commentID) {
        commentService.deleteComment(commentID);
    }


}
