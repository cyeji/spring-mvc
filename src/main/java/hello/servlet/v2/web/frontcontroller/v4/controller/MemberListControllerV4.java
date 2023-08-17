package hello.servlet.v2.web.frontcontroller.v4.controller;

import hello.servlet.v1.domain.member.Member;
import hello.servlet.v1.domain.member.MemberRepository;
import hello.servlet.v2.web.frontcontroller.v4.ControllerV4;
import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private static final MemberListControllerV4 memberListControllerV4 = new MemberListControllerV4();

    private MemberListControllerV4() {}

    public static MemberListControllerV4 getInstance() {
        return memberListControllerV4;
    }

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();

        model.put("members", members);
        return "members";
    }
}
