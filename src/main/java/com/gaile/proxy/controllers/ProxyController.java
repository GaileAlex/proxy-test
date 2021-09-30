package com.gaile.proxy.controllers;

import com.gaile.proxy.dto.PageRequest;
import com.gaile.proxy.dto.ProxyDto;
import com.gaile.proxy.dto.ProxyRequest;
import com.gaile.proxy.services.ProxyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Aleksei Gaile 27-Sep-21
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/proxy")
@Tag(name = "ProxyController", description = "Controller for working with proxy")
public class ProxyController {
    private final ProxyService proxyService;

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create a proxy entry")
    public void createProxy(@RequestBody @Valid ProxyDto proxyDto) {
        proxyService.createProxy(proxyDto);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get a proxy by id")
    public ResponseEntity<ProxyDto> getProxyById(@PathVariable String id) {
        return new ResponseEntity<>(proxyService.getProxyById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/paging")
    @Operation(summary = "Get a proxy with pagination")
    public ResponseEntity<List<ProxyDto>> getProxyWithPagination(@RequestBody PageRequest pageRequest) {
        return new ResponseEntity<>(proxyService.getProxyWithPagination(pageRequest), HttpStatus.OK);
    }

    @PostMapping(path = "/filter")
    @Operation(summary = "Get a proxy filtered by name and type")
    public ResponseEntity<List<ProxyDto>> getProxyByNameAndType(@RequestBody ProxyRequest proxyRequest) {
        return new ResponseEntity<>(proxyService.getProxyByNameAndType(proxyRequest), HttpStatus.OK);
    }

    @PutMapping(path = "/edit-proxy")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Edit a proxy")
    public void editProxy(@RequestBody @Valid ProxyDto proxyDto) {
        proxyService.editProxy(proxyDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a proxy")
    public void deleteProxy(@PathVariable String id) {
        proxyService.deleteProxy(id);
    }

}
