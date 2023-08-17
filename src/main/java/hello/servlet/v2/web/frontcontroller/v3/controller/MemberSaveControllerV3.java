package hello.servlet.v2.web.frontcontroller.v3.controller;

import hello.servlet.v1.domain.member.Member;
import hello.servlet.v1.domain.member.MemberRepository;
import hello.servlet.v2.web.frontcontroller.ModelView;
import hello.servlet.v2.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private static MemberSaveControllerV3 memberSaveControllerV3 = new MemberSaveControllerV3();

    private MemberSaveControllerV3() {}

    public static MemberSaveControllerV3 getInstance() {
        return memberSaveControllerV3;
    }

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = Member.of(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);

        return mv;
    }
}
