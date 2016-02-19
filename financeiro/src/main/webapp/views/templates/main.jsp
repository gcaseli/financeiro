<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title><tiles:getAsString name="titulo" /></title>
</head>
<body>
	<div class="container">		
		<div class="row">
			<div class="col-xs-12" align="left">
				<tiles:insertAttribute name="cabecalho" />
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="col-xs-9">
				<tiles:insertAttribute name="conteudo" />
			</div>
		</div>
		<div class="row" align="center">
			<div class="col-xs-12">
				<tiles:insertAttribute name="rodape" />
			</div>
		</div>
	</div>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>