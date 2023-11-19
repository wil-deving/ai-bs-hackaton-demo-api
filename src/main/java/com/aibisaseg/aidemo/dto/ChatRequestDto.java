package com.aibisaseg.aidemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChatRequestDto {

   // private String stream;
    private boolean referenceSources;
    protected  String  sourceId;
    protected List<MessageRequestDTO> messages;

}
