package hello.servlet.v2.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {

    void proess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}