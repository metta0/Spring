package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemberRepository {

    private static HashMap<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    private static MemberRepository memberRepository = new MemberRepository();

    public static MemberRepository getInstance(){
        return memberRepository;
    }
    private MemberRepository() {
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(sequence, member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
