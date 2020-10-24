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
						
		<!-- 	<div class="sidebar-collapse">
				<a href="#" class="sidebar-collapse-icon with-animation">add class "with-animation" if you want sidebar to have animation during expanding/collapsing transition
					<i class="entypo-menu"></i>
				</a>
			</div>
			 -->
									
			
			<!-- open/close menu icon (do not remove if you want to enable menu on mobile devices) -->
			<div class="sidebar-mobile-menu visible-xs">
				<a href="#" class="with-animation"><!-- add class "with-animation" to support animation -->
					<i class="entypo-menu"></i>
				</a>
			</div>
			
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
				
		<%-- 		<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					<img src="<%=request.getContextPath()%>/resources/assets/images/thumb-1@2x.png" alt="" class="img-circle" width="44" />
					Hamdi
				</a> --%>
				
				<a href="<c:url value="/j_spring_security_logout" />" >
				Déconnexion <i class="entypo-logout right"></i></a>
			</li>
		
		</ul>
				
		<ul class="user-info pull-left pull-right-xs pull-none-xsm">
			
			<!-- Raw Notifications -->
			<li class="notifications dropdown">
				
				<!-- <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
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
			
	
	<script type="text/javascript">
	function verif() {
		var	v=true;
	 	if(document.f.date1.value==""){
			document.getElementById("erreurdate1").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'> date obligatoire</font> </div></div>";
			
			window.location.href="#erreurdate1";
			v= false;
		} 
		if(document.f.date2.value==""){
			document.getElementById("erreurdate2").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'> date obligatoire</font> </div></div>";
			
			window.location.href="#erreurdate2";
			v= false;
		} 
			return v;
				
			
	}
	</script>




	
	
	<!-- Raw Links -->
	<div class="col-md-6 col-sm-4 clearfix hidden-xs">
		
		
	</div>
	
</div>

<hr />



<div class="row">
	
	
	
	<center><h2>Voir détails</h2></center>
	
	
	<div class="col-sm-8">
		
		<div class="panel panel-primary">
		
					<br>
				<br>
				
				<div class="row">
	<div class="col-md-9 col-sm-7">
		<h1>Détails</h1>
	</div>
	

</div>



<form action="détailjoursabsouv" method="get" name="f" onsubmit=" return verif();">
		<table>
				<col width="300px"/>
				<col width="90px"/>
				<col width="300px"/>
			<tr><td><label class="control-label">ID </label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="idouv" data-validate="required,creditcard" readonly="readonly"  value="${ouvriers.id}" /></td></tr>
		<tr><td>
		<label class="control-label">Nom </label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control"  data-validate="required,creditcard" readonly="readonly"   value="${ouvriers.nom}" />
		</td><td></td>
		
		
		<td>
		
		<label class="control-label">Identificateur </label>
				<p id="erreuridentificateur"></p>
				
			
			<input type="text" class="form-control"  data-validate="required,creditcard" readonly="readonly"   value="${ouvriers.identificateur}" />
		</td>
		
		</tr>
		<tr>
		<td>	<label class="control-label">De *</label>
				<p id="erreurdate1"></p>
				<input type="date" class="form-control" name="date1" data-validate="required,creditcard"  />	</td><td></td>
		<td>	<label class="control-label">A *</label>
				<p id="erreurdate2"></p>
				<input type="date" class="form-control" name="date2" data-validate="required,creditcard"  />	</td>
		
		
		</tr>
		</table>
	<%-- 	<div class="form-group">
				
				<br>  
			</div> 
			
			<div class="form-group">
				
				<br>  
			</div>
			
			<div class="form-group">
				
				<br>  
				<div class="form-group">
			
			</div><br>

				
				
				<div class="form-group">
			
			</div><br> --%>

			
<%-- <tabel></tr><td>
<input type="text" value="${Ouvriers.id}" name="idouv"  ></td></tr>
<input type="text" value="${Ouvriers.nom}"disabled>
<input type="text" value="${Ouvriers.tel}"disabled>
<input type="text" value="${Ouvriers.adresse}"disabled>
<input type="text" value="${Ouvriers.type}"disabled>
<input type="text" value="${Ouvriers.grade}"disabled>
<input type="date" name="date1" >
<input type="date" name="date2" >
</tabel>  --%>
<!-- <button type="submit" > calcule somme </button> -->
<center><button type="submit" class="btn btn-blue">Consulter en détails </button></center>


		<table class="table table-bordered table-responsive">
				<thead>
					<tr>
						<th>Date</th>
						<th>Heure</th>
					


					</tr>
				</thead>
				
				<tbody>
				
<c:forEach items="${détail}" var="d">
					<tr>
					
					<td>${d.datededebut	}</td>
					<td>${d.datederetour}</td>
					<td>${d.nbrj}</td>
					<td>${d.type}</td>
					
					
					
				
					
			

				</tbody>
				</c:forEach>
			</table>

<%-- </form>
<form action="addheure" method="get">
<div class="form-group">
<input type="text" class="form-control" value="${fonctionnaire.id}" name="idfon" readonly="readonly" >
<input type="text" class="form-control" value="${fonctionnaire.nom}"readonly="readonly">
<input type="text"class="form-control" value="${fonctionnaire.tel}"readonly="readonly">
<input type="text"class="form-control" value="${fonctionnaire.adresse}"readonly="readonly">
<input type="text"class="form-control" value="${fonctionnaire.type}"readonly="readonly">
<input type="text"class="form-control" value="${fonctionnaire.grade}"readonly="readonly">
</div>

<!-- <button type="submit" > calcule somme </button> -->
<button onclick="setTimeout(myFunction, 3000);">calcule somme</button>

<script>
function myFunction() {
    alert("${heuresupps}");
}
</script>

</form>
 --%>


<div class="row">
	
	
	
	
	
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