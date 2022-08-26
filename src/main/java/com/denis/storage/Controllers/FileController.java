package com.denis.storage.Controllers;

import com.denis.storage.AppServices.FileService;
import com.denis.storage.Models.Doc;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/uploadFiles")
    public String upload(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            fileService.saveFile(file);

        }
        return "redirect:/files";
    }

    @GetMapping("/files")
    public String Files(Model model) {
        List<Doc> fileList = fileService.getFiles();
        model.addAttribute("files", fileList);
        return "files";
    }

    @GetMapping("/downloadFile/{fileid}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileid) {
        Doc file = fileService.getById(fileid);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + file.getDocName() + "\"")
                .body(new ByteArrayResource(file.getData()));

    }

    @GetMapping("/delete{id}")
    public String delete(@PathVariable Integer id) {
        fileService.deleteNote(id);
        return "redirect:/files";
    }

}
