<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="Neon Admin Panel" />
	<meta name="author" content="" />
	
	<title>ESSTHS | Dashboard</title>
	

	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/js/jquery-ui/css/no-theme/jquery-ui-1.10.3.custom.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/font-icons/entypo/css/entypo.css">
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Noto+Sans:400,700,400italic">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/bootstrap.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/neon-core.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/neon-theme.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/neon-forms.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/custom.css">

	<script src="<%=request.getContextPath()%>/resources/assets/js/jquery-1.11.0.min.js"></script>

	<!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	
</head>


<body class="page-body  page-fade" data-url="http://neon.dev">


<div class="page-container"><!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->	
	
	<div class="sidebar-menu">
		
			
		<header class="logo-env">
			
			<!-- logo -->
			<div class="logo">
				<a href="index.html">
					<img src="<%=request.getContextPath()%>/resources/assets/images/ESSTHSES2.png" width="210" alt="" />
				</a>
			</div>
			
						<!-- logo collapse icon -->
						
	<!-- 		<div class="sidebar-collapse">
				<a href="#" class="sidebar-collapse-icon with-animation">add class "with-animation" if you want sidebar to have animation during expanding/collapsing transition
					<i class="entypo-menu"></i>
				</a>
			</div>
			 -->
									
			
			<!-- open/close menu icon (do not remove if you want to enable menu on mobile devices) -->
		<!-- 	<div class="sidebar-mobile-menu visible-xs">
				<a href="#" class="with-animation">add class "with-animation" to support animation
					<i class="entypo-menu"></i>
				</a>
			</div> -->
			
		</header>
				
		
		
				
		
				
				<%@ include file="Navigationbar .jsp" %>
				
	</div>	
	<div class="main-content">
		
<div class="row">
	
	<!-- Profile Info and Notifications -->
	<div class="col-md-6 col-sm-8 clearfix">
		
		<ul class="user-info pull-left pull-none-xsm">
		
						<!-- Profile Info -->
			<li class="profile-info dropdown"><!-- add class "pull-right" if you want to place this from right -->
				
			<%-- 	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					<img src="<%=request.getContextPath()%>/resources/assets/images/thumb-1@2x.png" alt="" class="img-circle" width="44" />
					Hamdi
				</a> --%>
				<a href="<c:url value="/j_spring_security_logout" />" >
					Déconnexion<i class="entypo-logout right"></i></a>
				
			
			</li>
		
		</ul>
				
		<ul class="user-info pull-left pull-right-xs pull-none-xsm">
			
			<!-- Raw Notifications -->
			<li class="notifications dropdown">
				
			<%-- 	<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					<i class="entypo-attention"></i>
					<span class="badge badge-info">${notification}</span>
				</a> --%>
				
				<ul class="dropdown-menu">
					<li class="top">
	<p class="small">
	
			Vous avez <strong>${notification}</strong> nouvelles notifications.
		
	</p>
</li>

<li>
	<ul class="dropdown-menu-list scroller">
		<!-- Notification -->
		<c:forEach items="${notifications}" var="notif">		<li class="unread notification-success">
			<a href="#">
				
				<i class="entypo-info pull-right"></i>		
				<span class="line">
					<strong> ${notif.nom } yarja3 lyouma</strong>
					<strong> ${notif.datedefin } </strong>
				</span>
				
				
			</a>
		</li>
		</c:forEach>
		
		<!-- Notification -->

	
	
		
	
	</ul>
</li>

			</ul>
				
			</li>
			
			<!-- Message Notifications -->
			
	
	




	
	
	<!-- Raw Links -->
	<div class="col-md-6 col-sm-4 clearfix hidden-xs">
		
		
	</div>
	
</div>

<hr />
	<% String ajouter_avec_succes=(String) request.getAttribute("ajouter_avec_succes");
if (ajouter_avec_succes!=null){
	out.print("<div class='col-md-6'><div class='alert alert-success'>"+ajouter_avec_succes+"</div></div>");
}
%>
<% String Erreur=(String) request.getAttribute("Erreur");
if (Erreur!=null){
	out.print("<div class='col-md-6'><div class='alert alert-danger'>"+Erreur+"</div></div>");
}
%>

<script type="text/javascript">
	function verif() {

		var	v=true;
			if((document.f.heure.value=="")   ){
				document.getElementById("erreurheure").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'>Heure obligatoire </font> </div></div>";
		
				window.location.href="#erreurheure";
				v= false;
				
			}
		
			if(document.f.date.value==""){
			document.getElementById("erreurdate").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'> Date obligatoire</font> </div></div>";
			window.location.href="#erreurdate";
			v= false;
		}
			
			return v;
				
			
	}
	</script> 

<div class="row">
	</div>
			<center> <h2>	Ajouter heure retard </h2></center>
	<% String erreur=(String) request.getAttribute("erreur");
if (erreur!=null){
	out.print("<div class='col-md-6'><div class='alert alert-danger'>"+erreur+"</div></div>");
}
%>
	
	
	
		 <form  action="addheureabs" method="post" enctype="multipart/form-data"  name="f" onsubmit=" return verif();">

			 <table>
<col width="300px"/>
				<col width="90px"/>
				<col width="300px"/>

<tr>
<td><label class="control-label">Id</label>
			
				<input type="text" class="form-control" name="idfon" data-validate="required,creditcard"  value="${fonctionnaire.id }" readonly="readonly" /></td>
</tr>

<tr><td><label class="control-label">Identificateur</label>
				
				<input type="text" class="form-control" name="identificateur" data-validate="required,creditcard" value="${fonctionnaire.identificateur }" readonly="readonly" /></td>
