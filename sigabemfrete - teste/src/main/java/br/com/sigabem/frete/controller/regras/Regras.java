package br.com.sigabem.frete.controller.regras;

import br.com.sigabem.frete.controller.request.FreteRequest;
import br.com.sigabem.frete.controller.response.CepResponse;
import br.com.sigabem.frete.controller.response.FreteResponse;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Regras {

    /*
    CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia
    CEPs de estados iguais tem 75% de desconto no valor do frete e entrega prevista de 3 dias
    CEPs de estados diferentes não deve ser aplicado o desconto no valor do frete e entrega prevista de 10 dias
    O valor do frete é cobrado pelo peso da encomenda, o valor para cada KG é R$1,00
     */


    private String ufOrigem;
    private String ufDestino;
    private String dddOrigem;
    private String dddDestino;
    private double peso;
    private double vlTotalFrete;
    private LocalDateTime dataPrevistaEntrega;
    private LocalDateTime dataConsulta;

    public double regrasDeNegocio(Regras regras){
        this.vlTotalFrete = this.peso * 1;

        if (this.dddOrigem.equals(this.dddDestino)){
            this.vlTotalFrete /= 2;
            this.dataPrevistaEntrega.plusDays(1);
        }
        if (this.ufOrigem.equals(this.ufDestino)){
            this.vlTotalFrete = this.vlTotalFrete - (this.vlTotalFrete * 0.75);
            this.dataPrevistaEntrega.plusDays(3);
        }else{
            this.dataPrevistaEntrega.plusDays(10);
        }
        return this.vlTotalFrete;
    }

    private static Regras converteUfDDDtoRegras (CepResponse cepResponse){
        return Regras.builder()
                .ufOrigem(cepResponse.getUf())
                .dddOrigem(cepResponse.getDdd())
                .build();
    }

//    private static Regras converteUfDDDDestinoToRegras(CepResponseDestino cepResponseDestino){
//        return Regras.builder()
//                .ufDestino(cepResponseDestino.getUf())
//                .dddDestino(cepResponseDestino.getDdd())
//                .build();
//    }

    private static Regras converteVlTotalToRegras(FreteResponse freteResponse){
        return Regras.builder()
                .vlTotalFrete(freteResponse.getVlTotalFrete())
                .dataConsulta(freteResponse.getDataConsulta())
                .dataPrevistaEntrega(freteResponse.getDataPrevistaEntrega())
                .build();
    }

    private static Regras convertePesoToRegras(FreteRequest freteRequest){
        return Regras.builder()
                .peso(freteRequest.getPeso())
                .build();
    }



}
