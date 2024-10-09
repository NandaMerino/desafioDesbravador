package app.entity;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pessoa {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank
    private String nome;
	
	@PastOrPresent
    private LocalDate datanascimento;
    
    @CPF
    private String cpf;
    
    private boolean funcionario;
    
    private boolean gerente;
    
    public Pessoa(long id, String nome, LocalDate datanascimento, String cpf, boolean funcionario, boolean gerente) {
        this.id = id;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.cpf = cpf;
        this.funcionario = funcionario;
        this.gerente = gerente;
    }
}
