package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @BeforeEach
    void beforeEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("Spring");

        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();

        assertEquals(member, result);
    }

    @Test
    void findByName() {
        Member member1 = new Member("Spring");
        Member member2 = new Member("Spring2");

        memoryMemberRepository.save(member1);
        memoryMemberRepository.save(member2);

        Member result = memoryMemberRepository.findByName(member1.getName()).get();

        assertEquals(member1.getName(), result.getName());
        assertNotEquals(member2.getName(), result.getName());
    }

    @Test
    void findAll() {
        Member member1 = new Member("Spring");
        Member member2 = new Member("Spring2");

        memoryMemberRepository.save(member1);
        memoryMemberRepository.save(member2);

        List<Member> result = memoryMemberRepository.findAll();
        assertEquals(2, result.size());
    }
}