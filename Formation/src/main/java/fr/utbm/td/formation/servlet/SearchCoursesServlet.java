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
import fr.utbm.td.formation.service.SearchCoursesService;
import java.io.IOException;
import java.sql.Time;
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
            if (!date.isEmpty()) {
                if (!startHour.isEmpty()) {
                    startDate = format.parse(date + " " + startHour);
                } else {
                    startDate = format.parse(date + " " + "00:00");
                }

                if (!endHour.isEmpty()) {
                    endDate = format.parse(date + " " + endHour);
                } else {
                    endDate = format.parse(date + " " + "23:59");
                }
            } else {
                if (!startHour.isEmpty()) {
                    startDate = format.parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " " + startHour);
                }
                if (!endHour.isEmpty()) {
                    endDate = format.parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " " + endHour);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SearchCoursesService scService = new SearchCoursesService();
        scService.save(title, city, date, startHour, endHour);

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
