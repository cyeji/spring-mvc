package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member member = Member.of(username, age);
        memberRepository.save(member);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("""
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Servlet MemberSaveServlet</title>
                </head>
                <body>
                    <p>Id: %s </p>
                    <p>Username: %s </p>
                    <p>Age: %s </p>
                   
                    <a href="/index.html">메인</a>       
                </body>
            </html>
            """.formatted(member.getId(), member.getUsername(), member.getAge()));
    }
}
