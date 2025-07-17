package br.com.KingDanone.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagemDTO {
    private Integer id;
    private String nomeOriginal;
    private String nomeSalvo;
    private LocalDateTime dataUpload;

    public ImagemDTO(String nomeOriginal, String nomeSalvo, LocalDateTime dataUpload) {
        this.nomeOriginal = nomeOriginal;
        this.nomeSalvo = nomeSalvo;
        this.dataUpload = dataUpload;
    }
    public ImagemDTO(Integer id){
        this.id = id;
    }
}
