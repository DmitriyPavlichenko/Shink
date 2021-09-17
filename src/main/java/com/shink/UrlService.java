package com.shink;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {
    private static UrlRepository repository;

    public UrlService(UrlRepository repository) {
        UrlService.repository = repository;
    }

    public static String saveUrl(String url) {
        UserUrl userUrl = new UserUrl(url);
        repository.save(userUrl);
        return userUrl.getHashedUrl();
    }

    public static Optional<UserUrl> getUrl(String url) {
        return repository.findUserUrlByHashedUrl(url);
    }
}
