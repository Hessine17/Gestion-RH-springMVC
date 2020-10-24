<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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
			</div> -->
			
									
			
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
				
			
				<a href="<c:url value="/j_spring_security_logout" />" >
					Déconnexion<i class="entypo-logout right"></i></a>
				
			
			</li>
		
		</ul>
				
		<ul class="user-info pull-left pull-right-xs pull-none-xsm">
			
			<!-- Raw Notifications -->
			<li class="notifications dropdown">
				
				<%-- <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
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
				
				
				<span class="line">
					<strong> ${notif.nom } yarja3 ilyouma </strong>
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
			
			<!-- tuti Notifications -->
			
			
			<li class="notifications dropdown">
				
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
		<%-- 		<!-- 	<i class="entypo-list"></i> -->
					<span class="badge badge-warning"> ${titu} </span> --%>
				</a>
				
				<ul class="dropdown-menu">
					<li class="top">
	<p>You have ${titu} pending tasks</p>
</li>
			
	<ul class="dropdown-menu-list scroller">
	<li class="notification-warning">
			<a href="#">
				<i class="entypo-rss pull-right"></i>
				<c:forEach items="${titulis}" var="ens">
				<span class="line">
					${ens.nom} New comments waiting approval
				</span>
				</c:forEach>
				<span class="line small">
					last week
				</span>
			</a>
		</li>
	
</ul>



	
	
	<!-- Raw Links -->
	<div class="col-md-6 col-sm-4 clearfix hidden-xs">
		
		
	</div>
	
</div>




<div class="row">
<hr/>
	
<center>	<h2>Gérer les enseignants</h2></center>
	
	
		<script type="text/javascript">
	function verif() {
	
		var	v=true;
			if((document.f.identificateur.value=="")   ){
				document.getElementById("erreuridentificateur").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'>identificateur obligatoire </font> </div></div>";
				
				
				
				window.location.href="#erreuridentificateur";
				v= false;
				
			}
		
			 if(document.f.nom.value==""){
			document.getElementById("erreurnom").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'> nom obligatoire</font> </div></div>";
			window.location.href="#erreurnom";
			v= false;
		}
			 if(document.f.type.value==""){
				document.getElementById("erreurtype").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'> type obligatoire</font> </div></div>";
				window.location.href="#erreurtype";
				v= false;
			}
			 if(document.f.grade.value==""){
				document.getElementById("erreurgrade").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'> grade obligatoire</font> </div></div>";
				window.location.href="#erreurgrade";
				v= false;
			}
			 
			 if(document.f.datereq.value==""){
					document.getElementById("erreurdate").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'> date obligatoire</font> </div></div>";
					window.location.href="#erreurdate";
					v= false;
				}
			return v;
				
			
	}
	</script>
				
				
				
	 <form modelAttribute="enseignant" action="adden" method="post" enctype="multipart/form-data" name="f" onsubmit=" return verif();" >
<!-- 	<div class="col-sm-8"> -->
		
		<!-- <div class="panel panel-primary">
			<div class="panel-heading"><br> -->
				

<% String employe_deja_existe=(String) request.getAttribute("employe_deja_existe");
if (employe_deja_existe!=null){
	out.print("<div class='col-md-6'><div class='alert alert-danger'>"+employe_deja_existe+"</div></div>");
}
%>
<% String ajouter_avec_succes=(String) request.getAttribute("ajouter_avec_succes");
if (ajouter_avec_succes!=null){
	out.print("<div class='col-md-6'><div class='alert alert-success'>"+ajouter_avec_succes+"</div></div>");
}
%>
<% String Supprimer_avec_succes=(String) request.getAttribute("Supprimer_avec_succes");
if (Supprimer_avec_succes!=null){
	out.print("<div class='col-md-6'><div class='alert alert-success'>"+Supprimer_avec_succes+"</div></div>");
}
%>
<% String modifier_avec_succes=(String) request.getAttribute("modifier_avec_succes");
if (modifier_avec_succes!=null){
	out.print("<div class='col-md-6'><div class='alert alert-success'>"+modifier_avec_succes+"</div></div>");
}
%><% String Erreur=(String) request.getAttribute("Erreur");
if (Erreur!=null){
	out.print("<div class='col-md-6'><div class='alert alert-danger'>"+Erreur+"</div></div>");
}
%>
			</div>
					<br>
				<br>
				<div class="panel-heading"><br>
	<center>
				<table border="0">
				<col width="300px"/>
				<col width="90px"/>
				<col width="300px"/>
				<col width="90px"/>
				<col width="300px"/>
				<tr>
				<td><label class="control-label">Identificateur *</label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="identificateur" data-validate="required,creditcard"  /></td></tr>
		<tr>	<td><label class="control-label">Prenom </label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="prenom" data-validate="required,creditcard"  /></td>
