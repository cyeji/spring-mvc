package hello.servlet.v2.web.frontcontroller.v1.controller;

import hello.servlet.v2.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {

    private static final MemberFormControllerV1 instance = new MemberFormControllerV1();

    private MemberFormControllerV1() {

    }

    public static MemberFormControllerV1 getInstance() {
        return instance;
    }

    @Override
    public void proess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
