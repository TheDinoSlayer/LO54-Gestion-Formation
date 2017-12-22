/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.servlet;

import fr.utbm.td.formation.entity.CourseSession;
import fr.utbm.td.formation.entity.Location;
import fr.utbm.td.formation.service.CourseSessionService;
import fr.utbm.td.formation.service.LocationService;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ag
 */
@WebServlet(name = "SearchCoursesServlet", urlPatterns = {"/searchcourses"})
public class SearchCoursesServlet extends HttpServlet {

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
        LocationService ls = new LocationService();
        List<Location> locations = ls.getLocations();
        request.setAttribute("locations", locations);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/searchcourses.jsp");
        rd.forward(request, response);
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
        LocationService ls = new LocationService();
        List<Location> locations = ls.getLocations();
        request.setAttribute("locations", locations);

        String title = request.getParameter("title");
        String city = request.getParameter("location");

        String date = request.getParameter("date");
        String startHour = request.getParameter("startHour");
        String endHour = request.getParameter("endHour");

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = format.parse((!date.isEmpty() ? date : new SimpleDateFormat("yyyy-MM-dd").format(new Date())) + " " + (!startHour.isEmpty() ? startHour : "00:00"));
            endDate = format.parse((!date.isEmpty() ? date : new SimpleDateFormat("yyyy-MM-dd").format(new Date())) + " " + (!endHour.isEmpty() ? endHour : "23:59"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        CourseSessionService cs = new CourseSessionService();
        List<CourseSession> courseSessions = cs.getCoursesSessions(title, city, startDate, endDate);

        request.setAttribute("courseSessions", courseSessions);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/searchcourses.jsp");
        rd.forward(request, response);
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