<td></td>
				<td>	<label class="control-label">Nom *</label>
				<p id="erreurnom"> </p>
				<input type="text" class="form-control" name="nom" data-validate="required,creditcard" /></td>
	<td></td><td><label class="control-label">Telephone </label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="tel" data-validate="required,creditcard"  /></td>			</tr>
				<tr>	<td><label class="control-label">Email</label>
				<p id="erreuridentificateur"></p>
				<input type="email" class="form-control" name="email" data-validate="required,creditcard"  /></td>
<td></td>
				<td>	<label class="control-label">Adresse </label>
				<p id="erreurnom"> </p>
				<input type="text" class="form-control" name="adresse" data-validate="required,creditcard" /></td>
				
		<td></td>		<td>	<label class="control-label">Photo</label>
				
				<input type="file" name="file"></td>
				</tr>
					<tr>	
				
				
				
							<tr>	<td><label class="control-label">Type *</label>
				<p id="erreuridentificateur"></p>
				<p id="erreurtype"> </p>
				
				<select  name="type"class="form-control">
				<option></option>
								<option value="Professeure enseignant supérieur">Professeure enseignant supérieur</option>
								<option value="Professeure agrégé">Professeure agrégé</option>
								<option value="PTC/PES">PTC/PES</option>
							
							
								
							</select></td>
			<td></td>				

				<td>	<label class="control-label">Grade *</label>
					<p id="erreurgrade"> </p>
				<select  name="grade"class="form-control">
				<option></option>
								<option>Professeur</option>
								<option>Maître de conférence </option>
								<option>Maître assistantt</option>
								<option>Assistant</option>
								<option>PTC/PES</option>
								<option>Autre ...</option>
							
								
							</select></td>
							
						<td></td>	
						
						<td><label class="control-label">Date de recrutement *</label>
									<p id="erreurdate"> </p>
				
				<input type="date" class="form-control" name="datereq" data-validate="required,creditcard"  /></td>
				</tr>
				
				
				
				</table>
			
		
		</center>
			
			<center>
			
			<div class="form-group">	
			<button type="submit" class="btn btn-success">Ajouter</button>
		
			<button type="reset" class="btn">Effacer</button>
			</div>
			</center>	
			</form>

			</div>
				
				
	<!-- 			 <form  action="addfon" method="post" enctype="multipart/form-data" >
				<table>
		<tr><td><label>	Nom	</label><td><td><input type="text" name="nom"></td></tr>
				<tr><td><label>	Prenom	</label><td><td><input type="text" name="prenom"></td></tr>
				<tr><td><label>	Telephone	</label><td><td><input type="text" name="tel"></td></tr>
				<tr><td><label>	Adresse	</label><td><td><input type="text" name="adresse"></td></tr>
				<tr><td><label>	Email	</label><td><td><input type="text" name="email"></td></tr>

				<tr><td><label>	Horaire  De Travail	</label><td><td><input type="text" name="heureTravail"></td></tr>
				<tr><td><label>	Type	</label><td><td><input type="text" name="type"></td></tr>
								
				<tr><td><label>	Grade	</label><td><td><input type="text" name="grade"></td></tr>
			</table>
			<input type="submit"  value="Ajouter">
			</form> -->
			
			
<!-- 		</div>
		
	</div> -->
	
<!-- </div> -->


<div class="row">
	
	
	
	<div class="col-sm-8">
		
		
			<div class="panel-heading">
				<div class="panel-title">Liste Des Enseignants</div>
				
				
			</div>
				
			<table class="table table-bordered table-responsive">
				<thead>
					<tr>
						<th>Photo</th>
						<th>Identificateur</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Telephone</th>
						<th>Email</th>
						<th>Adresse</th>
					
						<th>Type</th>
						<th>Grade</th>
						<th>Date de recrutement</th>
						
						<th>Action</th>
						<th>Cooperation</th>
						


					</tr>
				</thead>
				
				<tbody>
				
<c:forEach items="${enseignants}" var="ens">
					<tr>
					<td><img src="photoen?id=${ens.id}" alt="" class="img-circle" width="44" /></td>
					<td>${ens.identificateur}</td>
					<td>${ens.nom}</td>
					<td>${ens.prenom}</td>
					<td>${ens.tel}</td>
					<td>${ens.email}</td>
					<td>${ens.adresse}</td>
					
				
					<td>${ens.type}</td>
					<td>${ens.grade}</td>
					<td>${ens.datereq }</td>
					
					
					<td> <a href="suppenseignant?id=${ens.id}" class="btn btn-danger btn-sm btn-icon icon-left">
					<i class="entypo-cancel"></i>
					Supprimer
				</a>
					<a href="modifenseignant?id=${ens.id}" class="btn btn-default btn-sm btn-icon icon-left">
					<i class="entypo-pencil"></i>
					Modifier
				</a></td>
					<td><a href="cooperation?id=${ens.id}" class="btn btn-info btn-sm btn-icon icon-left">
					<i class="entypo-info"></i>
					Gérer
				</a></td>
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