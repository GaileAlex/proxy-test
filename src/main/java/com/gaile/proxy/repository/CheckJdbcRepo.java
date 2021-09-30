package com.gaile.proxy.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Aleksei Gaile 30-Sep-21
 */
@Repository
@RequiredArgsConstructor
public class CheckJdbcRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String CHECK_NAME_HOSTNAME = "select distinct case\n" +
            "                    when (select name from proxy where id <> :id and name = :name) is not null then 'name'\n" +
            "                    when (select hostname from proxy where id <> :id and hostname = :hostname) is not null\n" +
            "                        then 'hostname'\n" +
            "                    END problem\n" +
            "from proxy";

    public String getCheckNameHostname(String id, String name, String hostName) {
        var parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
        parameters.addValue("name", name);
        parameters.addValue("hostname", hostName);

        return jdbcTemplate.queryForObject(CHECK_NAME_HOSTNAME, parameters, String.class);
    }


}
