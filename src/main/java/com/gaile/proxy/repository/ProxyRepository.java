package com.gaile.proxy.repository;

import com.gaile.proxy.entity.ProxyEntity;
import com.gaile.proxy.enums.ProxyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Aleksei Gaile 27-Sep-21
 */
@Repository
public interface ProxyRepository extends JpaRepository<ProxyEntity, String> {

    @Query(value = "select * from proxy limit :limit offset :offset", nativeQuery = true)
    List<ProxyEntity> getProxyWithPagination(@Param("limit") Integer limit, @Param("offset") Integer offset);

    List<ProxyEntity> getProxyEntitiesByNameAndProxyType(@Param("name") String name,
                                                         @Param("proxyType") ProxyType proxyType);

}
