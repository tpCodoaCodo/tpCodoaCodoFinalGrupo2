package infrastructure.persistence;

import java.util.ArrayList;

import models.Usuario;

public interface IPersistence {
	
	//CRUD
	
	//CREATE
	
	void guardar (Usuario newUsuario);
	
	//READ
	
	ArrayList<Usuario> listarUsuarios();
	
	Usuario getUsuarioPorId(String Id);
	
	//UPDATE
	
	Usuario update(String usuario);
	
	//DELETE
	
	void delete (String Id);

}
