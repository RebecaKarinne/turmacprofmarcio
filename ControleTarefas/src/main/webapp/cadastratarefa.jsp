<%@page import="java.util.List"%>
<%@page import="model.Colaborador"  %>
<%@page import="DAO.ColaboradorDao"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONTROLE DE TAREFAS - CAPGEMINI</title>
        <link   rel ="stylesheet" href="Styles/padraoTelaCadastro.css">
        <script src ="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src ="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    
    <body> 
        <div class="container">
            <form id="matchtech" action="receberdadostarefa.jsp" method="POST">
                <h3>Cadastro de Tarefas</h3>
                <p></p>
                
                <%
                	ColaboradorDao cDAO = new ColaboradorDao();
                	List<Colaborador> listaColaboradores = cDAO.findAll();
                %>
                
                <label class="mensagem" id="msg">
                    <%
                        if(request.getParameter("pmensagem") != null)
                            out.write(request.getParameter("pmensagem"));  
                    %>
                </label>
                
                <fieldset>
              		<div class "idcolaborador">
              			<label>Colaborador</label>
              			<select name="idcolaborador">
              				<% for(Colaborador c: listaColaboradores) { %>
              				<option value ="<%out.write("" + c.getIdColaborador());%>">
              								<%out.write("" + c.getNomeColaborador()); %>
              				</option>
              				<%}%>
              				
              			</select>
              		</div>
                </fieldset>
                
                <fieldset> 
                    <label>Descrição</label>
                    <div class="descrTarefa">
                        <input id="descrTarefa" name="descrTarefa" type="text" maxlength="50" required size=50 style="text-transform: uppercase">
                    </div>
                    <label>Data de inicio</label>
                    <div class="dataHoraInicio">
                        <input id="dataHoraInicio" name="dataHoraInicio" type="text" maxlength="15" required size=15 style="text-transform: uppercase">
                    </div>
                    <label>Data de fim (caso nao tenha, digite 0)</label>
                    <div class="dataHoraFim">
                        <input id="dataHoraFim" name="dataHoraFim" type="text" maxlength="15" required size=15 style="text-transform: uppercase">
                    </div>
                    <label>Status</label>
                    <div class="statusTarefa">
                        <input id="statusTarefa" name="statusTarefa" type="text" maxlength="15" required size=15 style="text-transform: uppercase">
                    </div>
                    <label>Prioridade</label>
                    <div class="prioridadeTarefa">
                        <input id="prioridadeTarefa" name="prioridadeTarefa" type="text" maxlength="15" required size=15 style="text-transform: uppercase">
                    </div>
                </fieldset>
                <br>
                
                <div>
                    <div class="form-group col-md-2 h-8">
                        <input type="submit" value="Cadastrar" class="btn btn-success "/>
                    </div>
                    <div class="form-group col-md-2 h-8">                                 
                        <input type="reset"  value="Cancelar" class="btn btn-danger"/>                        
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
