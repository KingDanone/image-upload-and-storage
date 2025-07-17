package br.com.KingDanone.business.service;

import br.com.KingDanone.presentation.dto.ImagemDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImagemService {
    ImagemDTO salavarImagem(MultipartFile file) throws IOException;

    List<ImagemDTO> findAllImagens();
}
