package com.tabungan.servlet;

import com.tabungan.dao.NasabahDAO;
import com.tabungan.model.NasabahModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: FERREL JOHN FERNANDO
 * Date: 05/06/2018.
 * Time: 17:19.
 * To change this template use File | Settings | File Templates.
 */
public class NasabahServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NasabahDAO nasabahDAO;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        nasabahDAO = new NasabahDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getServletPath();

        try {
            switch (action) {
                case "/nasabah/new":
                    showNewForm(req, resp);
                    break;
                case "/nasabah/insert":
                    insertNasabah(req, resp);
                    break;
                case "/nasabah/delete":
                    deleteNasabah(req, resp);
                    break;
                case "/nasabah/edit":
                    showEditForm(req, resp);
                    break;
                case "/nasabah/update":
                    updateNasabah(req, resp);
                    break;
                default:
                    listNasabah(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listNasabah(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<NasabahModel> nasabahList = nasabahDAO.listAllNasabah();
        request.setAttribute("listNasabah", nasabahList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/nasabah/nasabahList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/nasabah/nasabahForm.jsp");
        dispatcher.forward(request, response);
    }

    private void  showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        NasabahModel existNasabah = nasabahDAO.getNasabah(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/nasabah/nasabahForm.jsp");
        request.setAttribute("nasabah", existNasabah);
        dispatcher.forward(request, response);
    }

    private void insertNasabah(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String noTabungan = request.getParameter("no_tabungan");
        String namaNasabah = request.getParameter("nm_nasabah");
        String bornDay = request.getParameter("tgl_lahir");
        String tmptLahir = request.getParameter("tmpt_lahir");
        String alamat = request.getParameter("alamat");
        String email = request.getParameter("email");
        String noHp = request.getParameter("no_hp");
        String tipeTabungan = request.getParameter("tipe_tabungan");
        Date tglLahir = Date.valueOf(bornDay);

        NasabahModel nasabah = new NasabahModel(noTabungan, namaNasabah, tglLahir, tmptLahir,
                alamat, email, noHp, tipeTabungan);
        nasabahDAO.insertNasabah(nasabah);
        response.sendRedirect("list");
    }

    private void deleteNasabah(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");

        NasabahModel nasabah = new NasabahModel(id);
        nasabahDAO.deleteNasabah(nasabah);
        response.sendRedirect("list");
    }

    private void updateNasabah(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        String noTabungan = request.getParameter("no_tabungan");
        String namaNasabah = request.getParameter("nm_nasabah");
        String bornDay = request.getParameter("tgl_lahir");
        String tmptLahir = request.getParameter("tmpt_lahir");
        String alamat = request.getParameter("alamat");
        String email = request.getParameter("email");
        String noHp = request.getParameter("no_hp");
        String tipeTabungan = request.getParameter("tipe_tabungan");
        Date tglLahir = Date.valueOf(bornDay);

        NasabahModel nasabah = new NasabahModel(id, noTabungan, namaNasabah, tglLahir, tmptLahir,
                alamat, email, noHp, tipeTabungan);
        nasabahDAO.updateNasabah(nasabah);
        response.sendRedirect("list");
    }
}
