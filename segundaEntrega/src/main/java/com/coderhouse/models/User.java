
package com.coderhouse.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	@Schema(description = "ID del User", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	private String id;
	@Schema(description = "Nombre del User", requiredMode = Schema.RequiredMode.REQUIRED, example = "Usuario")
	private String nombre;
	@Schema(description = "Apellido del User", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test API")
	private String apellido;
	@Schema(description = "Email del User", requiredMode = Schema.RequiredMode.REQUIRED, example = "usuario@test.com")
	private String email;
	@Schema(description = "Fecha de Alta del User", requiredMode = Schema.RequiredMode.AUTO)
	private String creado;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreado() {
		return creado;
	}
	public void setCreado(String creado) {
		this.creado = creado;
	}
	
	
}