package com.denis.storage.Repository;

import com.denis.storage.Models.Doc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<Doc, Integer> {

}
