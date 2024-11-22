package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
class MemberServiceTest {
    MemoryMemberRepository repo;
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        repo = new MemoryMemberRepository();
        memberService = new MemberService(repo); //Dependency Injection
    }

    @AfterEach
    public void afterEach(){
        repo.clearStore();
    }

    @Test
    void 회원가입() {
        //givenR
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);
        Member findMember = memberService.findOne(saveId).get();
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, ()->{
            memberService.join(member2);
        });

//        Assertions.assertThatThrownBy(() ->
//        {
//            memberService.join(member2);
//        }).isInstanceOf(IllegalStateException.class);

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }

}