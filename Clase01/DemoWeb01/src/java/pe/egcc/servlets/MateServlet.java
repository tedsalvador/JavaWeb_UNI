/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.service.MateService;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "MateServlet",
        urlPatterns = {"/Suma", "/Resta", "/Multiplica", "/Divide"})
public class MateServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.println("<h1>Hora del beak!!!!!!!!!!!!!!!!!!</h1>");
//        out.flush();
//        out.close();

        String path = request.getServletPath();
        if (path.equals("/Suma"))    {
            suma(request,response);
        } else if(path.equals("/Resta")){
            resta(request,response);
        }
    }

    private void suma(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //datos
       int num1, num2, resultado;
       MateService mateService = new MateService();
    
    num1 = Integer.parseInt(request.getParameter("n1"));
    num2 = Integer.parseInt(request.getParameter("n2"));
        // proceso
        resultado = mateService.sumar(num1, num2);
 
        try {
               Thread.currentThread().sleep(1000);
                } catch (Exception e) {
              }
        
        //Reporte
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<p>Num 1:  " + num1 + "</p>");
        out.println("<p>Num 2:  " + num2 + "</p>");
        out.println("<p>Res. Suma:  " + resultado + "</p>");
    }

    private void resta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //datos
       int num1, num2, resultado;
       MateService mateService = new MateService();
    
    num1 = Integer.parseInt(request.getParameter("n1"));
    num2 = Integer.parseInt(request.getParameter("n2"));
        // proceso
        resultado = mateService.restar(num1, num2);
      //preparando la data
        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("resta", resultado);
        //haciendo el forward
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("restaRpta.jsp");
        rd.forward(request, response);
        
    }
}
