package hello.servlet.v2.web.frontcontroller.v1;

import hello.servlet.v2.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.v2.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.v2.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private final Map<String, ControllerV1> controllers = new HashMap<>();

    public FrontControllerServletV1() {
        controllers.put("/front-controller/v1/members/new-form", MemberFormControllerV1.getInstance());
        controllers.put("/front-controller/v1/members/save", MemberSaveControllerV1.getInstance());
        controllers.put("/front-controller/v1/members", MemberListControllerV1.getInstance());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV1 controllerV1 = controllers.get(requestURI);

        if (controllerV1 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controllerV1.proess(request, response);
    }
}
