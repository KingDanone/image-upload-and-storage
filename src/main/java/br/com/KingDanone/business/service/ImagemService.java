package br.com.KingDanone.business.service;

import br.com.KingDanone.presentation.dto.ImagemDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImagemService {
    ImagemDTO salavarImagem(MultipartFile file) throws IOException;
}
