package com.denis.storage.Repository;

import com.denis.storage.Models.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepo extends JpaRepository<Credential, Long> {
}
