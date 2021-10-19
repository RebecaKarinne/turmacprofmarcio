<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Colaborador"%>
<%@page import="DAO.ColaboradorDao"%>
<%@page import="DAO.GenericDAO"%>


<%
    String vNomecolaborador = request.getParameter("nomecolaborador");

    Colaborador col = new Colaborador();
    col.setNomeColaborador(vNomecolaborador);
    
    ColaboradorDao cDAO = new ColaboradorDao();
    
    if (cDAO.include(col)) {
        response.sendRedirect("cadastracolaborador.jsp?pmensagem=Colaborador cadastrado com sucesso");
    } else {
        response.sendRedirect("cadastracolaborador.jsp?pmensagem=Problemas ao cadastrar Colaborador");
    }
%>