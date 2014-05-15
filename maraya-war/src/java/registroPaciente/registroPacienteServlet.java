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
import java.util.Date;
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
            
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registroPacienteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registroPacienteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        //processRequest(request, response);
        
        // @todo obtener medico de la sesion y pasarlo como atributo
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
        
        Paciente p = new Paciente();
        
        p.setNss(nss);
        p.setNombre(nombre);       
        p.setProvincia(provincia);
        p.setApellidos(apellidos);
        p.setCodigoPostal(codigoPostal);
        p.setEmail(email);
        p.setCiudad(ciudad);
        p.setDni(dni);
        p.setFechaNacimiento(new Date());
        p.setTelefono(Integer.parseInt(telefono));
        
        PrintWriter out = response.getWriter();
        out.println(p.getNss());
        out.println(p.getNombre());
        out.println(p.getApellidos());
        out.println(p.getNss());
        out.println(p.getCodigoPostal());
        out.println(p.getEmail());
        out.println(p.getCiudad());
        out.println(p.getDni());
        out.println(p.getTelefono());
        
        //pacienteFacade.create(p);
        
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
