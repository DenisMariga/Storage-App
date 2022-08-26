package com.denis.storage.Models;

import javax.persistence.*;

@Entity
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long credentialid;
    @Column(nullable = false, unique = true)
    private String url;
    private String username;
    private String password;

    public Credential() {
    }

    public Credential(Long credentialid, String url, String username, String password) {
        this.credentialid = credentialid;
        this.url = url;
        this.username = username;
        this.password = password;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCredentialid() {
        return credentialid;
    }

    public void setCredentialid(Long credentialid) {
        this.credentialid = credentialid;
    }
}

