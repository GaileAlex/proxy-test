package com.gaile.proxy.dto;

import com.gaile.proxy.enums.ProxyType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author Aleksei Gaile 28-Sep-21
 */
@Getter
@Setter
public class ProxyRequest {

    @NotNull(message = "name can't be null")
    private String name;

    @NotNull(message = "proxyType can't be null")
    private ProxyType proxyType;

}
