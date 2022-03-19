package com.shink;

import org.springframework.stereotype.Service;

@Service
public class UrlService {
    private static UrlRepository repository;

    public UrlService(UrlRepository repository) {
        UrlService.repository = repository;
    }

    public String saveUrl(String url) {
        UserUrl userUrl = new UserUrl(url);
        repository.save(userUrl);
        return userUrl.getHashedUrl();
    }

    public String getUrl(String url) {
        if (repository.findUserUrlByHashedUrl(url).isPresent()) {
            return repository.findUserUrlByHashedUrl(url).get().getUrl();
        } else {
            return "error";
        }
    }
}
