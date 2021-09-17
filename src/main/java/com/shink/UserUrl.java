package com.shink;

import com.sun.istack.NotNull;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Url")
public class UserUrl {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotNull
    private String url;
    @NotNull
    private String hashedUrl;

    public UserUrl(String url) {
        this.url = url;
        this.hashedUrl = hashingUrl(url);
    }

    public UserUrl() {}

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getHashedUrl() { return hashedUrl; }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "userUrl='" + id + '\'' +
                ", code='" + url + '\'' +
                '}';
    }

    private String hashingUrl(String url) {
        return DigestUtils.sha256Hex(url).substring(0, 5);
    }
}
