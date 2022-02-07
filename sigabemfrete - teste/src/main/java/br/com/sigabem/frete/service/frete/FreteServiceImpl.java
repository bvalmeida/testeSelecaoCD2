package br.com.sigabem.frete.service.frete;

import br.com.sigabem.frete.controller.request.FreteRequest;
import br.com.sigabem.frete.controller.response.CepResponse;
import br.com.sigabem.frete.controller.response.CepResponseDestino;
import br.com.sigabem.frete.controller.response.FreteResponse;
import br.com.sigabem.frete.model.FreteEntity;
import br.com.sigabem.frete.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FreteServiceImpl implements FreteService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FreteRepository freteRepository;

    @Override
    public void addFrete(FreteRequest freteRequest) {
        new FreteEntity();
        this.freteRepository.save(FreteEntity.converteFreteRequestToEntity(freteRequest));
    }

    @Override
    public List<FreteResponse> findAllFretes() {
        return this.freteRepository.findAll().stream()
                .map(FreteEntity::converteEntityToFreteResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFrete(Long id) {
        this.freteRepository.deleteById(id);
    }

    @Override
    public void updateFrete(FreteRequest freteRequest) {
        this.freteRepository.save(FreteEntity.converteFreteRequestToEntity(freteRequest));
    }

    @Override
    public CepResponse consumirApiOrigem(CepResponse cepResponse) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("viacep.com.br/ws")
                .path(cepResponse.getCepOrigem() + "/json")
                .build();
        return restTemplate.getForObject(uriComponents.toUriString(), CepResponse.class);
    }

    @Override
    public CepResponseDestino consumirApiDestino(CepResponseDestino cepResponseDestino) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("viacep.com.br/ws")
                .path(cepResponseDestino.getCepDestino() + "/json")
                .build();
        return restTemplate.getForObject(uriComponents.toUriString(), CepResponseDestino.class);
    }
}
