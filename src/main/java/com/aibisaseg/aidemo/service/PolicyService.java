package com.aibisaseg.aidemo.service;

import com.aibisaseg.aidemo.model.entity.PolicyEntity;
import com.aibisaseg.aidemo.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PolicyService {

    @Autowired
    PolicyRepository policyRepo;


    public PolicyEntity getPolicyData(String documentId){
        PolicyEntity policyResponse = new PolicyEntity();

        List<PolicyEntity> policyList = new ArrayList<PolicyEntity>();

        policyList = policyRepo.findByDocumentId(documentId);

        for (PolicyEntity policy : policyList) {
            policyResponse.setId(policy.getId());
            policyResponse.setFullName(policy.getFullName());
            policyResponse.setDocumentId(policy.getDocumentId());
            policyResponse.setPlan(policy.getPlan());
            policyResponse.setPolicyNo(policy.getPolicyNo());
            policyResponse.setPdfSource(policy.getPdfSource());
        }

        return policyResponse;
    }
}
