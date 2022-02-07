package br.com.sigabem.frete.model;

import br.com.sigabem.frete.controller.request.FreteRequest;
import br.com.sigabem.frete.controller.response.CepResponse;
import br.com.sigabem.frete.controller.response.CepResponseDestino;
import br.com.sigabem.frete.controller.response.FreteResponse;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FreteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double peso;
    private String cepOrigem;
    private String cepDestino;
    private String nomeDestinatario;
    private double vlTotalFrete;
    private LocalDateTime dataPrevistaEntrega;
    private LocalDateTime dataConsulta;



    public static CepResponse converteCepOrigemEntityToCepResponse(FreteEntity freteEntity){
        return CepResponse.builder()
                .cepOrigem(freteEntity.getCepOrigem())
                .build();
    }

    public static CepResponseDestino converteCepOrigemEntityToCepResponseDestino(FreteEntity freteEntity){
        return CepResponseDestino.builder()
                .cepDestino(freteEntity.getCepDestino())
                .build();
    }


    public static FreteResponse converteEntityToFreteResponse(FreteEntity freteEntity){
        return FreteResponse.builder()
                .id(freteEntity.getId())
                .vlTotalFrete(freteEntity.getVlTotalFrete())
                .dataPrevistaEntrega(freteEntity.getDataPrevistaEntrega())
                .cepOrigem(freteEntity.getCepOrigem())
                .cepDestino(freteEntity.getCepDestino())
                .dataConsulta(freteEntity.getDataConsulta())
                .build();
    }

    public static FreteEntity converteFreteRequestToEntity(FreteRequest freteRequest){
        return FreteEntity.builder()
                .nomeDestinatario(freteRequest.getNomeDestinatario())
                .peso(freteRequest.getPeso())
                .cepOrigem(freteRequest.getCepOrigem())
                .cepDestino(freteRequest.getCepDestino())
                .dataConsulta(freteRequest.getDataConsulta())
                .dataPrevistaEntrega(freteRequest.getDataPrevistaEntrega())
                .build();
    }








}
