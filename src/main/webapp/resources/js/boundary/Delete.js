/* global fetch */
var url = "http://localhost:8080/FlotaWebAppComplete/rest/tipoEstadoReserva/";
var id = document.getElementById("idTipo");

function Eliminar() {
    document.getElementById("crud").addEventListener("submit", function(e) {
        e.preventDefault();
        console.log('me diste un click');

        Delete(url + id.value, id.value);
    });
}

function Delete(url, datos) {
    fetch(url, {
        method: 'DELETE'

    }).then(res => res.json())
            .catch(error => console.error('Error:', error))
            .then(response => console.log('Success:', response));
}
