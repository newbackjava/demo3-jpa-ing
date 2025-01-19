package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Young {

    @Id
    private String bizId;

    private String polyBizSjnm;
    private String cnsgNmor;
    private String rqutProcCn;
}