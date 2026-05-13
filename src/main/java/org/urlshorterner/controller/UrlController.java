package org.urlshorterner.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.urlshorterner.dto.ShortenUrlRequestDto;
import org.urlshorterner.dto.ShortenUrlResponseDto;
import org.urlshorterner.service.UrlService;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ShortenUrlResponseDto shortenURL(@RequestBody ShortenUrlRequestDto requestDto) {
        return urlService.shortenUrl(requestDto);
    }
}
