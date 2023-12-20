document.addEventListener('DOMContentLoaded', function () {
    const formulario = document.getElementById('formularioOradores');
    const botonEnviar = document.getElementById('btnEnviar');

    botonEnviar.addEventListener('click', function () {
        enviarDatos();
    });

    function enviarDatos() {
        const nombreInput = document.getElementById('nombreInput');
        const apellidoInput = document.getElementById('apellidoInput');
        const emailInput = document.getElementById('emailInput');
        const temaInput = document.getElementById('temaInput');

        if (nombreInput && apellidoInput && emailInput && temaInput) {
            const nombre = nombreInput.value;
            const apellido = apellidoInput.value;
            const email = emailInput.value;
            const tema = temaInput.value;

            fetch('http://localhost:8080/finalcac23565/Controlador', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: `nombreInput=${nombre}&apellidoInput=${apellido}&emailInput=${email}&temaInput=${tema}`,
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Respuesta del servidor:', data);

                    // Después de recibir la respuesta, actualiza la tabla de oradores
                    actualizarTabla();
                })
                .catch(error => console.error('Error:', error));
        } else {
            console.error('Alguno de los elementos de entrada no existe en el documento.');
        }
    }

    function actualizarTabla() {
        // Llama a la función para listar usuarios y actualizar la tabla
        listarUsuarios();
    }

    function listarUsuarios() {
        fetch('http://localhost:8080/finalcac23565/Controlador', {
            method: 'GET',
        })
            .then(response => response.json())
            .then(data => renderizarTabla(data))
            .catch(error => console.log('Error al traer los usuarios: ' + error));
    }

    function renderizarTabla(data) {
        const tabla = document.getElementById('cuerpoTabla');
        tabla.innerHTML = '';

        data.forEach(element => {
            const fila = document.createElement('tr');
            fila.innerHTML = `<td>${element.idUsuario}</td>
                              <td>${element.nombre}</td>
                              <td>${element.apellido}</td>
                              <td>${element.email}</td>
                              <td>${element.tema}</td>`;
            tabla.appendChild(fila);
        });
    }

    // Al cargar la página, también se debe listar los usuarios existentes
    listarUsuarios();
});
