package com.denis.storage.AppServices;

import com.denis.storage.Models.Notes;
import com.denis.storage.Repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void save(Notes notes) {
        noteRepository.save(notes);
    }

    public List<Notes> getNotes(String user) {
        return noteRepository.findByUsername(user);
    }
    public void DeleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }

    public Notes getByID(Long noteid) {
        return noteRepository.findById(noteid).orElse(null);
    }
}
    