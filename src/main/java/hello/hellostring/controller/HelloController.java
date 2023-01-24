package hello.hellostring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("date","spring");
        return "hello";
    }
        // 정적 컨텐츠
        // 스트링부트 템플릿엔진 기본 viewName 매핑 hello로 매핑되어있는 해당 메서드 실행
        // 리턴값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리
        // 리턴에서 반환된 문자와 같은 이름의 파일을 resources:templates아래에서 찾는다.
        // 리턴값으로 hello가 나와서 template에서 hello.html파일을 불러왔다.

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }

    //
    // localhost:8080/hello-mvc?name=spring! ==> 톰캣을 거쳐 스프링 컨테이너로 넘어옴
    // hello-mvc로 매핑되어있는 해당 메서드를 실행한다.
    // return 값이 "hello-template"이고, model에는 name을 spring!으로 가지고 viewResolver에게 맞는 template를 찾으라고 요청한다
    // template에서 hello-template.html파일을 보여준다.

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //"hello spring!!!"
    }

    // @ResponeseBody : http body에 return된 값을 직접 넣겠다는 의미 html없이 데이터를 바로 내려준다.
    // view Resolver대신에 HttpMessageConverter가 동작한다.
    // 기본문자처리 : StringHttpMessageConverter
    // 기본객체처리 : MappingJackson2HttpMessageConverter

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // API방식
    // JSON방식(JavaScript Object Notation)
    // 객체가 오면 default로 Json Converter을 통해 데이터를 Json방식으로 바꾸어서 http에 전송
}
