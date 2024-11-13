package com.example.demo12.controller;

import com.example.demo12.dto.MemberDTO;
import com.example.demo12.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleController5 {

    @Autowired
    private final MemberService memberService;
    //원래 멤버 객체를 new 써서 객체 인스턴스를 만들고 부르던가
    //기존에 생성된 객체가 있으면 불러오던가 해야됨
    //final로 생성한 변수에 객체 정보를 바로 넣어줌

    public SampleController5(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping(value = "sample5")
    public String sample5(Model model) {
/*
        MemberDTO memberdto = new MemberDTO(1, "홍길동", "gdhong", "010-1234-1234");

        ArrayList<MemberDTO> arrlist = new ArrayList<MemberDTO>();
        arrlist.add(memberdto);

 */
        List<MemberDTO> arrlist = memberService.getMemberLists();
        model.addAttribute("memberList", arrlist);
        return "sample5";
    }
    @GetMapping(value = "memberDeleteOk")
    public String sample5(@RequestParam(name="num") String num, Model model) {
/*
        MemberDTO memberdto = new MemberDTO(1, "홍길동", "gdhong", "010-1234-1234");

        ArrayList<MemberDTO> arrlist = new ArrayList<MemberDTO>();
        arrlist.add(memberdto);
 */
        System.out.println(("argument num = "+num));
        Long longnum = Long.parseLong(num);
        memberService.deleteMember(longnum);
        //model.addAttribute("memberList", arrlist);
        return "sample6";
    }
}
