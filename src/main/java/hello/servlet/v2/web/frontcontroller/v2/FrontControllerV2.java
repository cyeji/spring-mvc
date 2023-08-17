package hello.servlet.v2.web.frontcontroller.v2;

import hello.servlet.v1.web.frontcontroller.v2.ControllerV2;
import hello.servlet.v2.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.v2.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.v2.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerV2 extends HttpServlet {

    private final Map<String, ControllerV2> controllers = new HashMap<>();

    public FrontControllerV2() {
        controllers.put("/front-controller/v2/members/new-form", MemberFormControllerV2.getInstance());
        controllers.put("/front-controller/v2/members/save", MemberSaveControllerV2.getInstance());
        controllers.put("/front-controller/v2/members", MemberListControllerV2.getInstance());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV2 controllerV2 = controllers.get(requestURI);

        if (controllerV2 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controllerV2.process(request, response);
    }
}
