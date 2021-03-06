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
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/mycss.css">
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
	<!-- 					
			<div class="sidebar-collapse">
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
					D�connexion<i class="entypo-logout right"></i></a>
				
			
			</li>
		
		</ul>
				
		<ul class="user-info pull-left pull-right-xs pull-none-xsm">
			
			<!-- Raw Notifications -->
			<li class="notifications dropdown">
				
			<!-- 	<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
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
<script type="text/javascript">
	function verif() {
	
		var	v=true;
			if((document.f.datededepart.value=="")   ){
				document.getElementById("erreurdepart").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'>Date obligatoire </font> </div></div>";
				
				
				
				window.location.href="#erreurdepart";
				v= false;
				
			}
		
			 if(document.f.pays.value==""){
			document.getElementById("erreurpaysr").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'> Pays obligatoire</font> </div></div>";
			window.location.href="#erreurpaysr";
			v= false;
		}
			 
			return v;
				
			
	}
	</script>
<hr />

	<center><h2>Enseignants en cooperation</h2></center>
<center>
<% String employe_deja_existe=(String) request.getAttribute("employe_deja_existe");
if (employe_deja_existe!=null){
	out.print("<div class='col-md-6'><div class='alert alert-danger'>"+employe_deja_existe+"</div></div>");
}
%>
<% String ajouter_avec_succes=(String) request.getAttribute("ajouter_avec_succes");
if (ajouter_avec_succes!=null){
	out.print("<div class='col-md-6'><div class='alert alert-success'>"+ajouter_avec_succes+"</div></div>");
}
%></center>
<div class="row">

	
	
	<div class="col-sm-8">
		
		
				
	
				
				<form  action="addcoop" method="post" enctype="multipart/form-data"  name="f" onsubmit=" return verif();">

		<center>	
		
				

				<table border="0">
				<col width="300px"/>
				<col width="90px"/>
				<col width="300px"/>
				<col width="90px"/>
				<col width="300px"/>
				<tr>
				<td><label class="control-label">Id </label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="iden" data-validate="required,creditcard"  value="${enseignant.id }" readonly="readonly" /></td>
	<td></td>			<td><label class="control-label">Identificateur </label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="identificateur" data-validate="required,creditcard" value="${enseignant.identificateur }" readonly /></td>
				</tr>
		<tr>	<td><label class="control-label">Prenom </label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="prenom" data-validate="required,creditcard" value="${enseignant.prenom }" readonly="readonly" /></td>
<td></td>
				<td>	<label class="control-label">Nom *</label>
				<p id="erreurnom"> </p>
				<input type="text" class="form-control" name="nom" data-validate="required,creditcard" value="${enseignant.nom }" readonly="readonly"/></td>
	<td></td><td><label class="control-label">Telephone </label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="tel" data-validate="required,creditcard"value="${enseignant.tel }" readonly="readonly" /></td>			</tr>
				<tr>	<td><label class="control-label">Email</label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="email" data-validate="required,creditcard" value="${enseignant.email }" readonly="readonly"/></td>
