package br.com.sigabem.frete.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CepResponseDestino {

    private String ddd;
    private String uf;
    private String cep;
    private String cepDestino;
}
