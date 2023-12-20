package models;

import java.util.UUID;

public class Usuario {
	private static int contador;
	
	private int id;
	private UUID idUsuario;
	private String nombre;
	private String apellido;
	private String email;
	private String tema;
	
	public Usuario (String nombre, String apellido, String email, String tema){
		this.nombre= nombre;
		this.apellido= apellido;
		this.email= email;
		this.tema= tema;
		this.id= ++contador;
		this.idUsuario = UUID.randomUUID();
	}
	
	public Usuario (int id, String nombre, String apellido, String email, String tema) 
	{
		this.id= id;
		this.nombre= nombre;
		this.apellido= apellido;
		this.email= email;
		this.tema= tema;
		
		this.idUsuario = UUID.randomUUID();
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
	
	public void setApellido (String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	public String getTema() {
		return tema;
	}
	public void setTema (String tema) {
		this.tema = tema;
	}

	
	public int getId() {
		return id;
	}
	

	public UUID getIdUsuario() {
		return idUsuario;
	}

	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido +", email=" + email + ", tema=" + tema;
	}
	
	
	

}
