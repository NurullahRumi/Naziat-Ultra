package com.projects.naziat.ultra.controller;

import com.projects.naziat.ultra.entity.MemberDetailEntity;
import com.projects.naziat.ultra.service.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/member-detail")
public class MemberDetailController {
    private final MemberDetailService memberDetailService;

    @GetMapping
    public List<MemberDetailEntity> getMemberDetails(){
        List<MemberDetailEntity> memberDetails = memberDetailService.getMembersDetails();
        return memberDetails;
    }

    @PostMapping("/add-member-detail")
    public MemberDetailEntity addMemberDetail(@RequestBody MemberDetailEntity memberDetailEntity){
        return memberDetailService.createMemberDetail(memberDetailEntity);
    }
}
