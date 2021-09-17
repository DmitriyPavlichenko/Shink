package com.shink;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UrlRepository extends JpaRepository<UserUrl, Integer> {
    Optional<UserUrl> findUserUrlByHashedUrl(String url);
}