<td></td>
				<td>	<label class="control-label">Adresse </label>
				<p id="erreurnom"> </p>
				<input type="text" class="form-control" name="adresse" data-validate="required,creditcard" value="${enseignant.adresse }" readonly="readonly"/></td>
				
		<td></td>		<%-- <td>	<label class="control-label">Photo</label>
				<img src="photoen?id=${enseignant.id}"  />
				<input type="file" name="file"></td> --%>
				</tr>
					<tr>	
				
				
				
							<tr>	<td><label class="control-label">Type *</label>
			
			
				<p id="erreurtype"> </p>
				<input type="text" class="form-control"  name="type" value="${enseignant.type }" readonly="readonly">
				</td>
			<td></td>				

				<td>	<label class="control-label">Grade *</label>
			
					<p id="erreurgrade"> </p>
					<input type="text" class="form-control"  name="grade" value="${enseignant.grade }" readonly="readonly">
				</td>
							
						<td></td>	
						
						<td><label class="control-label">Date de recrutement *</label>
									<p id="erreurdate"> </p>
				
				<input type="date" class="form-control" name="datereq" data-validate="required,creditcard"  value="${enseignant.datereq }" readonly="readonly" /></td>
				</tr>
				
				<tr>
				<td><label class="control-label">Date de depart </label>
				<p id="erreurdepart"></p>
				<input type="date" class="form-control" name="datededepart" data-validate="required,creditcard"   /></td>
	<td></td>			<td><label class="control-label">Pays </label>
				<p id="erreurpaysr"></p>
				<input type="text" class="form-control" name="pays" data-validate="required,creditcard" /></td>
				</tr>
				
				</table>
			
		
		</center>
			<center>
			<div class="form-group">	
			<button type="submit" class="btn btn-success">Ajouter</button>
		
			<button type="reset" class="btn">Effacer</button>
			</div>
			</center>

<%-- 
<div class="form-group">
id <span id='marge'/>     <input name="iden" value="${enseignant.id }">  


<td>Identificateur</td><td> <input name="identificateur" value="${enseignant.identificateur }"></td>


</tr>

<td>Nom</td><td> <input name="nom" value="${enseignant.nom }"></td>


</tr>

<tr>
<td>Prenom</td><td> <input name="prenom" value="${enseignant.prenom }"></td>

</tr>
<tr>
<td>Telephone</td><td> <input name="tel" value="${enseignant.tel }"></td> 

</tr>
<tr>
<td>Adresse</td><td> <input name="adresse"value="${enseignant.adresse }"></td>

</tr>
<tr>
<td>Email</td><td> <input name="email" value="${enseignant.email }"></td>

</tr>

<tr>
<td>Type</td><td> <input name="type" value="${enseignant.type }"></td>

</tr>
<tr>
<td>Grade</td><td> <input name="grade" value="${enseignant.grade }"></td>

</tr>
<td>Date de recrutement</td><td> <input  name="datereq" type="date" value="${enseignant.datereq }"></td>


</tr>
<tr><td>Date de depart</td><td> <input  name="datededepart" type="date" ></td></tr>
<tr><td>pays</td><td> <input name="pays" type=text><td></tr>
<tr>
<td><input type="submit" value="ajouter">
<input type="reset" value="effacer"></td>
</tr>
</div>
</form>
				
				
	
			
			
		</div> --%>
		
	</div>
	
</div>


<div class="row">
	
	
	
	<div class="col-sm-8">
		
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="panel-title">Liste des Enseignants en cooperation</div>
				
				
			</div>
				
			<table class="table table-bordered table-responsive">
				<thead>
					<tr>
				
						<th>Identificateur</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Telephone</th>
						<th>Email</th>
						<th>Adresse</th>
						
						<th>Type</th>
						<th>Grade</th>
						<th>date de recrutement</th>
						<th>Date de depart</th>
						<th>Pays</th>
						<th>Action</th>
						


					</tr>
				</thead>
				
				<tbody>
				
<c:forEach items="${cooperations}" var="ens">
					<tr>
						
					
					<td>${ens.identificateur}</td>
					<td>${ens.nom}</td>
					<td>${ens.prenom}</td>
					<td>${ens.tel}</td>
					<td>${ens.email}</td>
					<td>${ens.adresse}</td>	
					<td>${ens.type}</td>
					<td>${ens.grade}</td>
					<td>${ens.datereq }</td>
					<td>${ens.datededepart }</td>
					<td>${ens.pays }</td>
					<td><a href="suppcooperation?id=${ens.id}" class="btn btn-danger btn-sm btn-icon icon-left">
					<i class="entypo-cancel"></i>
					Supprimer</a>
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
	
		
	&copy; 2017 <strong>ESSTHS</strong> Cr�er par Hamdi Boukadida
	
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