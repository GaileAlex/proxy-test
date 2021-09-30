package com.gaile.proxy.exeption;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aleksei Gaile 27-Sep-21
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiExceptionUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertErrorToJSON(Exception error) throws IOException {
        return convertErrorToJSON(error.toString());
    }

    public static String convertErrorToJSON(BindException er) throws IOException {
        List<String> details = new ArrayList<>();
        for (ObjectError error : er.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        return convertErrorToJSON(String.valueOf(details));
    }

    public static String convertErrorToJSON(String message) throws IOException {
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now().toString());
        error.put("message", message);
        return objectMapper.writeValueAsString(error);
    }

    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<Object> handleApiError(ApiException e) throws IOException {
        return ResponseEntity.status(e.getStatus()).contentType(MediaType.APPLICATION_JSON)
                .body(ApiExceptionUtil.convertErrorToJSON(e));
    }

}
