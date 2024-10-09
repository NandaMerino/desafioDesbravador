package app.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Projeto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
	@NotBlank
    private String nome;
	
	private LocalDate dataInicio;
    private LocalDate dataPrevisaoFim;
    private LocalDate dataFim;
    private String descricao;
    private String status;
    private Float orcamento;
    private String risco;
    
    @ManyToOne
    @JoinColumn(name = "idgerente")
    private Pessoa gerente;
}
