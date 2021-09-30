package com.gaile.proxy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Aleksei Gaile 27-Sep-21
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {

    private Integer limit;

    private Integer offset;

}
