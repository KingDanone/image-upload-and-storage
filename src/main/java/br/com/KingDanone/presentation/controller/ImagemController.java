package br.com.KingDanone.presentation.controller;


import br.com.KingDanone.business.service.ImagemService;
import br.com.KingDanone.presentation.dto.ImagemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/upload")
public class ImagemController {

    private final ImagemService imagemService;

    public ImagemController(ImagemService imagemService) {
        this.imagemService = imagemService;
    }

    @PostMapping
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        try {
            ImagemDTO dto = imagemService.salavarImagem(file);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("error saving image");
        }
    }

    @GetMapping
    public ResponseEntity<List<ImagemDTO>> findAll() {
        List<ImagemDTO> dto = imagemService.findAllImagens();
        return ResponseEntity.ok(dto);
    }
}
