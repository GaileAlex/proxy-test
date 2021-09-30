package com.gaile.proxy.controllers;

import com.gaile.proxy.ProxyApplication;
import com.gaile.proxy.dto.PageRequest;
import com.gaile.proxy.dto.ProxyDto;
import com.gaile.proxy.dto.ProxyRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import static com.gaile.proxy.controllers.UtilsTests.asJsonString;
import static com.gaile.proxy.enums.ProxyType.HTTP;
import static com.gaile.proxy.enums.ProxyType.SOCKS5;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Aleksei Gaile 30-Sep-21
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ProxyApplication.class})
@ActiveProfiles("test")
@Rollback
@Transactional
@AutoConfigureMockMvc
class ProxyControllerTest {
    private static final String BASE_URL = "/proxy";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createProxy() throws Exception {
        ProxyDto proxyDto = new ProxyDto();
        proxyDto.setName("test1");
        proxyDto.setProxyType(HTTP);
        proxyDto.setHostname("208.113.153.238");
        proxyDto.setPort(9191);
        proxyDto.setUsername("test");
        proxyDto.setPassword("pass");
        proxyDto.setIsActive(false);

        mockMvc.perform(MockMvcRequestBuilders
                        .post(BASE_URL + "/create")
                        .content(asJsonString(proxyDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    void getProxyById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(BASE_URL + "/{id}", "S000001")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("S000001"))
                .andExpect(jsonPath("$.name").value("proxy1"));
    }

    @Test
    void getProxyWithPagination() throws Exception {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setLimit(3);
        pageRequest.setOffset(1);

        mockMvc.perform(MockMvcRequestBuilders
                        .post(BASE_URL + "/paging")
                        .content(asJsonString(pageRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("S000002"))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    void getProxyByNameAndType() throws Exception {
        ProxyRequest proxyRequest = new ProxyRequest();
        proxyRequest.setName("proxy4");
        proxyRequest.setProxyType(SOCKS5);

        mockMvc.perform(MockMvcRequestBuilders
                        .post(BASE_URL + "/filter")
                        .content(asJsonString(proxyRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("S000004"))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void editProxy() throws Exception {
        ProxyDto proxyDto = new ProxyDto();
        proxyDto.setId("S000005");
        proxyDto.setName("test1");
        proxyDto.setProxyType(HTTP);
        proxyDto.setHostname("208.113.153.238");
        proxyDto.setPort(9191);
        proxyDto.setUsername("test");
        proxyDto.setPassword("pass");
        proxyDto.setIsActive(false);

        mockMvc.perform(MockMvcRequestBuilders
                        .put(BASE_URL + "/edit-proxy")
                        .content(asJsonString(proxyDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteProxy() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete(BASE_URL + "/delete/{id}", "S000001")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNoContent());
    }

}
