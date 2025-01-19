package com.example.demo.dto;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Value;
import java.io.Serializable;

@Value //생성자, private final, getter
@Builder
public class YoungDto{
    String bizId;
    String polyBizSjnm;
    String cnsgNmor;
    String rqutProcCn;
}