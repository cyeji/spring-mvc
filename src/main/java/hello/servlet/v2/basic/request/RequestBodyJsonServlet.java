package hello.servlet.v2.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.v2.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

@Slf4j
@RequiredArgsConstructor
@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private final ObjectMapper objectMapper;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody: {}", messageBody);

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("helloData.getName : {}", helloData.getUsername());
        log.info("helloData.getAge : {}", helloData.getAge());
    }
}
