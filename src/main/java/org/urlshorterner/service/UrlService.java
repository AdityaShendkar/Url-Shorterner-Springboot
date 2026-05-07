package org.urlshorterner.service;


import org.springframework.stereotype.Service;
import org.urlshorterner.dto.ShortenUrlRequestDto;
import org.urlshorterner.dto.ShortenUrlResponseDto;
import org.urlshorterner.entity.UrlEntity;
import org.urlshorterner.repository.UrlRepository;
import org.urlshorterner.util.UrlUtils;

@Service
public class UrlService {


    private final UrlRepository urlRepository;
    private final UrlUtils urlUtils;

    public UrlService(UrlRepository urlRepository, UrlUtils urlUtils) {
        this.urlRepository = urlRepository;
        this.urlUtils = urlUtils;
    }

    public ShortenUrlResponseDto shortenUrl(ShortenUrlRequestDto requestDto){
        String url = requestDto.getUrl();
        boolean isValid = urlUtils.isValid(url);
        if (!isValid){
            throw new RuntimeException("URL is invalid");
        }
        String shortCode = "TODO";
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setMainUrl(url);
        urlEntity.setShortCode(shortCode);
        urlRepository.save(urlEntity);
        return ShortenUrlResponseDto.builder()
                .shortCode(shortCode)
                .build();
    }
}
