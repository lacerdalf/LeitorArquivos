<%@page import="br.gov.ibge.bme.edata.relatorio.adm.dom.Diretorio"%>
<%@page import="br.gov.ibge.bme.edata.relatorio.adm.dom.Item"%>
<%@page
	import="br.gov.ibge.bme.edata.relatorio.adm.inf.config.AtributosEdata"%>
<%@page import="javax.xml.ws.spi.http.HttpContext"%>
<%@page
	import="br.gov.ibge.bme.edata.relatorio.adm.app.control.RelatorioAdmControlador"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administração de relatorios Edata</title>

<%
	RelatorioAdmControlador controlador = (RelatorioAdmControlador) session.getAttribute(RelatorioAdmControlador.ATT_NAME);

	if (controlador == null) {
		controlador = new RelatorioAdmControlador();
		controlador.carregarRaiz(application);
		session.setAttribute(RelatorioAdmControlador.ATT_NAME, controlador);
	}

	String itemRequest = request.getParameter(AtributosEdata.ATT_ITEM);

	if (itemRequest != null && !itemRequest.isEmpty()) {
		controlador.carregarItem(Long.parseLong(itemRequest));
	}
	Item item = controlador.getDiretorioAtual();
%>

<script type="text/javascript" src="./js/main.js"></script>

</head>
<body>

	<%	if(item != null) { %>
	<h1>
		<%=item.getNome()%>
	</h1>


	<%
		if (item.isDiretorio()) {
			Diretorio dir = (Diretorio) item;
	%>
	<table>
		<%
			for (Item child : dir.getFilhos()) {
		%>
		<tr>
			<td><a href="javascript:goTo('<%=child.getId()%>')"> <%=child.getNome()%>
			</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	}
	%>

	<form method="get" action="/RelatoriosAdm">
		<input type="hidden" id="att1" value="<%=AtributosEdata.ATT_ITEM%>" />
		<input type="hidden" id="<%=AtributosEdata.ATT_ITEM%>"
			name="<%=AtributosEdata.ATT_ITEM%>" value="<%=item%>" />
	</form>
</body>
</html>