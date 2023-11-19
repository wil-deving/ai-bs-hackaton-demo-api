package com.aibisaseg.aidemo.service;

import com.aibisaseg.aidemo.dto.BisaRequestDto;
import com.aibisaseg.aidemo.dto.ChatRequestDto;
import com.aibisaseg.aidemo.dto.ChatResponseDto;
import com.aibisaseg.aidemo.dto.MessageRequestDTO;
import com.aibisaseg.aidemo.model.entity.PolicyEntity;
import com.aibisaseg.aidemo.repository.PolicyRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class ChatPDFService {

    @Autowired
    PolicyRepository policyRepo;

    public ResponseEntity<ChatResponseDto> chatPDF(BisaRequestDto consulta) {

        PolicyEntity policy = policyRepo.findFirstByPolicyNo(consulta.getPolicyNo());

        ChatRequestDto chatRequest = new ChatRequestDto();
        MessageRequestDTO message = new MessageRequestDTO();
        message.setRole("user");
        message.setContent(consulta.getMessage());
        List<MessageRequestDTO> messages = new ArrayList<MessageRequestDTO>();

        messages.add(message);

        //chatRequest.setStream("false");
        chatRequest.setReferenceSources(true);
        chatRequest.setSourceId(policy.getPdfSource());
        chatRequest.setMessages(messages);

        final HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "sec_A7pt4J83cvAAcJqUv4OJeMFyuW1W8FNE");
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.convertValue(chatRequest, new TypeReference<Map<String, Object>>() {});

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        String chatUrl = "https://api.chatpdf.com/v1/chats/message";


        try {

            RestTemplate restTemplate = new RestTemplate();


            ResponseEntity<ChatResponseDto> response =
                    restTemplate.postForEntity(chatUrl, entity, ChatResponseDto.class);

            log.info(">>>>> Mensaje obtenido correctamente");

            return response;



        } catch (Exception e) {
            log.error("Error en la obtencion del mensaje ", "Error chatPDF", e);
            return null;
        }

    }
}

