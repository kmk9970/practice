package regist.practice.repository;

import regist.practice.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store=new HashMap<>();
    private static Long sequence=0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //들어온 이름이 결과와 같은지 확인
                .filter(member -> member.getName().equals(name)) //만약 찾으면 바로 반환
                .findAny();
    }

    @Override
    public List<Member> findAll() { //이게 뭐더라
        return new ArrayList<>(store.values());
    }
}
