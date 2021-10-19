<%@page import="java.util.List"%>
<%@page import="model.Colaborador"%>
<%@page import="DAO.ColaboradorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONTROLE DE TAREFAS - CAPGEMINI</title>
        <link rel="stylesheet" href="Styles/padraoTelaGrid.css">
        <!-- bootstrap -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet"/>        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <!-- Fontawesome' -->
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    </head>
    <body>
        <%
       		ColaboradorDao cDAO = new ColaboradorDao();
        	List<Colaborador> listaColaboradores = cDAO.findAll();
        %>
        <table id="consulta">
            <!-- cabecalho da tabela -->
            <thead>
            	<th> ID Colaborador </th>
                <th> Colaborador </th>
                <th> Alterar </th>
                <th> Excluir </th>
            </thead>
            <!-- corpo da tabela -->
            <tbody>
                <% for (int i = 0; i < listaColaboradores.size(); i++) { %>
                <tr>
                    <td><% out.write("" + listaColaboradores.get(i).getIdColaborador()); %></td>
                    <td><% out.write("" + listaColaboradores.get(i).getNomeColaborador()); %></td>
                    <td> <i class="far fa-edit"     ;style="color:lightpink"></i></td>
                    <td> <i class="far fa-trash-alt";style="color:lightpink"></i></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
