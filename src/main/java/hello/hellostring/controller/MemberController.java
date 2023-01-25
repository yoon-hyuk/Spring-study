package hello.hellostring.controller;

import hello.hellostring.domain.Member;
import hello.hellostring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    // createMemberForm.html을 화면에 뿌리는 역활을 한다.


    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
    // creatreMemberForm.html에서 버튼을 누르면 데이터가 post방식으로 넘어온다.
    // MemberForm을 통해 데이터를 불러오고 memberService.join을 통해 등록한다.

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberlist";
    }

}
