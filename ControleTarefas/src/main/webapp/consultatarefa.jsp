<%@page import="java.util.List"%>
<%@page import="model.Tarefa"%>
<%@page import="DAO.TarefaDao"%>
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
            TarefaDao tar = new TarefaDao();
            List<Tarefa> listaTarefas = tar.findAll();

        %>
        <table id="consulta">
            <!-- cabecalho da tabela -->
            <thead>
            	<th> ID Tarefa </th>
                <th> Tarefa </th>
                <th> Data de início </th>
                <th> Data de término </th>
                <th> Status </th>
                <th> Prioridade </th>
                <th> Alterar </th>
                <th> Excluir </th>
            </thead>
            <!-- corpo da tabela -->
            <tbody>
                <% for (int i = 0; i < listaTarefas.size(); i++) { %>
                <tr>
                    <td><% out.write("" + listaTarefas.get(i).getIdTarefa()); %></td>
                    <td><% out.write("" + listaTarefas.get(i).getDescrTarefa()); %></td>
                    <td><% out.write("" + listaTarefas.get(i).getDataHoraInicio()); %></td>
                    <td><% out.write("" + listaTarefas.get(i).getDataHoraFim()); %></td>
                    <td><% out.write("" + listaTarefas.get(i).getStatusTarefa()); %></td>
                    <td><% out.write("" + listaTarefas.get(i).getPrioridadeTarefa()); %></td>
                    <td> <i class="far fa-edit"     ;style="color:lightpink"></i></td>
                    <td> <i class="far fa-trash-alt";style="color:lightpink"></i></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
