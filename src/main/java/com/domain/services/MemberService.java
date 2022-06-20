package com.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.models.entities.Member;
import com.domain.models.repos.MemberRepo;

@Service
public class MemberService {

    @Autowired
    private MemberRepo memberRepo;
     
    public Member create(Member member){
        return memberRepo.save(member);
    }
    
    public Iterable<Member> findAll() {
        return memberRepo.findAll();
    }
}
