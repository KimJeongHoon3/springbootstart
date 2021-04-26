package com.test.springbootstarted.controller;

import com.test.springbootstarted.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

///**
// * Mock을 상당히 쉽게 사용할수 있는 방법
// * 서블릿컨테이너를 띄운 상태는 아님! 서블릿을 MOCKING한것!
// * */
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc
//class TestControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    public void testHello() throws Exception {
//        mockMvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("hello JH"))
//                .andDo(print());
//    }
//}

///**
// * 실제 서블릿 컨테이너를 띄운 상태(포트 지정도 가능)
// * 현재 Spring컨테이너에있는 모든 빈들을 주입가능 (@SpringBootTest 때문에 가능)
// * 컨트롤러 테스트할때 엮여있는 service를 mock으로 셋팅하여 딱 컨트롤러만 테스트하도록 할수있음 => @MockBean
// * webclient가 사용하기에 매우 직관적이고 좋음
// * */
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class TestControllerTest {
//    @Autowired
//    TestRestTemplate testRestTemplate;
//
//    @MockBean
//    TestService testService;
//
//    @Autowired
//    WebTestClient webTestClient;
//
//    @Test
//    public void testHelloWithRestTemplate() throws Exception {
//        given(testService.getName()).willReturn("jeonghun");
//
//        String result=testRestTemplate.getForObject("/hello",String.class);
//        assertEquals(result,"hello jeonghun");
//
//    }
//
//    @Test
//    public void testHelloWithWebClient(){
//        given(testService.getName()).willReturn("jeonghun");
//        webTestClient.get()
//                .uri("/hello")
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(String.class).isEqualTo("hello jeonghun");
//    }
//}

/**
 * WebMvc의 Controller쪽 관련 테스트하도록 도와주는 어노테이션이 @WebMvcTest
 * 딱 지정한 Controller class만 테스트가능(Controller 관련 어노테이션으로 등록되어있어야함)
 * 연관된 Service는 모두 Mock으로 셋팅ㅎ애줘야함
 * MockMvc로 테스트가능
 * 모든 Bean들이 주입되지않기때문에 빠르게 테스트가능!(@Spring
 * */
@WebMvcTest(TestController.class)
class TestControllerTest {
    @MockBean
    TestService testService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        given(testService.getName()).willReturn("jeonghun");

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello jeonghun"))
                .andDo(print());
    }
}