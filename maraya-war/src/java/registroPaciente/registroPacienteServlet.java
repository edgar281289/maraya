/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package registroPaciente;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import maraya.ejb.PacienteFacadeLocal;
import maraya.entity.Paciente;

/**
 *
 * @author Portatil
 */
@WebServlet(name = "registroPacienteServlet", urlPatterns = {"/registroPaciente"})
public class registroPacienteServlet extends HttpServlet {

    @EJB
    private PacienteFacadeLocal pacienteFacade;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/formularioNuevoPaciente.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        String nss = request.getParameter("nss");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String provincia = request.getParameter("provincia");
        String codigoPostal = request.getParameter("codigoPostal");
        String ciudad = request.getParameter("ciudad");
       
        List<String> errores = new ArrayList<String>();
     
        if ( nss == null || (! ( nss.length() > 1 && nss.length() <= 10 ) )){
            errores.add("El NSS no es valido (Entre 1 y 10 caracteres)");
        }
        
        if ( dni == null || (! ( dni.length() > 1 && dni.length() <= 9 ) ) ){
            errores.add("El dni no es valido (Entre 1 y 9 caracteres)");
        }

        if ( nombre == null || (! ( nombre.length() > 1 && nombre.length() <= 25 ) ) ){
            errores.add("El nombre no es valido (Entre 1 y 25 caracteres)");
        }
        
        if ( telefono == null || (! ( telefono.length() > 1 && telefono.length() <= 9 ) ) ){
            errores.add("El telefono introducido no es valido (Entre 1 y 9 caracteres)");
        
        }
        
        /* Date */
        Date fecha = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            fecha = formato.parse(fechaNacimiento);
        } catch (ParseException ex) {
            errores.add("La fecha no se ha podido convertir al formato adecuado");
        }
        
        if(fecha == null) errores.add("La fecha no es correcta");
        
        if ( provincia == null || (! ( provincia.length() > 1 && provincia.length() <= 30 ) ) ){
            errores.add("La provincia no es valida (Entre 1 y 30 caracteres)");
        }
        
        if ( ciudad == null || (! ( ciudad.length() > 1 && ciudad.length() <= 30 ) ) ){
            errores.add("La ciudad no es valida (Entre 1 y 30 caracteres)");
        }

        if ( codigoPostal == null || (! ( codigoPostal.length() > 1 && codigoPostal.length() <= 5 ) ) ){
            errores.add("El codigo postal no es valido (Entre 1 y 5 caracteres)");
        }
        
        // @todo - Validar el patron del email
        if ( email == null || (! ( email.length() > 1 && email.length() <= 50 ) ) ){
            errores.add("El email postal no es valido (Entre 1 y 50 caracteres)");
        }
        
        String next;
        
        if( errores.size() == 0){
            Paciente p = new Paciente(nss, dni, nombre, apellidos, fecha, Integer.parseInt(telefono), email, provincia, ciudad, codigoPostal);
            if( p != null ) pacienteFacade.create(p);
            next = "/index.jsp";
        }else{
            request.setAttribute("Errores", errores);
            next = "/error.jsp";
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(next);
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
