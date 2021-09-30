package com.gaile.proxy.services;

import com.gaile.proxy.dto.PageRequest;
import com.gaile.proxy.dto.ProxyDto;
import com.gaile.proxy.dto.ProxyRequest;

import java.util.List;

/**
 * @author Aleksei Gaile 28-Sep-21
 */
public interface ProxyService {

    /**
     * Creates a proxy from a model
     *
     * @param proxyDto model ProxyDto
     */
    void createProxy(ProxyDto proxyDto);

    /**
     * Get a proxy by id
     *
     * @param id id in the database
     * @return model ProxyDto
     */
    ProxyDto getProxyById(String id);

    /**
     * Get a proxy with pagination
     *
     * @param pageRequest model PageRequest
     * @return list of model ProxyDto
     */
    List<ProxyDto> getProxyWithPagination(PageRequest pageRequest);

    /**
     * Get a proxy by name and type
     *
     * @param proxyRequest model ProxyRequest
     * @return list of model ProxyDto
     */
    List<ProxyDto> getProxyByNameAndType(ProxyRequest proxyRequest);

    /**
     * Edits proxy
     *
     * @param proxyDto model ProxyDto
     */
    void editProxy(ProxyDto proxyDto);

    /**
     * Removes proxy
     *
     * @param id proxy id
     */
    void deleteProxy(String id);

}
