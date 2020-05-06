<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

    <title>Produtos - Listagem</title>
    
    <c:set value="${pageContext.request.contextPath}" var="contextPath"/>
    
    <link href="/bootstrap.css" rel="stylesheet">
    <link href="/small-business.css" rel="stylesheet">

</head>

<body>
    
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${contextPath/produto}">Produtos</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
				
				<h1>Produtos</h1>
				
				<p class="toolbar">
				
					<a class="create btn btn-default" href="XXXXXXXX">Novo Produto</a>
	
					<span class="alert"></span>
				</p>
				
				<table class="table table-striped" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th data-field="name">Nome</th>
							<th data-field="forks_count">Preço</th>
							<th class="actions" width="220">Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${produtos}" var="produto">
					
							<tr>
								<td>${ produto.nome }</td>
								<td>${ produto.preco }</td>
								
								<td class="actions">
								
									<form action="XXXXXX" method="get">
									
										<a class="btn btn-success btn-xs" href="XXXXXXXX">Detalhes</a>
										<a class="btn btn-warning btn-xs" href="XXXXXXXX">Editar</a>
										<input type="submit" value="Excluir" class="btn btn-danger btn-xs">
									</form>
									
								</td>
							</tr>
						</c:forEach>
                    </tbody>
				</table>
            </div>
        </div>
		<hr>
    </div>

    <!-- jQuery -->
    <script src="/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/bootstrap.min.js"></script>

</body>
</html>