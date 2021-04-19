package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberMemoryRepository;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import hello.core.order.OrderService;

// 어플리케이션 설정을 하고 구성
public class AppConfig {

    // 여기서 DI를 해줌
    // DI를 해줌으로써 역할과 구현이 분리됨.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // memory에서 다른 DB로 변경될 경우 해당 코드만 변경하면 됨.
    private MemberRepository memberRepository() {
        return new MemberMemoryRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemberMemoryRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        // FixDiscountPolicy -> RateDiscountPolicy로 변경.
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
