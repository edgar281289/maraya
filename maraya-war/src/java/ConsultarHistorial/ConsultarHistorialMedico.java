/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultarHistorial;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import maraya.ejb.GruposmedicosFacadeLocal;
import maraya.ejb.PacienteFacadeLocal;
import maraya.ejb.UsuariosPacientesFacadeLocal;
import maraya.entity.Gruposmedicos;
import maraya.entity.Medicos;
import maraya.entity.Paciente;
import maraya.entity.UsuariosMedicos;

/**
 *
 * @author Daniel Guerrero Salas
 */
@WebServlet(name = "ConsultarHistorialMedico", urlPatterns = {"/ConsultarHistorialesMedicos"})
public class ConsultarHistorialMedico extends HttpServlet {

    @EJB
    private GruposmedicosFacadeLocal gruposMedicosFacade;

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
        PrintWriter out = response.getWriter();

        HttpSession miSesion = request.getSession(false);
        UsuariosMedicos user = null;
        user = (UsuariosMedicos) miSesion.getAttribute("usuario");

        String tipoUser = (String) miSesion.getAttribute("tipoUsuario");
        try {

            if (tipoUser == "medico") {
                Medicos medico = user.getMedico();

                List<Gruposmedicos> lsGrupos = null;
                List<Paciente> lsPacientes = new ArrayList<Paciente>();
                lsGrupos = gruposMedicosFacade.buscarPacientes(medico);

                for (Gruposmedicos m : lsGrupos) {
                    lsPacientes.add(m.getPaciente());
                }

                request.setAttribute("listaPacientes", lsPacientes);
                RequestDispatcher dispatcher = request.getRequestDispatcher("MostrarPacientes.jsp");
                dispatcher.forward(request, response);
            } else {
                out.println("<h1>No tienes permisos para ver el historial </h1>");
            }
        } catch (EJBException ed) {
            out.println(ed.getMessage());
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
        processRequest(request, response);
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
        processRequest(request, response);
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
