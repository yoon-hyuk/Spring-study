package hello.hellostring.repository;

import hello.hellostring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);                 // Optional : findById가 null일 경우 optional로 감싸서 처리한다
    Optional<Member> findByName(String name);
    List<Member> findAll();


    void clearStore();
}
