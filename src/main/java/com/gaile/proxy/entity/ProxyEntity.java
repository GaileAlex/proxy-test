package com.gaile.proxy.entity;

import com.gaile.proxy.enums.ProxyType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Aleksei Gaile 27-Sep-21
 */
@Getter
@Setter
@Entity(name = "Proxy")
@Table(name = "proxy")
@NoArgsConstructor
public class ProxyEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "proxy_type")
    private ProxyType proxyType;

    @Column(name = "hostname")
    private String hostname;

    @Column(name = "port")
    private Integer port;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "isActive")
    private Boolean isActive;

}