<td></td>
<td><label class="control-label">Nom</label>
				
				<input type="text" class="form-control" name="nom" data-validate="required,creditcard"  value="${fonctionnaire.nom }" readonly="readonly" /></td>
</tr>

<tr>
<td><label class="control-label">Prenom </label>
				
				<input type="text" class="form-control" name="prenom" data-validate="required,creditcard" value="${fonctionnaire.prenom }" readonly="readonly" /></td>
<td></td>
<td><label class="control-label">Type </label>
				
				<input type="text" class="form-control" name="type3" data-validate="required,creditcard"  value="${fonctionnaire.type }" readonly="readonly"/></td>
</tr>
<tr>

<td><label class="control-label">Grade</label>
				
				<input type="text" class="form-control" name="grade" data-validate="required,creditcard" value="${fonctionnaire.grade }" readonly="readonly" /></td>
<td></td>

</tr>
<tr>
<td><label class="control-label">Date *</label>
				<p id="erreurdate"></p>
				<input type="date" class="form-control" name="date" data-validate="required,creditcard"  /></td>
<td></td>
<td><label class="control-label">Heure *</label>
<p id="erreurheure"> </p>
<input type="time" class="form-control" name="heure" data-validate="required,creditcard"  />
</td>
</tr>


</table>	
		<%-- 		
				<div class="form-group">
				<label class="control-label">Id</label>
			
				<input type="text" class="form-control" name="idfon" data-validate="required,creditcard"  value="${fonctionnaire.id }" readonly="readonly" />
			</div>
				
						<div class="form-group">
				<label class="control-label">Identificateur</label>
			
				<input type="text" class="form-control" name="identificateur" data-validate="required,creditcard"  value="${fonctionnaire.identificateur }" readonly="readonly" />
			</div>
				
					
				<!-- <input type="text" class="form-control" name="type" data-validate="required,creditcard"  /> -->
	
			
				
			
			
			
				<div class="form-group">
			<label class="control-label">Nom</label>
				
				<input type="text" class="form-control" name="nom" data-validate="required,creditcard"  value="${fonctionnaire.nom }" readonly="readonly" />
			</div>
			<div class="form-group">
			<label class="control-label">Prenom </label>
				
				<input type="text" class="form-control" name="prenom" data-validate="required,creditcard" value="${fonctionnaire.prenom }" readonly="readonly" />
			</div>
				<div class="form-group">
			<label class="control-label">Type </label>
				
				<input type="text" class="form-control" name="type" data-validate="required,creditcard"  value="${fonctionnaire.type }" readonly="readonly"/>
			</div>
		
			<!-- 	<input type="text" class="form-control" name="grade" data-validate="required,creditcard"  /> -->
			
			<div class="form-group">
			<label class="control-label">Grade</label>
				
				<input type="text" class="form-control" name="grade" data-validate="required,creditcard" value="${fonctionnaire.grade }" readonly="readonly" />
			</div>

		<div class="form-group"><tabel><tr><td><label class="control-label">Heure *</label></td>
			<td><p id="erreurheure"> </p></td></tr></tabel>
		
				
				<input type="time" class="form-control" name="heure" data-validate="required,creditcard"  />
				
			</div>

			<div class="form-group">
				<label class="control-label">Date *</label>
				<p id="erreurdate"></p>
				<input type="date" class="form-control" name="date" data-validate="required,creditcard"  />
			</div>
			 --%>
		<!--	<div class="form-group">
				<label class="control-label">Adresse *</label>
				<p id="erreuradresse"></p>
				
				<input type="date" class="form-control" name="adresse" data-validate="required,creditcard"  />
			</div> -->
			
			<center>
			<div class="form-group">	
			<button type="submit" class="btn btn-success" >Ajouter</button>
		
			<button type="reset" class="btn">Effacer</button>
			</div>
			</center>	
			</form>
				
				
				
	
		<div class="col-sm-8">
	
		
			<%-- <div class="panel-heading">
				<div class="panel-title">Liste des Fonctionnaires</div>
				
				
			</div>
					
			<table class="table table-bordered table-responsive">
			
				<thead>
					<tr>
				
						<th>Identificateur</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Date</th>
						<th>heure</th>
						
						
						
						
						


					</tr>
				</thead>
							<c:forEach items="${heureretardfon}" var="heureabs"> 	
				<tbody>
				

					<tr>
	
					<td>${heureabs.identificateur}</td>
					<td>${heureabs.nom}</td>
					<td>${heureabs.prenom}</td>
					<td>${heureabs.date}</td>
					<td>${heureabs.heure}</td>
					
					
					
			

				</tbody>
				</c:forEach>
			</table>
		</div>
		 --%>

		
	</div>
	
</div>




<br />


<!-- Footer -->
<footer class="main">
	
		
	&copy; 2017 <strong>ESSTHS</strong> Créer par Hamdi Boukadida
	
</footer>	</div>
	
	


	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/js/jvectormap/jquery-jvectormap-1.2.2.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/js/rickshaw/rickshaw.min.css">

	<!-- Bottom Scripts -->
	<script src="<%=request.getContextPath()%>/resources/assets/js/gsap/main-gsap.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/bootstrap.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/joinable.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/resizeable.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/neon-api.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/jvectormap/jquery-jvectormap-europe-merc-en.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/jquery.sparkline.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/rickshaw/vendor/d3.v3.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/rickshaw/rickshaw.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/raphael-min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/morris.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/toastr.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/neon-chat.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/neon-custom.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/neon-demo.js"></script>

</body>
</html>