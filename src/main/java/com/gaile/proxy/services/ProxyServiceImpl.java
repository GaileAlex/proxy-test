package com.gaile.proxy.services;

import com.gaile.proxy.dto.PageRequest;
import com.gaile.proxy.dto.ProxyDto;
import com.gaile.proxy.dto.ProxyRequest;
import com.gaile.proxy.entity.ProxyEntity;
import com.gaile.proxy.exeption.ApiException;
import com.gaile.proxy.repository.ProxyRepository;
import com.gaile.proxy.utils.MapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Aleksei Gaile 27-Sep-21
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProxyServiceImpl implements ProxyService {
    private final ProxyRepository proxyRepository;
    private final MapperUtils mapperUtils;

    public void createProxy(ProxyDto proxyDto) {
        ProxyEntity proxyEntity = mapperUtils.toOtherClass(proxyDto, ProxyEntity.class);
        proxyRepository.save(proxyEntity);
    }

    public ProxyDto getProxyById(String id) {
        Optional<ProxyEntity> optionalProxyDto = proxyRepository.findById(id);
        ProxyEntity proxyEntity = optionalProxyDto.orElseThrow(() ->
                new ApiException(HttpStatus.NOT_FOUND, "Proxy not found"));

        return mapperUtils.toOtherClass(proxyEntity, ProxyDto.class);
    }

    public List<ProxyDto> getProxyWithPagination(PageRequest pageRequest) {
        List<ProxyEntity> proxyEntities = proxyRepository.getProxyWithPagination(pageRequest.getLimit(), pageRequest.getOffset());
        return mapperUtils.toOtherList(proxyEntities, ProxyDto.class);
    }

    public List<ProxyDto> getProxyByNameAndType(ProxyRequest proxyRequest) {
        List<ProxyEntity> proxyEntities = proxyRepository.getProxyEntitiesByNameAndProxyType(proxyRequest.getName(),
                proxyRequest.getProxyType());
        return mapperUtils.toOtherList(proxyEntities, ProxyDto.class);
    }

    public void editProxy(ProxyDto proxyDto) {
        Optional<ProxyEntity> optionalProxy = proxyRepository.findById(proxyDto.getId());
        optionalProxy.orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Proxy not found"));
        ProxyEntity proxyEntity = mapperUtils.toOtherClass(proxyDto, ProxyEntity.class);

        proxyRepository.save(proxyEntity);
    }

    public void deleteProxy(String id) {
        proxyRepository.deleteById(id);
    }

}
