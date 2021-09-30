package com.gaile.proxy.dto;

import com.gaile.proxy.enums.ProxyType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Aleksei Gaile 28-Sep-21
 */
@Getter
@Setter
public class ProxyRequest {

    private String name;

    private ProxyType proxyType;

}
