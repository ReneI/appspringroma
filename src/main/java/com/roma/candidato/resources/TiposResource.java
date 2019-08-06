/**
 * 
 */
package com.roma.candidato.resources;
import com.roma.candidato.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roma.candidato.modelo.Candidato;
import com.roma.candidato.modelo.Tipos;
import com.roma.candidato.resources.vo.TiposVO;
import com.roma.candidato.services.CandidatoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import org.springframework.data.mapping.*;

import java.util.List;

import org.springframework.data.*;
/**
 * @author bigei
 *
 */

@RestController
@RequestMapping("/api/tipo")
@Api(tags="puestos")
public class TiposResource {

	private final TiposService tipoService;
	public  TiposResource (TiposService tipoService) {
		this.tipoService=tipoService;
		
	}
	
	@PostMapping
	@ApiOperation(value="Crear nuevo  puesto",notes="servicio para insertar nuevos puestos")
	public ResponseEntity<Tipos> createCandidato(@RequestBody TiposVO tipoVO){
	
		Tipos tipo = new Tipos();
		tipo.setNameType(tipoVO.getNameType());		
		tipo.setDescription(tipoVO.getDescription());
		return new ResponseEntity<>(this.tipoService.create(tipo),HttpStatus.CREATED);
		
		
		
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Puestos", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") })
	public ResponseEntity<List<Tipos>> findAll() {
		return ResponseEntity.ok(this.tipoService.findAll());
	}
	
	@PutMapping("/{identificacion}")

	@ApiOperation(value = "Actualizar Tipos", notes = "Servicio para actualizar un nuevo cliente")

	@ApiResponses(value = { @ApiResponse(code = 200, message = "cliente actualizado correctamente"),

			@ApiResponse(code = 404, message = "Cliente no encontrado")})

	public ResponseEntity<Tipos> updateCliente(@PathVariable("identificacion") Integer identificacion,

			TiposVO tipoVO) {

		Tipos tipo = this.tipoService.findByNameType(identificacion);

		if (tipo == null) {

			return new ResponseEntity<Tipos>(HttpStatus.NOT_FOUND);

		} else {

			tipo.setNameType(tipoVO.getNameType());
			tipo.setDescription(tipoVO.getDescription());

		}



		return new ResponseEntity<>(this.tipoService.update(tipo), HttpStatus.OK);

	}
	
	
	@DeleteMapping("/{id}")

	@ApiOperation(value = "Eliminar candidato", notes = "Servicio para eliminar un candidato")

	@ApiResponses(value = { @ApiResponse(code = 200, message = "reserva eliminada correctamente"),

			@ApiResponse(code = 404, message = "Cliente no encontrado")})

	public void removeReserva(@PathVariable("id") Integer id) {

		 Tipos tipo = tipoService.findByNameType(id);	 

		if(tipo != null) {

			this.tipoService.delete(tipo);

		}

	}


	
}
