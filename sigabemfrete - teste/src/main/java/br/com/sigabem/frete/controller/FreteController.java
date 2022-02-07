package br.com.sigabem.frete.controller;

import br.com.sigabem.frete.controller.request.FreteRequest;
import br.com.sigabem.frete.controller.response.FreteResponse;
import br.com.sigabem.frete.service.frete.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sigabem/fretes")
public class FreteController {

    @Autowired
    private FreteService freteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FreteResponse> get(){
        return this.freteService.findAllFretes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addFrete (@RequestBody FreteRequest freteRequest){
        this.freteService.addFrete(freteRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteFrete (@RequestParam Long id){
        this.freteService.deleteFrete(id);
    }

}
