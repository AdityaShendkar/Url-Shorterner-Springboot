package org.urlshorterner.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.urlshorterner.dto.ShortenUrlRequestDto;
import org.urlshorterner.dto.ShortenUrlResponseDto;
import org.urlshorterner.entity.UrlEntity;
import org.urlshorterner.repository.UrlRepository;
import org.urlshorterner.util.UrlUtils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.random.RandomGenerator;

@Service
public class UrlService {


    private final UrlRepository urlRepository;
    private final UrlUtils urlUtils;

    public UrlService(UrlRepository urlRepository, UrlUtils urlUtils) {
        this.urlRepository = urlRepository;
        this.urlUtils = urlUtils;
    }

    public ShortenUrlResponseDto shortenUrl(ShortenUrlRequestDto requestDto) {
        String url = requestDto.getUrl();
        try {
            boolean isValid = urlUtils.isValid(url);
            if (!isValid) {
                throw new RuntimeException("URL is invalid");
            }
            String shortCode = RandomStringUtils.randomAlphabetic(7);
//            if (urlRepository.existsByShortCode(shortCode)){
//                shortCode = RandomStringUtils.randomAlphabetic(7);
//            }
            UrlEntity urlEntity = new UrlEntity();
            urlEntity.setMainUrl(url);
            urlEntity.setShortCode(shortCode);
            urlRepository.save(urlEntity);
            return ShortenUrlResponseDto.builder()
                    .shortCode(shortCode)
                    .build();
        } catch (DataIntegrityViolationException e) {
            String shortCode = RandomStringUtils.randomAlphabetic(7);
            UrlEntity urlEntity = new UrlEntity();
            urlEntity.setMainUrl(url);
            urlEntity.setShortCode(shortCode);
            urlRepository.save(urlEntity);
            return ShortenUrlResponseDto.builder()
                    .shortCode(shortCode)
                    .build();
        }
    }
}
