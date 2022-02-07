package br.com.sigabem.frete.controller.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FreteResponse {

    private Long id;
    private double vlTotalFrete;
    private LocalDateTime dataPrevistaEntrega;
    private LocalDateTime dataConsulta;
    private String cepOrigem;
    private String cepDestino;

}
