/* global fetch */

var url = "http://localhost:8080/FlotaWebAppComplete/rest/tipoEstadoReserva";
var id = document.getElementById("idTipo");
var nombres = document.getElementById("nom");
var activo = document.getElementById("act");
var indica = document.getElementById("ind");
var observacion = document.getElementById("obs");

function funciPut() {
    document.getElementById("crud").addEventListener("submit", function(e) {
        e.preventDefault();
        console.log('Haz hecho un click');

        let data = {idTipoEstadoReserva: id.value, activo: activo.checked, indicaAprobacion: indica.checked, nombre: nombres.value, observaciones: observacion.value};
        console.log(data);
        doPut(url, data);

    });
}
function doPut(url, data) {
    fetch(url, {
        method: 'PUT', // or 'PUT'
        body: JSON.stringify(data), // data can be `string` or {object}!
        headers: {
            'Content-Type': 'application/json ; charset=UTF-8'
        }
    }).then(res => res.json())
            .catch(error => console.error('Error:', error))
            .then(response => console.log('Success:', response));
}
