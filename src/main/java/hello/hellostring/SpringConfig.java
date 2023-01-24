package hello.hellostring;

import hello.hellostring.repository.MemberRepository;
import hello.hellostring.repository.MemoryMemberRepository;
import hello.hellostring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}

// 자바코드로 직접 스프링 빈 등록하는 방법
// service와 repository 어노테이션을 제거하고 진행한다.
// 위 파일처럼 새로 자바파일을 추가로 만들어 직덥 스프링 빈을 등록해 준다.

//

//