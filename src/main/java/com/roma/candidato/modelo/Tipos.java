package com.roma.candidato.modelo;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Data;
/**
 * *
 * 
 * @author Rene Ibarra
 * Clase que representa la table tipos de candidatos
 * Manejo de lombok para manejar los pojos 
 * 	@GeneratedValue(strategy=GenerationType.AUTO)
*
*	@GeneratedValue(generator="system-uuid")
*	@GenericGenerator(name="system-uuid", strategy="uuid2")
 */

@Data
@Entity
@Table(name = "types")
public class Tipos{
	
	@Id
    @GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="id_type")
	private int  idType;
	
	@Column(name = "name_type")
	private String nameType;
	
	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@OneToMany 
	private Set<Candidato>tipo; 
	
	/* *  * @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo") private Set<Candidato>
								 * candidato;
								 */
	public Tipos() {
	}
}
