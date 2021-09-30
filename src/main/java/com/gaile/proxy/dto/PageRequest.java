package com.gaile.proxy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author Aleksei Gaile 27-Sep-21
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {

    @NotNull(message = "limit can't be null")
    private Integer limit;

    @NotNull(message = "offset can't be null")
    private Integer offset;

}
