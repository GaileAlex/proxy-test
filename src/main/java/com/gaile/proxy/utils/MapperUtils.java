package com.gaile.proxy.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksei Gaile 27-Sep-21
 */
@Service
@RequiredArgsConstructor
public class MapperUtils {
    private final ObjectMapper mapper;

    public <T, E> List<T> toOtherList(List<E> copiedList, Class<? extends T> type) {
        List<T> result = new ArrayList<>();
        copiedList.forEach(c -> result.add(mapper.convertValue(c, type)));
        return result;
    }

    public <T, E> T toOtherClass(E copiedClass, Class<? extends T> type) {
        return mapper.convertValue(copiedClass, type);
    }
}
