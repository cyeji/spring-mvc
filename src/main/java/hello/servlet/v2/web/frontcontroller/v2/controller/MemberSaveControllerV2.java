package hello.servlet.v2.web.frontcontroller.v2.controller;

import hello.servlet.v1.domain.member.Member;
import hello.servlet.v1.domain.member.MemberRepository;
import hello.servlet.v1.web.frontcontroller.MyView;
import hello.servlet.v1.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private static MemberSaveControllerV2 memberSaveControllerV2 = new MemberSaveControllerV2();

    private MemberSaveControllerV2() {}

    public static MemberSaveControllerV2 getInstance() {
        return memberSaveControllerV2;
    }

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member member = Member.of(username, age);
        memberRepository.save(member);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
