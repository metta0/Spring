package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository repo;

    @Test
    public void 회원가입() throws Exception{
        //Given
        Member member = new Member("spring");
        //When
        Long saveId = memberService.join(member);
        //Then
        Member findMember = repo.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void 회원가입_중복() throws Exception{
        //Given
        Member member1 = new Member("spring");
        Member member2 = new Member("spring");
        //When
        memberService.join(member1);
        Assertions.assertThatThrownBy(()->{
            memberService.join(member2);
        }).isInstanceOf(IllegalArgumentException.class);
    }



}
