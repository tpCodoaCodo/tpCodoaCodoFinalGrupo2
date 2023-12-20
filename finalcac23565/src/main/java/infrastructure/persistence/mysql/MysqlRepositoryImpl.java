package infrastructure.persistence.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import infrastructure.persistence.IPersistence;
import models.Usuario;

public class MysqlRepositoryImpl implements IPersistence {

    private Connection connection;

    public MysqlRepositoryImpl() {
        connection = ConnectionBD.getConnection();
    }

    @Override
    public void guardar(Usuario newUsuario) {
        String query = "INSERT INTO usuarios (nombre, apellido, email, tema) VALUES (?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, newUsuario.getNombre());
            statement.setString(2, newUsuario.getApellido());
            statement.setString(3, newUsuario.getEmail());
            statement.setString(4, newUsuario.getTema());

            statement.execute();

            // No es recomendable cerrar la conexión aquí si vas a realizar más operaciones
            // connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("email");
                String tema = resultSet.getString("tema");

                Usuario usuario = new Usuario(id, nombre, apellido, email, tema);
                usuarios.add(usuario);
            }

            // No cierres la conexión aquí si planeas seguir usando la conexión
            // connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public Usuario getUsuarioPorId(String Id) {
        // Implementa la lógica para obtener un usuario por su ID
        return null;
    }

    @Override
    public Usuario update(String usuario) {
        // Implementa la lógica para actualizar un usuario
        return null;
    }

    @Override
    public void delete(String Id) {
        // Implementa la lógica para eliminar un usuario
    }
}