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
				<img src="<%=request.getContextPath()%>/resources/assets/images/ESSTHSES2.png" width="210" alt="" />
			</div>
			
						<!-- logo collapse icon -->
						
	<!-- 		<div class="sidebar-collapse">
				<a href="#" class="sidebar-collapse-icon with-animation">add class "with-animation" if you want sidebar to have animation during expanding/collapsing transition
					<i class="entypo-menu"></i>
				</a>
			</div> -->
			
									
			
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
				
			<a href="<c:url value="/j_spring_security_logout" />" >
					Déconnexion <i class="entypo-logout right"></i></a>
				
			
				
			
			</li>
		
		</ul>
				
		<ul class="user-info pull-left pull-right-xs pull-none-xsm">
			
			<!-- Raw Notifications -->
			<li class="notifications dropdown">
				
		<!-- 		<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					<i class="entypo-attention"></i>
					<span class="badge badge-info">0</span>
				</a> -->
				
				<ul class="dropdown-menu">
					<li class="top">
	<p class="small">
		<a href="#" class="pull-right">Mark all Read</a>
		You have <strong>3</strong> new notifications.
	</p>
</li>

<li>
	<ul class="dropdown-menu-list scroller">
		<li class="unread notification-success">
			<a href="#">
				<i class="entypo-user-add pull-right"></i>
				
				<span class="line">
					<strong>New user registered</strong>
				</span>
				
				<span class="line small">
					30 seconds ago
				</span>
			</a>
		</li>
		

	
	
		
	
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






<div class="row">
	
	
	<form  action="rechrech" method="post" role="form" class="search-form-full" >
	<div class="col-sm-8">
		
		<div class="input-group">
					<input type="text" class="form-control input-lg" name="nom" placeholder="Rechercher Par Nom ...">
					
					<div class="input-group-btn">
						<button type="submit" class="btn btn-lg btn-primary btn-icon">
							Rechercher 
							
						</button>
					</div>
				</div>
			
		</form>
			<div class="panel-heading">
				<div class="panel-title">Liste des autorisations</div>
				
				
			</div>
				
			<table class="table table-bordered table-responsive">
				<thead>
					<tr>
					
					
					
						<th>Nom</th>
						<th>Date</th>
						<th>De</th>
						<th>A</th>
						<th>Cause</th>
						
						
						


					</tr>
				</thead>
				
				<tbody>
				
<c:forEach items="${listeautorisation}" var="ens">
					<tr>
					
					
					
					<td>${ens.nom}</td>
					<td>${ens.date}</td>
					<td>${ens.de}</td>
					<td>${ens.a}</td>
					<td>${ens.cause}</td>	
					
					</tr>
					
			

				</tbody>
				</c:forEach>
			</table>
		</div>
		
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