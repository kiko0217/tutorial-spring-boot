package com.domain.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.dto.MemberRequestData;
import com.domain.dto.MemberResponseData;
import com.domain.dto.ResponseData;
import com.domain.models.entities.Member;
import com.domain.services.MemberService;
import com.domain.utils.ErrorParsingUtility;



@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<MemberResponseData>> create(
            @Valid @RequestBody MemberRequestData memberRequestData,
            Errors errors) {
        ResponseData<MemberResponseData> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            responseData.setStatus(false);
            responseData.setMessages(ErrorParsingUtility.parse(errors));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        try {
            Member member = modelMapper.map(memberRequestData, Member.class);
            member = memberService.create(member);
            responseData.setStatus(true);
            responseData.getMessages().add("Member saved!!");
            responseData.setPayload(modelMapper.map(member, MemberResponseData.class));
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setStatus(false);
            responseData.getMessages().add(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseData<List<MemberResponseData>>> findAll() {
        ResponseData<List<MemberResponseData>> responseData = new ResponseData<>();
        try {
            List<MemberResponseData> lMemberResponseData = new ArrayList<>();
            memberService.findAll().forEach(member -> lMemberResponseData.add(modelMapper.map(member, MemberResponseData.class)));
            responseData.setStatus(true);
            responseData.getMessages().add("Success get members");
            responseData.setPayload(lMemberResponseData);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            responseData.setStatus(false);
            responseData.getMessages().add(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
        
    }
}
