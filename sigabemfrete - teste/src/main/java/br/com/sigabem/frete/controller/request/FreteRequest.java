package br.com.sigabem.frete.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FreteRequest {

    private String nomeDestinatario;
    private double peso;
    private String cepOrigem;
    private String cepDestino;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataPrevistaEntrega;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataConsulta;

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = LocalDateTime.now();
    }

    public void setDataPrevistaEntrega(LocalDateTime dataPrevistaEntrega) {
        this.dataPrevistaEntrega = LocalDateTime.now();
    }
}
