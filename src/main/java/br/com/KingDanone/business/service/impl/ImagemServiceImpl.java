package br.com.KingDanone.business.service.impl;


import br.com.KingDanone.business.service.ImagemService;
import br.com.KingDanone.data.model.Imagem;
import br.com.KingDanone.data.repository.ImagemRepository;
import br.com.KingDanone.presentation.dto.ImagemDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import static br.com.KingDanone.business.mapper.ImagemMapper.parseObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Service
public class ImagemServiceImpl implements ImagemService {

    @Value("${app.upload-dir}")
    private String uploadDir;

    private final ImagemRepository imagemRepository;
    public ImagemServiceImpl(ImagemRepository imagemRepository){
        this.imagemRepository = imagemRepository;
    }

    @Override
    public ImagemDTO salavarImagem(MultipartFile file) throws IOException {
        if (!file.isEmpty()) throw new IllegalArgumentException("file is empty!");

        String contentType = file.getContentType();
        if (!Arrays.asList("imagem/jpeg", "imagem/jpg", "imagem/png")
                .contains(contentType)){
            throw new IllegalArgumentException("Invalid image type! just JPG OR PNG");
        }

        File pasta = new File(uploadDir);
        if (!pasta.exists()) pasta.mkdir();

        String nomeOriginal = file.getOriginalFilename();
        String nomeSalvo = "Image_" + UUID.randomUUID();
        Path destino = Paths.get(uploadDir, nomeSalvo);

        Files.copy(file.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

        Imagem imagem = new Imagem(null, nomeOriginal, nomeSalvo, LocalDateTime.now());
        imagemRepository.save(imagem);

        return parseObject(imagem, ImagemDTO.class);
    }
}
