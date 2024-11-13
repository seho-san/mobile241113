package com.example.demo12.controller;

import com.example.demo12.dto.ItemDTO;
import com.example.demo12.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class IndexController {

    public IndexController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }

    @PostMapping(value = "/param3")
    public String jsonexample(@RequestBody ItemDTO item, Model model) {
        model.addAttribute("itemname", item.getItemname());
        model.addAttribute("itemprice", item.getItemprice());

        return "/thymeleaf/param6re";
    }
    @Autowired
    private final MemberService memberService;
}
