package com.tabungan.dao;

import com.tabungan.model.NasabahModel;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: FERREL JOHN FERNANDO
 * Date: 05/06/2018.
 * Time: 15:43.
 * To change this template use File | Settings | File Templates.
 */
public class NasabahDAO {
    private String jdbcURL;
    private String jdbcUserName;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public NasabahDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUserName = jdbcUserName;
        this.jdbcPassword = jdbcPassword;
    }

    public void connect() throws Exception {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new Exception(e);
            }
        }
        jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
    }

    public void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertNasabah(NasabahModel nasabah) throws Exception {
        SimpleDateFormat sormat = new SimpleDateFormat("yyyyMMdd");
        StringBuilder sb = new StringBuilder()
                .append(String.valueOf(sormat.format(new Date())))
                .append(String.valueOf(sormat.format(nasabah.getTglLahir())));
        nasabah.setNoTabungan(sb.toString());
        String sql = "INSERT INTO m_nasabah (no_tabungan, nm_nasabah, tgl_lahir, tmpt_lahir, alamat, email, no_hp, tipe_tabungan)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        connect();
        System.out.printf("noTabungan = "+nasabah.getNoTabungan());

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, nasabah.getNoTabungan());
        statement.setString(2, nasabah.getNamaNasabah());
        statement.setDate(3, java.sql.Date.valueOf(String.valueOf(nasabah.getTglLahir())));
        statement.setString(4, nasabah.getTmptLahir());
        statement.setString(5, nasabah.getAlamat());
        statement.setString(6, nasabah.getEmail());
        statement.setString(7, nasabah.getNoHp());
        statement.setString(8, nasabah.getTipeTabungan());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();

        return rowInserted;
    }

    public List<NasabahModel> listAllNasabah() throws Exception {
        List<NasabahModel> listNasabah = new ArrayList<NasabahModel>();

        String sql = "SELECT * FROM m_nasabah";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String noTabungan = resultSet.getString("no_tabungan");
            String namaNasabah = resultSet.getString("nm_nasabah");
            Date tglLahir = resultSet.getDate("tgl_lahir");
            String tmptLahir = resultSet.getString("tmpt_lahir");
            String alamat = resultSet.getString("alamat");
            String email = resultSet.getString("email");
            String noHp = resultSet.getString("no_hp");
            String tipeTabungan = resultSet.getString("tipe_tabungan");

            NasabahModel nasabah = new NasabahModel(id, noTabungan, namaNasabah, tglLahir, tmptLahir,
                    alamat, email, noHp, tipeTabungan);
            listNasabah.add(nasabah);
        }

        resultSet.close();
        statement.close();
        disconnect();

        return listNasabah;
    }

    public boolean deleteNasabah(NasabahModel nasabah) throws Exception {
        String sql = "DELETE FROM m_nasabah WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1,nasabah.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();

        return rowDeleted;
    }

    public boolean updateNasabah(NasabahModel nasabah) throws Exception {
        String sql = "UPDATE m_nasabah SET nm_nasabah = ?, tgl_lahir = ?," +
                " tmpt_lahir = ?, alamat = ?, email = ?, no_hp = ?, tipe_tabungan = ?";
        sql += "WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, nasabah.getNamaNasabah());
        statement.setDate(2, java.sql.Date.valueOf(String.valueOf(nasabah.getTglLahir())));
        statement.setString(3, nasabah.getTmptLahir());
        statement.setString(4, nasabah.getAlamat());
        statement.setString(5, nasabah.getEmail());
        statement.setString(6, nasabah.getNoHp());
        statement.setString(7, nasabah.getTipeTabungan());
        statement.setString(8, nasabah.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();

        return rowUpdated;
    }

    public NasabahModel getNasabah(String id) throws Exception {
        NasabahModel nasabah = null;
        String sql = "SELECT * FROM m_nasabah WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String noTabungan = resultSet.getString("no_tabungan");
            String namaNasabah = resultSet.getString("nm_nasabah");
            Date tglLahir = resultSet.getDate("tgl_lahir");
            String tmptLahir = resultSet.getString("tmpt_lahir");
            String alamat = resultSet.getString("alamat");
            String email = resultSet.getString("email");
            String noHp = resultSet.getString("no_hp");
            String tipeTabungan = resultSet.getString("tipe_tabungan");

            nasabah = new NasabahModel(id, noTabungan, namaNasabah, tglLahir, tmptLahir, alamat, email, noHp, tipeTabungan);
        }

        resultSet.close();
        statement.close();

        return nasabah;
    }
}