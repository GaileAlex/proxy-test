package com.gaile.proxy.enums;

import lombok.Getter;

/**
 * @author Aleksei Gaile 28-Sep-21
 */
@Getter
public enum ProxyType {

    HTTP("HTTP"),
    HTTPS("HTTPS"),
    SOCKS4("SOCKS4"),
    SOCKS5("SOCKS5");

    ProxyType(String proxyName) {
        this.proxyName = proxyName;
    }

    private final String proxyName;

}
