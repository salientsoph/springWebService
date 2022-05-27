package com.jojoldu.book.springboot;


import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //JUnit과 springboot test 를 연결함
@WebMvcTest(controllers = HelloController.class) //@Controller, @ControllerAdvice 를 사용할 수 있음
public class HelloControllerTest {

    @Autowired //스프링이 관리하는 bean을 주입받는다
    private MockMvc mvc; //스프링 MVC 테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) //MockMvc를 통해 /hello주소로 get 요청을 한다, 체이닝 지원(이어서 선언 가능)
                .andExpect(status().isOk()) //mvc.perform의 결과를 검증 - HTTP Header의 status를 검증
                .andExpect(content().string(hello)); //mvc.perform의 결과를 검증 - 응답 본문의 내용을 검증
    }
}
