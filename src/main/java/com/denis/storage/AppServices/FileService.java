package com.denis.storage.AppServices;

import com.denis.storage.Models.Doc;
import com.denis.storage.Repository.FileRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileService {
    private FileRepo fileRepo;

    public FileService(FileRepo fileRepo) {
        this.fileRepo = fileRepo;
    }

    public Doc saveFile(MultipartFile file) {
        String docname = file.getOriginalFilename();
        try {
            Doc doc = new Doc(docname, file.getContentType(), file.getBytes());
            return fileRepo.save(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Doc> getFiles() {

        return fileRepo.findAll();
    }

    public Doc getById(Integer id) {
        return fileRepo.findById(id).orElse(null);
    }

    public void deleteNote(Integer id) {
        fileRepo.deleteById(id);
    }

}
