package com.projects.naziat.ultra.service;

import com.projects.naziat.ultra.entity.MemberDetailEntity;
import com.projects.naziat.ultra.exception.custom.NotFoundException;
import com.projects.naziat.ultra.repository.MemberDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberDetailService {
    public static final String MEMBER_NOT_FOUND = "Member not found";
    private final MemberDetailRepository memberDetailRepository;

    public Page<MemberDetailEntity> getMembersDetails(Pageable pageable){
        return memberDetailRepository.findAll(pageable);
    }

    public MemberDetailEntity getMemberDetail(UUID id){
        return memberDetailRepository.findById(id).orElseThrow(()->new NotFoundException(MEMBER_NOT_FOUND));
    }

    public MemberDetailEntity createMemberDetail(MemberDetailEntity request){
        return memberDetailRepository.save(request);
    }

    public void updateMemberDetail(MemberDetailEntity request){
        var memberDetail = memberDetailRepository.findById(request.getId()).orElseThrow(()-> new NotFoundException(MEMBER_NOT_FOUND));
        memberDetail.setFName(request.getFName());
        memberDetail.setMName(request.getMName());
        memberDetail.setLName(request.getLName());
        memberDetail.setJoinDate(request.getJoinDate());
        memberDetail.setPhNo(request.getPhNo());
        memberDetail.setBloodGrp(request.getBloodGrp());
        memberDetailRepository.save(memberDetail);
    }

    public void deleteMemberDetails(UUID id){
        memberDetailRepository.deleteById(id);
    }
}
