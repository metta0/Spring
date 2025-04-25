package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();
    //1. afterEach()에서 clearstore()
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    //2. save()테스트
    @Test
    void save(){
        //given
        Member member = new Member("member1", 20);

        //when
        Member result = memberRepository.save(member);

        //then
        assertThat(result.getAge()).isEqualTo(member.getAge());
        assertThat(result.getUsername()).isEqualTo(member.getUsername());

    }

    //3. findAll() 테스트
    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 10);
        Member member2 = new Member("member2", 10);
        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}
