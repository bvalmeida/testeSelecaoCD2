package br.com.sigabem.frete.service.frete;

import br.com.sigabem.frete.controller.request.FreteRequest;
import br.com.sigabem.frete.controller.response.CepResponse;
import br.com.sigabem.frete.controller.response.CepResponseDestino;
import br.com.sigabem.frete.controller.response.FreteResponse;

import java.util.List;

public interface FreteService {

    void addFrete(FreteRequest freteRequest);
    List<FreteResponse> findAllFretes();
    void deleteFrete(Long id);
    void updateFrete(FreteRequest freteRequest);
    CepResponse consumirApiOrigem (CepResponse cepResponse);
    CepResponseDestino consumirApiDestino(CepResponseDestino cepResponseDestino);
}
