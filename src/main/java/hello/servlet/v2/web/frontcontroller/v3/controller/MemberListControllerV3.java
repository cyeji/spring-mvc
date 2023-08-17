package hello.servlet.v2.web.frontcontroller.v3.controller;

import hello.servlet.v1.domain.member.Member;
import hello.servlet.v1.domain.member.MemberRepository;
import hello.servlet.v2.web.frontcontroller.ModelView;
import hello.servlet.v2.web.frontcontroller.v3.ControllerV3;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private static MemberListControllerV3 memberListControllerV3 = new MemberListControllerV3();

    private MemberListControllerV3() {}

    public static MemberListControllerV3 getInstance() {
        return memberListControllerV3;
    }

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members", members);

        return modelView;
    }
}
