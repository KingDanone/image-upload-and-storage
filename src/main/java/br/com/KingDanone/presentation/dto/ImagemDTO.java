package br.com.KingDanone.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagemDTO {
    private String nomeOriginal;
    private String nomeSalvo;
    private LocalDateTime dataUpload;
}
