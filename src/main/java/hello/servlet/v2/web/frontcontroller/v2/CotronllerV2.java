package hello.servlet.v2.web.frontcontroller.v2;

import hello.servlet.v2.web.frontcontroller.MyView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CotronllerV2 {

    MyView process(HttpServletRequest request, HttpServletResponse response);
}
