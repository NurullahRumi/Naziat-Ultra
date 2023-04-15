package com.projects.naziat.ultra.entity;

import com.projects.naziat.ultra.constant.EntityConstant;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = EntityConstant.MEMBER_DETAIL)
public class MemberDetailEntity extends BaseEntity{

    private String memberId;
    private String userId;
    private String fName;
    private String mName;
    private String lName;
    private Date joinDate;
    private String phNo;
    private String bloodGrp;
}
