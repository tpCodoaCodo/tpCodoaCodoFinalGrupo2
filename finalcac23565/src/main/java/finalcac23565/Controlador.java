package finalcac23565;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Usuario;
import infrastructure.persistence.*;
//import infrastructure.persistence.memory.*;
import infrastructure.persistence.mysql.MysqlRepositoryImpl;
import mappers.*;

@WebServlet("/Controlador")

public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// private IPersistencia persistence = new MemoryRepositoryImpl();
	private IPersistence persistence = new MysqlRepositoryImpl();
    private MapperJson mapper = new MapperJson();
    
    public Controlador() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Usuario> lista = persistence.listarUsuarios();
		String listaUsuariosJson = mapper.toJson(lista);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(listaUsuariosJson);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		// para que reconozca ñ y tildes
		request.setCharacterEncoding("UTF-8");
		
        String nombre = request.getParameter("nombreInput");
        String apellido = request.getParameter("apellidoInput");
        String email = request.getParameter("emailInput");
        String tema = request.getParameter("temaInput");
        
        Usuario usuario = new Usuario(nombre, apellido, email, tema);
		
		
		// persistir el usuario
		persistence.guardar(usuario);
			
		// para devolver el objeto creado al front ==> Json
		
		
		
		
		 String usuarioJson = mapper.toJson(usuario);
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(usuarioJson);
	        
	        System.out.println ("Nombre: " + nombre +  " Apellido: " + apellido + " email: " + email + " Tema: " + tema);
		
		
	}
	

	
	    
	}



	
	
		
		
		
	


