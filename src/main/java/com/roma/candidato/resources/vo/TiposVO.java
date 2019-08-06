package com.roma.candidato.resources.vo;


import lombok.Data;
/**
 * *
 * 
 * @author Rene Ibarra
 * Clase que representa la table tipos de candidatos
 * Manejo de lombok para manejar los pojos 
 */

@Data

public class TiposVO{
	private Integer idType;
	private String nameType;
	private String description;

}
