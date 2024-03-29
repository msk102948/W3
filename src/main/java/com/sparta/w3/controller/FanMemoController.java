package com.sparta.w3.controller;

import com.sparta.w3.model.FanMemo;
import com.sparta.w3.model.FanMemoRepository;
import com.sparta.w3.model.FanMemoRequestDto;
import com.sparta.w3.service.FanMemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class FanMemoController {
    private final FanMemoRepository fanMemoRepository;
    private final FanMemoService fanMemoService;

    @GetMapping("/")
    public String memoList(Model model){
        model.addAttribute("memos",fanMemoService.memoList());
        return "index";
    }

    @GetMapping("/fanmemo")
    public String writeForm(){
        return "write-form";
    }

    @PostMapping("/fanmemo")
    public String postMemo(@RequestBody FanMemoRequestDto requestDto){
        FanMemo fanMemo = new FanMemo(requestDto);
        fanMemoRepository.save(fanMemo);
        return "redirect:/";
    }

    @GetMapping("/view/")
    public String boardView(Model model, Long id){
        model.addAttribute("memo",fanMemoService.fanmemoView(id));
        return "view";
    }


}

