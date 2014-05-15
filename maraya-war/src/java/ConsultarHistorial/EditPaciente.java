/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ConsultarHistorial;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import maraya.ejb.RegistroHistorialFacadeLocal;
import maraya.entity.RegistroHistorial;
import maraya.entity.UsuariosMedicos;

/**
 *
 * @author FranciscoJesús
 */
@WebServlet(name = "EditPaciente", urlPatterns = {"/EditPaciente"})
public class EditPaciente extends HttpServlet {

    @EJB
    private RegistroHistorialFacadeLocal facade;
    
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
            Long id = Long.parseLong(request.getParameter("ID"));
            String contenido = request.getParameter("textarea");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditPaciente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditPaciente at " + id +" "+contenido+ "</h1>");
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
        // processRequest(request, response);
        
        HttpSession sesion = request.getSession(false);
        if(sesion != null){
           // UsuariosMedicos medico = (UsuariosMedicos)sesion.getAttribute("usuario");
            String tipo = (String)sesion.getAttribute("tipoUsuario");
        if(tipo.equals("medico")){
                long idRegistro =  Long.parseLong(request.getParameter("Historial"));
                
                //System.out.println(idRegistro);
                RegistroHistorial Registro = facade.find(idRegistro);
                request.setAttribute("Registro", Registro);
                request.setAttribute("ID", idRegistro);
                //request.setAttribute("NSS", nssPaciente);
                
                /*PrintWriter out = response.getWriter();
                out.println("idRegistro: " + request.getParameter("Historial"));*/
                
               	
            }
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EditPaciente.jsp");	
             dispatcher.forward(request, response);
            
        }
        
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
        
        HttpSession sesion = request.getSession(false);
        
        if(sesion == null){
        }else{
           String tipo = (String)sesion.getAttribute("tipoUsuario");
            if(tipo.equals("medico")){
                int id = Integer.parseInt(request.getParameter("ID"));
                RegistroHistorial registro = facade.find(id);
                UsuariosMedicos med = (UsuariosMedicos)sesion.getAttribute("usuario");
                String contenido = request.getParameter("textarea");
                
                registro.setContenido(contenido);
                registro.setMedico(med.getMedico());
                registro.setFechaModificacion(new Date());
                //int id = (int)request.getAttribute("ID");
                //RegistroHistorial registro = (RegistroHistorial) request.getAttribute("Regist");
                
               
               Long idHistorial = Long.parseLong(request.getParameter("idHistorial"));
                facade.edit(registro);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RegistrosPaciente?historial="+idHistorial);	
                dispatcher.forward(request,response);
            }
        }
        
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
