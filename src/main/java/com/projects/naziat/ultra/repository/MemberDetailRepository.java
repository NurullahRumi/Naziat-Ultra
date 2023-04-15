package com.projects.naziat.ultra.repository;

import com.projects.naziat.ultra.entity.MemberDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberDetailRepository extends JpaRepository<MemberDetailEntity, UUID> {
}
