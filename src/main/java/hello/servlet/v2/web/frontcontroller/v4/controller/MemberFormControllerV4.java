package hello.servlet.v2.web.frontcontroller.v4.controller;

import hello.servlet.v2.web.frontcontroller.v4.ControllerV4;
import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

    private static final MemberFormControllerV4 memberFormControllerV4 = new MemberFormControllerV4();

    private MemberFormControllerV4() {}

    public static MemberFormControllerV4 getInstance() {
        return memberFormControllerV4;
    }

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }
}
