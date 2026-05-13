package org.urlshorterner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.urlshorterner.entity.UrlEntity;

public interface UrlRepository extends JpaRepository<UrlEntity, Long> {

    boolean existsByShortCode(String shortCode);
}
