package com.gaile.proxy.dto;

import com.gaile.proxy.enums.ProxyType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author Aleksei Gaile 27-Sep-21
 */
@Getter
@Setter
public class ProxyDto {

    private String id;

    @Size(max = 120, message = "name length exceeded")
    private String name;

    @Valid
    private ProxyType proxyType;

    @Size(max = 120, message = "hostname length exceeded")
    private String hostname;

    private Integer port;

    @Size(max = 20, message = "username length exceeded")
    private String username;

    @Size(max = 20, message = "password length exceeded")
    private String password;

    private Boolean isActive;

}
