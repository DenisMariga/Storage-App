package com.denis.storage.AppServices;

import com.denis.storage.Models.Credential;
import com.denis.storage.Repository.CredentialsRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CredentialsService {
    private final CredentialsRepo credentialsRepo;

    public CredentialsService(CredentialsRepo credentialsRepo) {
        this.credentialsRepo = credentialsRepo;
    }

    //Get Credentials form Db
    public List<Credential> getAll() {
        return credentialsRepo.findAll();
    }

    //Get credential by ID
    public Credential getById(Long credentialid) {
        return credentialsRepo.findById(credentialid).orElse(null);
    }

    //Save to Db
    public void save(Credential credential) {
        credentialsRepo.save(credential);
    }

    //Delete Credential
    public void deleteCredential(Long credentialid) {
        credentialsRepo.deleteById(credentialid);
    }
}
