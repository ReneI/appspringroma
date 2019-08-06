package com.roma.candidato.modelo;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.mapping.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.*;

/**
 * 
 * 
 * @author bigei @Type(type = "org.hibernate.type.NumericBooleanType")
*  (cascade=CascadeType.ALL)
 * @Column(nullable = false, name= "id_type")
*
 */
@Data
@Entity
@Table(name= "candidato1")
@NamedQuery(name="Candidato.findByIdentificacion", query="Select c from Candidato c where c.idCandidato = ?1")

public class Candidato {
	
@Id
@Column(name= "id_candidato")	
@GeneratedValue(strategy =GenerationType.AUTO)
private int idCandidato;

@Column(name= "name")
 private String nombre;

@Column(name= "apellidos")
 private String apellidos;

@Column(name= "active")
 private  boolean activo;

@ManyToOne
@JoinColumn(name= "id_type" )
 private Tipos tipo;


}
