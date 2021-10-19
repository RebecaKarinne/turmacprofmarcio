<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Tarefa"%>
<%@page import="DAO.TarefaDao"%>
<%@page import="DAO.GenericDAO"%>


<%
    String vDescrTarefa = request.getParameter("descrTarefa");
	String vDataHoraInicio = request.getParameter("dataHoraInicio");
	String vDataHoraFim = request.getParameter("dataHoraFim");
	String vStatusTarefa = request.getParameter("statusTarefa");
	String vPrioridadeTarefa = request.getParameter("prioridadeTarefa");

    Tarefa tar = new Tarefa();
    tar.setDescrTarefa(vDescrTarefa);
    tar.setDataHoraInicio(vDataHoraInicio);
    tar.setDataHoraFim(vDataHoraFim);
    tar.setStatusTarefa(vStatusTarefa);
    tar.setPrioridadeTarefa(vPrioridadeTarefa);
    
    TarefaDao tDAO = new TarefaDao();
    
    if (tDAO.include(tar)) {
        response.sendRedirect("cadastratarefa.jsp?pmensagem=Tarefa cadastrada com sucesso");
    } else {
        response.sendRedirect("cadastratarefa.jsp?pmensagem=Problemas ao cadastrar tarefa");
    }
%>