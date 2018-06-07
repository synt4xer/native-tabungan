<%--
  Created by IntelliJ IDEA.
  User: Syntaxer
  Date: 06/06/2018
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nasabah List</title>

    <link rel="stylesheet" href="/webjars/bootstrap-material-design/4.1.1/css/bootstrap-material-design.min.css">
    <script src="/webjars/bootstrap-material-design/4.1.1/js/bootstrap-material-design.min.js"></script>
    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
    <div align="center">
        <h1>Modul Nasabah</h1>
        <h2>
            <a href="/nasabah/new">Buat Nasabah Baru</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/nasabah/list">List Nasabah</a>
        </h2>
    </div>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List Nasabah</h2></caption>
            <tr>
                <th>ID</th>
                <th>No Tabungan</th>
                <th>Nama Nasabah</th>
                <th>Tanggal Lahir</th>
                <th>Tempat Lahir</th>
                <th>Alamat</th>
                <th>Email</th>
                <th>No. Hp</th>
                <th>Tipe Tabungan</th>
                <th>Aksi</th>
            </tr>
            <c:forEach var="nasabah" items="${listNasabah}">
                <tr>
                    <td><c:out value="${nasabah.id}"/></td>
                    <td><c:out value="${nasabah.noTabungan}"/></td>
                    <td><c:out value="${nasabah.namaNasabah}"/></td>
                    <td><c:out value="${nasabah.tglLahir}"/></td>
                    <td><c:out value="${nasabah.tmptLahir}"/></td>
                    <td><c:out value="${nasabah.alamat}"/></td>
                    <td><c:out value="${nasabah.email}"/></td>
                    <td><c:out value="${nasabah.noHp}"/></td>
                    <td><c:out value="${nasabah.tipeTabungan}"/></td>
                    <td>
                        <a href="/nasabah/edit?id=<c:out value='${nasabah.id}'/>">Edit</a>
                        <a href="/nasabah/delete?id=<c:out value='${nasabah.id}'/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
