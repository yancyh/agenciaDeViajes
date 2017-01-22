

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aerolinea;
import modelo.CrudAerolinea;

/**
 *
 * @author Yancy
 */
public class ProcesarAerolinea extends HttpServlet {

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
        RequestDispatcher rd = null;
        Aerolinea aer = new Aerolinea();
        CrudAerolinea caer = new CrudAerolinea();
        String val = null;
        try{
            aer.setCodAerolinea(request.getParameter("codAerolinea"));
            aer.setNombre(request.getParameter("nombre"));
            if(request.getParameter("insertar") != null){
                caer.insertarAerolinea(aer);
                val = "Aerolinea insertada correctamente";
            }else if(request.getParameter("modificar") != null){
                caer.modificarAerolinea(aer);
                val = "Aerolinea modificada correctamente";
            }else if(request.getParameter("eliminar") != null){
                caer.eliminarAerolinea(aer);
                val = "Aerolinea eliminada correctamente";
            }
            rd = request.getRequestDispatcher("aerolinea.jsp");
            request.setAttribute("valor", val);
        }catch(Exception e) {
                request.setAttribute("error", e.toString());
        }
        rd.forward(request, response);
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
