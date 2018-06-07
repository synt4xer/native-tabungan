<%--
  Created by IntelliJ IDEA.
  User: Syntaxer
  Date: 06/06/2018
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nasabah Form</title>

    <link rel="stylesheet" href="/webjars/bootstrap-material-design/4.1.1/css/bootstrap-material-design.min.css">
    <script src="/webjars/bootstrap-material-design/4.1.1/js/bootstrap-material-design.min.js"></script>
    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
    <div align="center">
        <h1>Nasabah Form</h1>
        <h2>
            <a href="/nasabah/new">Buat Nasabah Baru</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/nasabah/list">List Nasabah</a>
        </h2>
    </div>
    <div align="center">
        <c:if test="${nasabah != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${nasabah == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${nasabah != null}">
                        Edit Nasabah
                    </c:if>
                    <c:if test="${nasabah == null}">
                        Buat Nasabah Baru
                    </c:if>
                </h2>
            </caption>
            <c:if test="${nasabah != null}">
                <input type="hidden" name="id" value="<c:out value='${nasabah.id}' />"/>
            </c:if>
            <tr>
                <th>Nama Nasabah: </th>
                <td>
                    <input type="text" name="nm_nasabah" id="nm_nasabah" size="32"
                           value="<c:out value='${nasabah.namaNasabah}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Tanggal Lahir: </th>
                <td>
                    <input type="date" name="tgl_lahir" id="tgl_lahir" size="32"
                           value="<c:out value='${nasabah.tglLahir}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Tempat Lahir: </th>
                <td>
                    <input type="text" name="tmpt_lahir" id="tmpt_lahir" size="32"
                           value="<c:out value='${nasabah.tmptLahir}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Alamat: </th>
                <td>
                    <textarea name="alamat" id="alamat" cols="2" rows="2">
                        <c:out value="${nasabah.alamat}" />
                    </textarea>
                </td>
            </tr>
            <tr>
                <th>E-mail: </th>
                <td>
                    <input type="email" name="email" id="email"
                           value="<c:out value='${nasabah.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>No. HP: </th>
                <td>
                    <input type="number" name="no_hp" id="no_hp" size="14"
                           value="<c:out value='${nasabah.noHp}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Tipe Tabungan: </th>
                <td>
                    <input type="number" name="tipe_tabungan" id="tipe_tabungan" size="15"
                           value="<c:out value='${nasabah.tipeTabungan}' />"
                    />
                    <%--<select id="tipe_tabungan" name="tipe_tabungan">
                        <c:forEach var="tabungan" items="${tabunganList}">
                            <option value="<c:out value='${tabungan.id}' />"
                                    <c:if test="${param.selectValue ==tabungan}"> selected </c:if> >
                                <c:out value="${tabungan.nmTabungan}"/>
                            </option>
                        </c:forEach>
                    </select>--%>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="save">
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>
