package com.roma.candidato.resources.vo;




import lombok.Data;
/**
 * 
 * 
 * @author bigei @Type(type = "org.hibernate.type.NumericBooleanType")
 *
 *
 */
@Data
public class CandidatoVO {
	private String nombre;
	private String apellidos;
	private Boolean activo;
	private TiposVO  tipo;
	
	/* @JsonProperty("tipo_id")
	 * private void unpackNested(Integer idtype_id) {
	    this.tipo = new TiposVO();
	    tipo.setTipo(idtype_id);
	}
*/
}
