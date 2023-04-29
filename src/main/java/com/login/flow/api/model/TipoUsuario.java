package com.login.flow.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TipoUsuario {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idTipoUsuario;

@NotNull(message = "O nome deverá ser informado")
@NotBlank(message = "O nome não poderá ser vazio")
@Size(min = 3, max = 45, message = "O nome deverá ter entre 3 e 45 caracteres") 
@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Informar apenas letras para o nome")
private String nome;
}

