package com.github.marceloasfilho.jsfprimefacesessencialempresajboss.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.marceloasfilho.jsfprimefacesessencialempresajboss.enums.TipoEmpresa;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 30)
    private TipoEmpresa tipoEmpresa;
    @Column(name = "nome_fantasia", nullable = false, length = 80)
    private String nomeFantasia;
    @Column(name = "razao_social", nullable = false, length = 120)
    private String razaoSocial;
    @Column(nullable = false)
    @CNPJ
    private String cnpj;
    @Column(name = "data_fundacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataFundacao;
    @ManyToOne
    @JoinColumn(name = "ramo_atividade_id", nullable = false)
    private RamoAtividade ramoAtividade;
    @Column(precision = 10, scale = 2)
    private BigDecimal faturamento;
}
