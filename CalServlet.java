/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CalServlet", urlPatterns = {"/CalServlet"})
public class CalServlet extends HttpServlet {

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
        String first = request.getParameter("num1");
        String second = request.getParameter("num2");
        double valFirst = Double.parseDouble(first);
        double valSec = Double.parseDouble(second);
        String operator = request.getParameter("operator");
        String o = "";
        double rs = 0;
        if (operator.equals("+")) {
            rs = valFirst + valSec;
            o = "+-*/";
        } else if (operator.equals("-")) {
            rs = valFirst - valSec;
            o = "-+*/";
        } else if (operator.equals("*")) {
            rs = valFirst * valSec;
            o = "*+-/";
        } else {
            rs = valFirst / valSec;
            o = "/-+*";
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            //first
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>First</td>");
            out.println("<td>");
            out.println("<input type='text'" + "value='" + first + "'>");
            out.println("<td>");
            out.println("</tr>");
            //second

            out.println("<tr>");
            out.println("<td>Second</td>");
            out.println("<td>");
            out.println("<input type='text'" + "value='" + second + "'>");
            out.println("<td>");
            out.println("</tr>");

            //operator
            out.println("<tr>");
            out.println("<td>Operator</td>");
            out.println("<td>");
            out.println("<select name='operator'>");
            out.println("<option>" + o.charAt(0) + "</option>");
            out.println("<option>" + o.charAt(1) + " </option>");
            out.println("<option>" + o.charAt(2) + " </option>");
            out.println("<option>" + o.charAt(3) + " </option>");
            out.println("</select>");
            out.println("<td>");
            out.println("</tr>");
            
            //button
            out.println("<tr>");
            out.println("<td></td>");
            out.println("<td>");
            out.println("<button type='submit'>Compute</button");
            out.println("<td>");
            out.println("</tr>");
            //Result
            out.println("<tr>");
            out.println("<td>Result</td>");
            out.println("<td>");
              out.println("<input type='text'" + "value='" + rs + "'>");
            out.println("<td>");
            out.println("</tr>");
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

        }

//        request.setAttribute("res", rs);
//        request.setAttribute("f", first);
//        request.setAttribute("s", second);
//        request.getRequestDispatcher("Calculator.jsp").forward(request, response);
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
