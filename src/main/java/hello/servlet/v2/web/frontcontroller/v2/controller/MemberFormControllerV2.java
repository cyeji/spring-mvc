package hello.servlet.v2.web.frontcontroller.v2.controller;

import hello.servlet.v1.web.frontcontroller.MyView;
import hello.servlet.v1.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    private static MemberFormControllerV2 memberFormControllerV2 = new MemberFormControllerV2();

    private MemberFormControllerV2() {}

    public static MemberFormControllerV2 getInstance() {
        return memberFormControllerV2;
    }

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
