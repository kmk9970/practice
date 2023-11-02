package regist.practice.service;

import regist.practice.domain.Member;
import regist.practice.repository.MemberRepository;
import regist.practice.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository=new MemoryMemberRepository();

    public Long join(Member member){ //회원가입

        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //findByName을해 결과가 optional이니 ifPresetn
            .ifPresent(m->{
                throw new IllegalStateException("이미 존재하는 회원입니다!!!");
            });
    }

    public List<Member> findMembers(){//전체 회원 조회
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
