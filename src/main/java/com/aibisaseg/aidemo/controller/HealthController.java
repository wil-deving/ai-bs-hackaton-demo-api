package com.aibisaseg.aidemo.controller;

import com.aibisaseg.aidemo.dto.BisaRequestDto;
import com.aibisaseg.aidemo.dto.ChatRequestDto;
import com.aibisaseg.aidemo.dto.ChatResponseDto;
import com.aibisaseg.aidemo.model.entity.PolicyEntity;
import com.aibisaseg.aidemo.service.ChatPDFService;
import com.aibisaseg.aidemo.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health")
public class HealthController {

    @Autowired
    ChatPDFService chatService;

    @Autowired
    PolicyService policyService;

    @GetMapping
    public String dummyGreeting() {
        return "service ai is up!";
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/chatme")
    public ResponseEntity<ChatResponseDto> consultaPdfPoliza(@RequestBody BisaRequestDto consulta) {

        return this.chatService.chatPDF(consulta);
    
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/policy")
    public ResponseEntity<PolicyEntity> consultaPoliza(@RequestParam String documentId) {

        return new ResponseEntity<PolicyEntity>(this.policyService.getPolicyData(documentId),null,HttpStatus.OK);

    }

}
