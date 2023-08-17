package hello.servlet.v2.web.frontcontroller.v4.controller;

import hello.servlet.v1.domain.member.Member;
import hello.servlet.v1.domain.member.MemberRepository;
import hello.servlet.v2.web.frontcontroller.v4.ControllerV4;
import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private static final MemberSaveControllerV4 memberSaveControllerV4 = new MemberSaveControllerV4();

    private MemberSaveControllerV4() {}

    public static MemberSaveControllerV4 getInstance() {
        return memberSaveControllerV4;
    }

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = Member.of(username, age);
        memberRepository.save(member);

        model.put("member", member);
        return "save-result";
    }
}
