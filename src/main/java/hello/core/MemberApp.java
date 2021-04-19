package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        
        // appconfig 로 DI 해줌.
        // 의존성 관계 정리
        //MemberService memberService = new MemberServiceImpl();

        // Appconfig에서 생성된 memberservice를 가져온다.
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
       
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member" + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
