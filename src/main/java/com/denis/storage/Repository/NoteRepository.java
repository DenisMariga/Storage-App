package com.denis.storage.Repository;

import com.denis.storage.Models.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Long> {
    List<Notes> findByUsername(String user);
}
