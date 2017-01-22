

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CrudHotel;
import modelo.Hotel;

/**
 *
 * @author yancy
 */
public class ProcesarHotel extends HttpServlet {

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
        Hotel htl = new Hotel();
        CrudHotel chtl = new CrudHotel();
        String val = null;
        try{
            htl.setCodHotel(request.getParameter("codHotel"));
            htl.setNombre(request.getParameter("nombre"));
            if(request.getParameter("insertar") != null){
                chtl.insertarHotel(htl);
                val = "Hotel insertado correctamente";
            }else if(request.getParameter("modificar") != null){
                chtl.modificarHotel(htl);
                val = "Hotel modificado correctamente";
            }else if(request.getParameter("eliminar") != null){
                chtl.eliminarHotel(htl);
                val = "Hotel eliminado correctamente";
            }
            rd = request.getRequestDispatcher("hotel.jsp");
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
