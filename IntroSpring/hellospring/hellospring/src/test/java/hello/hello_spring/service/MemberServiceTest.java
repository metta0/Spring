package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository repo;

    @BeforeEach
    void beforeEach(){
        repo = new MemoryMemberRepository();
        memberService = new MemberService(repo);
    }

    @AfterEach
    void afterEach(){
        repo.clearStore();
    }

    @Test
    void 회원가입() {
        //Given
        Member member = new Member("JPA");

        //When
        Long saveId = memberService.join(member);

        //Then
        Member resultMember = memberService.findOne(saveId).get();
        assertEquals(resultMember.getName(), member.getName());
    }

    @Test
    void 중복_회원_예외() {
        //Given
        Member member1 = new Member("JPA");
        Member member2 = new Member("JPA");
        //When

        memberService.join(member1);

        assertThatThrownBy( () ->
        {
            memberService.join(member2);
        }).isInstanceOf(IllegalArgumentException.class);

        //Then
    }

    @Test
    void findOne() {
    }
}