package hello.servlet.v2.web.frontcontroller.v1.controller;

import hello.servlet.v1.domain.member.Member;
import hello.servlet.v1.domain.member.MemberRepository;
import hello.servlet.v2.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {

    private static final MemberSaveControllerV1 instance = new MemberSaveControllerV1();

    private MemberSaveControllerV1() {
    }

    public static MemberSaveControllerV1 getInstance() {
        return instance;
    }

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void proess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member member = Member.of(username, age);
        memberRepository.save(member);

        // Model에 데이터를 보관
        request.setAttribute("member", member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
