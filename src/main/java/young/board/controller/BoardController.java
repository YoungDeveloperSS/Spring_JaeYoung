package young.board.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import young.board.dto.BoardDto;
import young.board.service.BoardService;
import young.board.service.LikeService;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final LikeService likeService;

    //게시글 목록 출력
    //Model 객체를 통해 view에 데이터 전달
    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardlist();

        model.addAttribute("boardList", boardList);
        return "board/list";
    }

    //게시글 추가 페이지
    @GetMapping("/post")
    public String write() {
        return "board/write";
    }

    //게시글 추가 후 저장하고 초기 페이지로 돌아감
    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";
    }

    //게시글 상세 조회
    @GetMapping("/post/{num}")
    public String detail(@PathVariable("num") Long num, Model model) {
        BoardDto boardDto = boardService.getPost(num);
        model.addAttribute("boardDto", boardDto);
        return "board/detail";
    }

    //게시글 수정 페이지
    //update.html을 반환해야 함
    @GetMapping("/post/edit/{num}")
    public String edit(@PathVariable("num") Long num, Model model) {
        BoardDto boardDto = boardService.getPost(num);
        model.addAttribute("boardDto", boardDto);
        return "board/update";
    }

    //게시글 수정 후 저장하고 초기 페이지로 돌아가기
    @PutMapping("/post/edit/{num}")
    public String update(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";
    }

    //게시글 삭제
    @DeleteMapping("/post/{num}")
    public String delete(@PathVariable("num") Long num) {
        boardService.deletePost(num);
        return "redirect:/";
    }

    //게시글 검색
    @GetMapping("/board/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model) {
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);
        model.addAttribute("boardList", boardDtoList);

        return "board/list";
    }

    //좋아요 누르기
    @GetMapping("/post/like/{num}")
    public String like(@PathVariable Long num) {
        likeService.addLike(num);

        return "redirect:/post/" + num;
    }
}
