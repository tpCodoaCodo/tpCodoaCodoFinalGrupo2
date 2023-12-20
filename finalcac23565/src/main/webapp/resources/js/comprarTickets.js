document.addEventListener("DOMContentLoaded", function () {
    const cantidadTicketsInput = document.getElementById("cantidadTickets");
    const categoriaSelect = document.getElementById("categoriaSelect");
    const totalPago = document.getElementById("totalPago");

    // Agrega un evento al botón "Resumen"
    document.getElementById("btnResumen").addEventListener("click", function () {
        // Obtiene la cantidad de tickets y la categoría seleccionada
        const cantidadTickets = parseInt(cantidadTicketsInput.value);
        const categoria = parseInt(categoriaSelect.value);

        // Define los precios y descuentos para cada categoría
        const precios = [200, 200, 200, 200]; // Sin categoría, Estudiante, Trainee, Junior
        const descuentos = [0, 0.8, 0.5, 0.15]; // Sin categoría, Estudiante, Trainee, Junior

        // Calcula el total con descuento
        const precioPorTicket = precios[categoria];
        const descuento = descuentos[categoria];
        const total = cantidadTickets * precioPorTicket * (1 - descuento);

        // Actualiza el elemento HTML con el total calculado
        totalPago.textContent = total.toFixed(2); // Formatea el total con 2 decimales

    });

    document.getElementById("btnBorrar").addEventListener("click", function () {
        totalPago.textContent = "";})


});


