package br.com.worldsFromStarWars.WordsFromStarWars.Entity;

import java.io.Serializable;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "WORLD")

public class World implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	@NotBlank
	@NotNull
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CLIMA")
	private String clima;
	
	@Column(name = "TERRENO")
	private String terreno;
	
	@Nullable
	@Column(name = "QTD_APARICOES")
	private int qtdAparic;

}
