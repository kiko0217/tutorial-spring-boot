package com.domain.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.domain.models.entities.Member;

public interface MemberRepo extends CrudRepository<Member, Long>{
    boolean existsMemberByMemberNumber(String memberNumber);

    boolean existsMemberByMemberEmail(String memberEmail);
    
}
