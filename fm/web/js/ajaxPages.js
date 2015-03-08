/* 
 * Cargar Ciudades en Pos de un Departamento
 */

var xmlHttp;
function getSubcategorias(idDepartamento) {

    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        alert("El navegador no soporta Ajax!");
        return;
    }

    var url = "../ajax/cargarCiudades.jsp?idDepartamento=" + idDepartamento;
    xmlHttp.onreadystatechange = resultadoCiudades;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);

}

function resultadoCiudades() {
    if (xmlHttp.readyState === 4) {
        document.getElementById("ruCiudad").innerHTML = xmlHttp.responseText;
    }
}
/* 
 *  Fin de cargar Ciudades en Pos de un Departamento
 */



