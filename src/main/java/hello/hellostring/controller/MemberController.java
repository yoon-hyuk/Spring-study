package hello.hellostring.controller;

import hello.hellostring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    // Autowired를 통해  의존관계를 주입을 한다.
    // controller가 생성될때 스트링빈에 생성되어있는 memberService라는 객체를 가져다가 MemberService클래스에 의존관계를 주입한다.
    // 이를 통해 MemberController클래스와 MemberServive클래스가 wired(연결)된다.

}
