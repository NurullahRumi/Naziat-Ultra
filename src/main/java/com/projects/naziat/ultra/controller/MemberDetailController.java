package com.projects.naziat.ultra.controller;

import com.projects.naziat.ultra.entity.MemberDetailEntity;
import com.projects.naziat.ultra.service.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import static com.projects.naziat.ultra.constant.AppConstant.DEFAULT_PAGE_SIZE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/member-detail")
public class MemberDetailController {
    private final MemberDetailService memberDetailService;

    @GetMapping
    public Page<MemberDetailEntity> getMemberDetails(@RequestParam(defaultValue = "0") int page){
        Page<MemberDetailEntity> memberDetails = memberDetailService.getMembersDetails(PageRequest.of(page, DEFAULT_PAGE_SIZE));
        return memberDetails;
    }

    @PostMapping("/add-member-detail")
    public MemberDetailEntity addMemberDetail(@RequestBody MemberDetailEntity memberDetailEntity){
        return memberDetailService.createMemberDetail(memberDetailEntity);
    }
}
