package com.projects.naziat.ultra.repository;

import com.projects.naziat.ultra.entity.MemberDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberDetailRepository extends JpaRepository<MemberDetailEntity, UUID> {
}
