package infrastructure.persistence.memory;

import java.util.ArrayList;
import java.util.UUID;

import infrastructure.persistence.IPersistence;

import models.Usuario;

public class MemoryRepositoryImpl implements IPersistence {
	
	public static ArrayList<Usuario> bdMemoria = new ArrayList<>();
	
	@Override
	public void guardar(Usuario newUsuario) {
		if (newUsuario != null) {
            bdMemoria.add(newUsuario);
            System.out.println("Usuario guardado exitosamente.");
        } else {
            System.out.println("El usuario proporcionado es nulo.");
        }
		
	}

	@Override
	public ArrayList<Usuario> listarUsuarios() {
		
		return MemoryRepositoryImpl.bdMemoria;
	}

	@Override
	public Usuario getUsuarioPorId(String id) {
		for (Usuario usuario : bdMemoria) {
			
            if (usuario.getIdUsuario().equals(UUID.fromString(id))) {
                return usuario;
            }
        }
        return null;
	}


	@Override
	public void delete(String id) {
		Usuario usuarioAEliminar = null;
        for (Usuario usuario : bdMemoria) {
            if (usuario.getIdUsuario().equals(UUID.fromString(id))) {
                usuarioAEliminar = usuario;
                break;
            }
        }
        if (usuarioAEliminar != null) {
            bdMemoria.remove(usuarioAEliminar);
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("No se encontró ningún usuario con el ID proporcionado.");
        }
		
	}

	
	public Usuario update(Usuario usuarioActualizado) {
		for (int i = 0; i < bdMemoria.size(); i++) {
	        Usuario usuario = bdMemoria.get(i);
	        if (usuario.getIdUsuario().equals(usuarioActualizado.getIdUsuario())) {
	            bdMemoria.set(i, usuarioActualizado);
	            System.out.println("Usuario actualizado exitosamente.");
	            return usuarioActualizado;
	        }
	    }
	    System.out.println("No se encontró ningún usuario con el ID proporcionado para actualizar.");
	    return null;
	}

	@Override
	public Usuario update(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
