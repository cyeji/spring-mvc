package hello.servlet.v2.web.frontcontroller.v3.controller;

import hello.servlet.v2.web.frontcontroller.ModelView;
import hello.servlet.v2.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    private static MemberFormControllerV3 memberFormControllerV3 = new MemberFormControllerV3();

    private MemberFormControllerV3() {}

    public static MemberFormControllerV3 getInstance() {
        return memberFormControllerV3;
    }


    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
