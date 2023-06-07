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
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("""
            <!DOCTYPE html>   
                <html>
                    <head>
                        <meta charset="UTF-8">
                        <title>Title</title>
                    </head>
                    <body>
                         <table>
                            <thead>
                                <th>id</th>
                                <th>username</th>
                                <th>age</th>
                            </thead>
                            <tbody>
                                   %s
                            </tbody>
                         </table>
                         <a href="/servlet/members/new-form">추가하기</a>
                    </body>
                </html>        
            """.formatted(getMembers(members)));
    }

    private String getMembers(List<Member> members) {
        StringBuilder result = new StringBuilder();
        for (Member member : members) {
            result.append("<tr>").append("\n").append("<td>").append(member.getId()).append("</td>").append("\n").append("<td>").append(member.getUsername())
                .append("</td>").append("\n").append("<td>").append(member.getAge()).append("</td>").append("</tr>");
        }
        return result.toString();
    }
}
