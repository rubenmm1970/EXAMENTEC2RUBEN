/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.modelo.GestorProduc_rMachaca;
import com.emergentes.modelo.Produc_rMachaca;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ruben
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produc_rMachaca objProducto = new Produc_rMachaca();
        int id, pos;
        
        String op=request.getParameter("op");
        
        if(op.equals("nuevo"))
        {
            HttpSession ses = request.getSession();
            GestorProduc_rMachaca produc =(GestorProduc_rMachaca) ses.getAttribute("produc");
            objProducto.setId(produc.obtieneId());
            request.setAttribute("op", op);
            request.setAttribute("miProducto", objProducto);
            request.getRequestDispatcher("editar.jsp").forward(request, response);    
        }
        
        if(op.equals("modificar"))
        {
            id=Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorProduc_rMachaca produc =(GestorProduc_rMachaca) ses.getAttribute("produc");
            pos=produc.ubicarProducto(id);
            objProducto = produc.getLista().get(pos);
            
            request.setAttribute("op", op);
            request.setAttribute("miProducto", objProducto);
            request.getRequestDispatcher("editar.jsp").forward(request, response);  
        }

        if(op.equals("eliminar"))
        {
            id=Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorProduc_rMachaca produc =(GestorProduc_rMachaca) ses.getAttribute("produc");
            pos=produc.ubicarProducto(id);
            produc.eliminarProducto(pos);
            ses.setAttribute("produc", produc);
            response.sendRedirect("index.jsp");

        } 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Produc_rMachaca objProducto = new Produc_rMachaca();
        int pos;
        String op=request.getParameter("op");
        
        if(op.equals("grabar"))
        {
            objProducto.setId(Integer.parseInt(request.getParameter("id")));
            objProducto.setDescripcion(request.getParameter("descripcion"));
            objProducto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
            objProducto.setPrecio(Double.parseDouble(request.getParameter("precio")));
            objProducto.setCategoria(request.getParameter("categoria"));
            
            HttpSession ses = request.getSession();
            GestorProduc_rMachaca produc =(GestorProduc_rMachaca) ses.getAttribute("produc");
            
            String opg = request.getParameter("opg");
            if(opg.equals("nuevo"))
            {
                produc.insertarProducto(objProducto);
            }
            else
            {
                pos=produc.ubicarProducto(objProducto.getId());
                produc.modificarProducto(pos, objProducto);
            }
            ses.setAttribute("produc", produc);
            response.sendRedirect("index.jsp");       
        }    
        
    }

}
