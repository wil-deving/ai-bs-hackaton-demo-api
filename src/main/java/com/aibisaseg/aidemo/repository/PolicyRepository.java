package com.aibisaseg.aidemo.repository;

import com.aibisaseg.aidemo.model.entity.PolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyRepository extends JpaRepository<PolicyEntity, Integer> {

    List<PolicyEntity> findByDocumentId(String documentId);

    PolicyEntity findFirstByDocumentId(String documentId);

    PolicyEntity findFirstByPolicyNo(String policyNo);
}
