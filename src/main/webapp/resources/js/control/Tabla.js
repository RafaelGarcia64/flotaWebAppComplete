
function findRange() {
    fetch('http://localhost:8080/FlotaWebAppComplete/rest/tipoEstadoReserva/Range?inicio=0&cantidad=10').then(res => res.json()).then(datos => {
        console.log(datos);
        tabla(datos);
    });
}

function findAll() {
    fetch("http://localhost:8080/FlotaWebAppComplete/rest/tipoEstadoReserva/todo").then(res => res.json()).then(datos => {
        console.log(datos);
        tabla(datos);
    });
}

var contenido = document.getElementById("contenido");
function tabla(datos) {
    // console.log(datos)
    contenido.innerHTML = '';
    for (let valor of datos) {
        // console.log(valor.nombre)
        contenido.innerHTML += `
            <tr>
                <th scope="row">${ valor.idTipoEstadoReserva}</th>
                <td>${ valor.nombre }</td>
                <td>${ valor.activo ? "Activo" : "Inactivo" }</td>
                <td>${ valor.indicaAprobacion ? "Activo" : "Inactivo" }</td>
                <td>${ valor.observaciones }</td>
            </tr>
        `;
    }
}

window.onload = function() {
    findRange();
};