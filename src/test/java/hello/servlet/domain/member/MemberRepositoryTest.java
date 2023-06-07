package hello.servlet.domain.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("멤버 저장소 인터페이스 테스트")
class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        // given
        Member member = Member.of("hello",20);
        // when
        Member saveMember = memberRepository.save(member);
        // then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertEquals(findMember, saveMember);
    }

    
    @Test
    @DisplayName("findAll")
    void findAll () throws Exception {
        // given
        Member member1 = Member.of("member1", 20);
        Member member2 = Member.of("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        // when
        List<Member> result = memberRepository.findAll();
        // then
        assertEquals(2, result.size());
    }
}