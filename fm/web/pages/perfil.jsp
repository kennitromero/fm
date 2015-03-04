<%-- 
    Document   : plantilla
    Created on : 27/02/2015, 12:22:03 PM
    Author     : kennross
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="../img/favicon.ico">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../css/font-awesome.css">
        <script type="text/javascript" src="../js/jquery-1.11.2.js"></script>
        <script type="text/javascript" src="../js/bootstrap.js"></script>
        <title>Mi Perfil - Farmer's Market</title>
    </head>
    <body>
        <div class="container">
            <!-- Banner Farmer's Market -->
            <div class="row">
                <div class="col-md-12">
                    <img src="../img/banner.jpg" alt="Banner de Farmer's Market" width="1000px">
                </div>
            </div>
            <!-- Fin del Banner  -->

            <!-- Contenedor Principal de la Página -->
            <div class="row">
                <!-- Dashboard -->
                <div class="col-md-2" style="background: #FAFAFA; border-radius: 3px">
                    <!-- Información del Rol iniciado -->
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img class="media-object img-circle" width="50" src="../img/avatars/avatar.png" alt="Mi foto de perfil">
                            </a>
                        </div>
                        <div class="media-body">
                            <p></p>
                            <h4 class="media-heading">Productor</h4>
                            Kennit Romero
                        </div>
                    </div>
                    <!-- Fin del rol iniciado -->
                    <hr>

                    <!-- Menú de navegación -->
                    <ul class="nav nav-pills nav-stacked">
                        <li role="presentation" class="active text-left"><a href="#">Inicio <i class="fa fa-shopping-cart "></i></a></li>
                        <li role="presentation" class="text-left"><a href="#">Mis pedidos <i class="fa fa-shopping-cart "></i></a></li>
                        <li role="presentation" class="text-left"><a href="#">Productos <i class="fa fa-shopping-cart "></i></a></li>                        
                        <li role="presentation" class="text-left"><a href="#">Mis Productos <i class="fa fa-shopping-cart "></i></a></li>
                        <li role="presentation" class="text-left"><a href="#">Catalogo <i class="fa fa-list-alt "></i></a></li>
                    </ul>
                    <!-- Fin del menú de navegación -->

                </div>
                <!-- Fin de la Dashboard -->


                <!-- Contenedor de Segundo-->
                <div class="col-md-10">
                    <!-- Menú de Sesion, buscar, idiomas y info -->
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <a href="#" class="navbar-brand text-success">
                                    Pedidos <span class="badge info">4</span> 
                                </a>
                                <a href="#" class="navbar-brand text-success">
                                    Ofertas <span class="badge">18</span>
                                </a>
                            </div>
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                <ul class="nav navbar-nav navbar-right">                                    
                                    <li><a href="#"><img src="../img/flag/ing/flag-ingles-16.png" alt="Cambiar idioma a Inglés" title="Cambiar idioma a Inglés"></a></li>
                                    <li><a href="#"><img src="../img/flag/spa/flag-spanis16.png" alt="Cambiar idioma a Español" title="Cambiar idioma a Español"></a></li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> Kennit Romero <span class="fa fa-chevron-down"></span></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li class="text-center"><a href="#">Cerrar Sesión</a></li>
                                            <li class="divider"></li>
                                            <li class="text-center"><a href="perfil.jsp">Mi Perfil</a></li>
                                            <li class="divider"></li>
                                            <li class="text-center"><a href="#" data-toggle="modal" data-target="#modalCambiarClave">Cambiar Contraseña</a></li>
                                            <li class="divider"></li>
                                            <li class="text-center"><a href="#">Ayuda <i class="fa fa-exclamation-circle"></i></a></li>
                                        </ul>
                                    </li>
                                </ul>
                                <form class="navbar-form navbar-right" role="search">
                                    <div class="form-group">
                                        <div class="input-group">                                            
                                            <input type="text" class="form-control" placeholder="¿Qué está buscando?...">
                                            <span class="input-group-btn">
                                                <button class="btn btn-default" type="submit">Buscar!</button>
                                            </span>
                                        </div>
                                    </div>
                                </form>

                                <ul class="navbar-form navbar-toggle">                                                                                
                                    <button class="btn btn-success navbar-brand" type="button">
                                        Pedidos <span class="badge">4</span>
                                    </button>
                                </ul>
                            </div>
                        </div>
                    </nav>
                    <!-- Fin de menú de sesión, buscar, idiomas y info -->

                    <!-- Miga de pan -->
                    <ol class="breadcrumb">
                        <li><a href="#">Inicio</a></li>                        
                        <li class="active"><a href="perfil.jsp"></a>Perfil</li>
                    </ol>
                    <!-- Fin de miga de pan -->

                    <!-- Mensajes de alertas
                    <div class="alert alert-success" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <p class="text-center"><strong><i class="glyphicon glyphicon-exclamation-sign"></i> Esto Ocurrió!</strong> Mensaje de prueba para las alertas</p>
                    </div>
                    <div class="alert alert-info" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <p class="text-center"><strong><i class="glyphicon glyphicon-exclamation-sign"></i> Esto Ocurrió!</strong> Mensaje de prueba para las alertas</p>
                    </div>
                    <div class="alert alert-warning" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <p class="text-center"><strong><i class="glyphicon glyphicon-exclamation-sign"></i> Esto Ocurrió!</strong> Mensaje de prueba para las alertas</p>
                    </div>
                    <div class="alert alert-danger" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <p class="text-center"><strong><i class="glyphicon glyphicon-exclamation-sign"></i> Esto Ocurrió!</strong> Mensaje de prueba para las alertas</p>
                    </div>
                    Fin de mensajes de alertas -->

                    <!-- Contenedor de contenido especifico -->
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="container-fluid">
                                    <form class="form-horizontal">
                                        <legend class="text-center">Mis Datos Personales</legend>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="auDocumento" class="col-sm-4 control-label">Documento</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="auDocumento" class="form-control" 
                                                           id="auDocumento" placeholder="Documento">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="auNombres" class="col-sm-4 control-label">Nombres</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="auNombres" class="form-control" 
                                                           id="auNombres" placeholder="Sus nombres">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="auApellidos" class="col-sm-4 control-label">Apellidos</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="auApellidos" class="form-control" 
                                                           id="auApellidos" placeholder="Sus apellidos">
                                                </div>
                                            </div>

                                            <div class="form-group has-feedback has-error">
                                                <label for="auCorreo" class="col-sm-4 control-label">Correo</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="auCorreo" class="form-control" 
                                                           id="auCorreo" placeholder="Correo electrónico">
                                                    <i class="glyphicon glyphicon-remove form-control-feedback"></i>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group has-feedback has-warning">
                                                <label for="auCiudad" class="col-sm-4 control-label">Ciudad</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="auCiudad" class="form-control" 
                                                           id="auCiudad" placeholder="Ciudad">
                                                    <!-- Al momento de validar, se le manda la class a la i para agregar icon-->
                                                    <i class="glyphicon glyphicon-exclamation-sign form-control-feedback"></i>
                                                </div>
                                            </div>

                                            <div class="form-group has-feedback has-warning">
                                                <label for="auCiudad" class="col-sm-4 control-label">Depart...</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="auCiudad" class="form-control" 
                                                           id="auCiudad" placeholder="Departamento">
                                                    <!-- Al momento de validar, se le manda la class a la i para agregar icon-->
                                                    <i class="glyphicon glyphicon-exclamation-sign form-control-feedback"></i>
                                                </div>
                                            </div>

                                            <div class="form-group has-feedback has-success">
                                                <label for="auDireccion" class="col-sm-4 control-label">Dirección</label>
                                                <div class="col-sm-8">
                                                    <input type="text" name="auDireccion" class="form-control" 
                                                           id="auDireccion" placeholder="Dirección">
                                                    <!-- Al momento de validar, se le manda la class a la i para agregar icon-->
                                                    <i class="glyphicon glyphicon-ok form-control-feedback"></i>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="auCiudad" class="col-sm-4 control-label">Telefono:</label>
                                                <div class="col-sm-8">
                                                    <div class="input-group">
                                                        <span class="input-group-btn">
                                                            <button class="btn btn-default" data-toggle="modal" data-target="#modalNumeros" type="button">Ver o agregar números</button>
                                                        </span>
                                                    </div><!-- /input-group -->
                                                </div>
                                            </div>
                                        </div>
                                        <center>
                                            <input type="button" data-toggle="modal" data-target="#modalConfirmarActualizar" class="btn btn-success" value="Actualizar Datos">
                                        </center>                                        
                                    </form>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <h4 class="text-center">Kennit Romero</h4>
                                <div class="container-fluid">
                                    <img src="../img/avatars/avatar.png" alt="..." class="img-thumbnail">
                                </div>                                
                            </div>
                        </div>                              
                    </div>
                    <!-- Fin de contenedor de contenido especifico -->


                    <!-- Ventanas Modales -->
                    <div class="container-fluid">
                        <!-- Cambiar Contraseña -->
                        <div>
                            <div class="modal fade" id="modalCambiarClave" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title text-center" id="myModalLabel">Cambiar Contraseña</h4>
                                        </div>
                                        <div class="modal-body">

                                            <form class="form-horizontal">
                                                <div class="form-group has-error has-feedback">
                                                    <label for="ccClaveAntigua" class="col-sm-4 control-label">Contraseña Antigua</label>
                                                    <div class="col-sm-7">
                                                        <input type="password" class="form-control" 
                                                               id="ccClaveAntigua" placeholder="Ingrese la contraseña antigua"
                                                               name="ccClaveAntigua">
                                                        <!-- Al momento de validar, se le manda la class a la i para agregar icon-->
                                                        <i class="glyphicon glyphicon-remove form-control-feedback"></i>
                                                    </div>
                                                </div>

                                                <div class="form-group has-warning has-feedback">
                                                    <label for="ccClaveNueva" class="col-sm-4 control-label">Nueva Contraseña</label>
                                                    <div class="col-sm-7">                                                        
                                                        <input type="password" class="form-control" 
                                                               id="ccClaveNueva" placeholder="Ingrese una nueva contraseña"
                                                               name="ccClaveNueva">
                                                        <!-- Al momento de validar, se le manda la class a la i para agregar icon-->
                                                        <i class="glyphicon glyphicon-exclamation-sign form-control-feedback"></i>
                                                    </div>
                                                </div>

                                                <div class="form-group has-success has-feedback">
                                                    <label for="ccClaveRepetida" class="col-sm-4 control-label">Repetir Contraseña</label>
                                                    <div class="col-sm-7">
                                                        <input type="password" class="form-control" 
                                                               id="ccClaveRepetida" placeholder="Repita la contraseña"
                                                               name="ccClaveRepetida">
                                                        <!-- Al momento de validar, se le manda la class a la i para agregar icon-->
                                                        <i class="glyphicon glyphicon-ok form-control-feedback"></i>
                                                    </div>
                                                </div>
                                            </form>                                                                                        
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                                            <button type="button" class="btn btn-success">Cambiar Contraseña</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>                        

                        <!-- Formulario de Contáctenos -->
                        <div>
                            <div class="modal fade" id="modalContactenos" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title text-center" id="myModalLabel">Contáctenos | Farmer's Market</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form class="form-horizontal">
                                                <div class="form-group">
                                                    <label for="mcNombre" class="col-sm-2 control-label">Nombre</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control" name="mcNombre"
                                                               id="mcNombre" placeholder="Ingrese su nombre">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="mcCorreo" class="col-sm-2 control-label">Correo</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control" name="mcCorreo"
                                                               id="mcCorreo" placeholder="Ingrese su correo electrónico">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="inputPassword3" class="col-sm-2 control-label">Mensaje</label>
                                                    <div class="col-sm-10">
                                                        <textarea class="form-control" rows="4" placeholder="Ingrese su mensaje para la compañía Farmer's Market"></textarea>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                            <button type="button" class="btn btn-success">Enviar Mensaje</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Fin de formulario de Contáctenos -->

                        <!-- Confirmación para actualizar datos -->
                        <div class="modal fade bs-example-modal-sm" id="modalConfirmarActualizar" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-sm">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p class="text-center lead">¿Está seguro que desea modificar sus datos?</p>
                                        <center>
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                                            <button type="button" class="btn btn-success">Actualizar Datos</button>
                                        </center>                                        
                                    </div>                                                                                                               
                                </div>
                            </div>
                        </div>
                        <!-- Fin de confirmación para actualiazar datos -->

                        <!-- Modal formulario para los números telefonicos -->
                        <!-- Modal -->
                        <div class="modal fade" id="modalNumeros" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">Mis números de telefono</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <div class="col-md-12">
                                                <form class="form-inline">
                                                    <legend class="text-center">Registro de telefonos</legend>
                                                    <div class="form-group">
                                                        <label for="exampleInputName2">Número de Telefono</label>
                                                        <input type="text" class="form-control" id="exampleInputName2" placeholder="Ingrese su el número de telefono">
                                                    </div>
                                                    <button type="submit" class="btn btn-default">Agregar</button>
                                                </form>
                                                <br>
                                                <form class="form-inline">
                                                    <legend class="text-center">Actualización de telefonos</legend>
                                                    <div class="form-group">
                                                        <label for="exampleInputName2">Número de Telefono</label>
                                                        <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
                                                    </div>
                                                    <button type="submit" class="btn btn-default">Actualizar</button>
                                                </form>

                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th class="text-center">Número</th>
                                                            <th class="text-center">Acciones</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr class="text-center">
                                                            <td>301 303 3317</td>
                                                            <td>
                                                                <a href=""><i class="fa fa-remove"></i> Eliminar</a>&nbsp;
                                                                <a href=""><i class="fa fa-pencil"></i> Editar</a>
                                                            </td>
                                                        </tr>
                                                        <tr class="text-center">                                                            
                                                            <td>322 241 9746</td>                                                            
                                                            <td>
                                                                <a href=""><i class="fa fa-remove"></i> Eliminar</a>&nbsp;
                                                                <a href=""><i class="fa fa-pencil"></i> Editar</a>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Fin de modal para los números telefonicos -->


                    </div>

                </div>
                <!-- Contenedor de Segundo-->
            </div>
            <!-- Fin de contenedor Principal de la Página -->
            <p></p>
            <!-- Footer (Nota: Escribir el código que permita que esto quede abajo fijo) -->
            <div class="row">
                <div class="col-md-13">
                    <!-- Footer (Nota: Escribir el código que permita que esto quede abajo fijo) -->
                    <ol class="breadcrumb container-fluid">
                        <em class="text-center">Todos los derechos reservados / <a href="http://getbootstrap.com/">Bootstrap</a> / <a href="http://fortawesome.github.io/Font-Awesome/">Font-Awesome</a> / <a href="http://jquery.com/">JQuery</a></em>
                        <em class="pull-right"><a href="#" data-toggle="modal" data-target="#modalContactenos">Contactar un Administrador</a></em>
                    </ol>

                </div>
            </div>
            <!-- Fin del Footer -->
        </div>
    </body>
</html>
