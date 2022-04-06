<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Produc_rMachaca"%>
<%@page import="com.emergentes.modelo.GestorProduc_rMachaca"%>
<%
    if (session.getAttribute("produc") == null)
    {
        GestorProduc_rMachaca objeto1 = new GestorProduc_rMachaca();
        
        objeto1.insertarProducto(new Produc_rMachaca(1, "Coca cola",100, 10, "Bebidas"));
        objeto1.insertarProducto(new Produc_rMachaca(2, "Pepsi",50, 11, "Bebidas"));
        objeto1.insertarProducto(new Produc_rMachaca(3, "Frack",100, 2.50, "Galletas"));
        objeto1.insertarProducto(new Produc_rMachaca(4, "Serranitas",80, 1.50, "Galletas"));
        session.setAttribute("produc", objeto1);
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>
                    <p>PRIMER PARCIAL TEM-742</p>
                    <p>Nombre: Ruben Machaca Mamani</p>
                    <p>CI: 3328066 </p>
                </th>
            </tr>
        </table>
        
        <h1>Registro de Productos</h1>
        
        <a href="Controller?op=nuevo">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${sessionScope.produc.getLista()}">    
            <tr>
                <th>${item.id}</th>
                <th>${item.descripcion}</th>
                <th>${item.cantidad}</th>
                <th>${item.precio}</th>
                <th>${item.categoria}</th>
                <th><a href="Controller?op=modificar&id=${item.id}">Editar</a></th>
                <th><a href="Controller?op=eliminar&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar??'))">Eliminar</a></th>
            </tr>                           
            </c:forEach>        
        </table>
    </body>
</html>
