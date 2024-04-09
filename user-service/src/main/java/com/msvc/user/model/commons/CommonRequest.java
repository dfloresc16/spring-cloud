package com.msvc.user.model.commons;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonRequest implements Serializable {

    private String transactionId;

    private String systemId;
}
