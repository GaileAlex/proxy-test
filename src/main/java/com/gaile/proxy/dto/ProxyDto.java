package com.gaile.proxy.dto;

import com.gaile.proxy.enums.ProxyType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Aleksei Gaile 27-Sep-21
 */
@Getter
@Setter
public class ProxyDto {

    private String id;

    @Size(max = 120, message = "name length exceeded")
    @NotNull(message = "name can't be null")
    private String name;

    @NotNull(message = "proxyType can't be null")
    private ProxyType proxyType;

    @Size(max = 120, message = "hostname length exceeded")
    @NotNull(message = "hostname can't be null")
    private String hostname;

    @NotNull(message = "port can't be null")
    private Integer port;

    @Size(max = 20, message = "username length exceeded")
    @NotNull(message = "username can't be null")
    private String username;

    @Size(max = 20, message = "password length exceeded")
    @NotNull(message = "password can't be null")
    private String password;

    @NotNull(message = "isActive can't be null")
    private Boolean isActive;

}
