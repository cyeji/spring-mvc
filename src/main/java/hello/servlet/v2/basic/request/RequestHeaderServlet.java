package hello.servlet.v2.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaderName(request);
        printHeaderUtils(request);

    }

    private static void printHeaderUtils(HttpServletRequest request) {
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        log.info("Server: " + serverName);
        log.info("Port: " + serverPort);

        request.getLocales().asIterator().forEachRemaining(locale -> log.info("locale = {}", locale));
    }

    private static void printHeaderName(HttpServletRequest request) {
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            log.info("headerName : {}", headerName);
//        }
        request.getHeaderNames().asIterator().forEachRemaining(headerName -> log.info("HeaderName : {}", headerName));
    }

    private static void printStartLine(HttpServletRequest request) {
        log.info("--- Request Line ---");

        log.info("request.getMethod() = " + request.getMethod());
        log.info("request.getProtocol() = " + request.getProtocol());
        log.info("request.getScheme() = " + request.getScheme());

        log.info("request.getRequestURL() = " + request.getRequestURL());
        log.info("request.getRequestURI() = " + request.getRequestURL());
        log.info("request.getQueryString() = " + request.getQueryString());
        log.info("request.isSecure() = " + request.isSecure());

        log.info("-- REQUEST LINE --");
    }
}
