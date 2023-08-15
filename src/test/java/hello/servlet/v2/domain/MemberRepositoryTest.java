package hello.servlet.v2.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }


    @Test
    @DisplayName("save")
    void test_case_1() throws Exception {
        // given
        Member member = new Member("hello", 20);
        // when
        Member saveMember = memberRepository.save(member);
        // then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertEquals(saveMember, findMember);
    }


    @Test
    @DisplayName("findAll")
    void test_case_2() throws Exception {
        // given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        // when
        List<Member> result = memberRepository.findAll();
        // then
        assertEquals(2, result.size());
    }
}