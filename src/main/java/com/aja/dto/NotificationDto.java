package com.aja.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {

    private Integer uid;

    private String toAddress;

    private String subject;

    private String template; // template name

    private String templateModelJson; // store JSON string

    private String body;

    private String type;

    private String status; // PENDING, SENT, FAILED

    private Integer attempts;

    private String lastError;

}
