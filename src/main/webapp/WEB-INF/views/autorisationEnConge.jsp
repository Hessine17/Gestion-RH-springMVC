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
		<!-- 				
			<div class="sidebar-collapse">
				<a href="#" class="sidebar-collapse-icon with-animation">add class "with-animation" if you want sidebar to have animation during expanding/collapsing transition
					<i class="entypo-menu"></i>
				</a>
			</div>
			
									
			
			open/close menu icon (do not remove if you want to enable menu on mobile devices)
			<div class="sidebar-mobile-menu visible-xs">
				<a href="#" class="with-animation">add class "with-animation" to support animation
					<i class="entypo-menu"></i>
				</a>
			</div>
			 -->
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
		<%-- 		
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
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
	/* 	if(document.f.nom.value==""){
			document.getElementById("erreurnom").innerHTML="<div class='col-md-6'><div class='alert alert-danger'><strong>Oh opps!</strong> nom obligatoire </div></div>";
			
			window.location.href="#erreurnom";
			return false;
		} */
		var	v=true;
			if(document.f.type.value=="")   {
				document.getElementById("erreurtype").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'>Type obligatoire </font> </div></div>";
		
				window.location.href="#erreurtype";
				v= false;
				
			}
		 	if((document.f.type.value=="Congé maladie")&&(document.f.type2.value=="") )  {
				document.getElementById("erreurtype2").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'>Type 2 obligatoire </font> </div></div>";
		
				window.location.href="#erreurtype2";
				v= false;
				
			} 
	
		
			

			if(document.f.nbrj.value==""){
				document.getElementById("erreurnbrj").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'> Nombre de jours obligatoire</font> </div></div>";
				window.location.href="#erreurnbrj";
				v= false;
			}
			if(document.f.datededebut.value==""){
				document.getElementById("erreurdatededebut").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'> Date de debut obligatoire</font> </div></div>";
				window.location.href="#erreurdatededebut";
				v= false;
			}
			
			if(document.f.datedefin.value==""){
				document.getElementById("erreurdatedefin").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'> Date de fin obligatoire</font> </div></div>";
				window.location.href="#erreurdatedefin";
				v= false;
			}
			if(document.f.adresse.value==""){
				document.getElementById("erreuradresse").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'>Adresse obligatoire</font> </div></div>";
				window.location.href="#erreuradresse";
				v= false;
			}
			
		
			 
			
			return v;
				
			
	}
	</script>
	</div>

<div class="row">

<center><h2>	Ajouter un congé  </h2></center>


	
		 <form  action="addcongeEn" method="post" enctype="multipart/form-data"  name="f" onsubmit=" return verif();">

<table>
<col width="300px"/>
				<col width="90px"/>
				<col width="300px"/>

<tr>
<td><label class="control-label">Id</label>
			
				<input type="text" class="form-control" name="iden" data-validate="required,creditcard"  value="${enseignants.id }" readonly="readonly" /></td>
</tr>
<tr><td><!-- <label class="control-label">Reste Congé annuel</label>
		<p id="ereurreste"></p>  -->
			<%-- <input type="text" class="form-control" name="reste" data-validate="required,creditcard"  value="${enseignants.congéanull }" readonly="readonly" /> </td></tr> --%>
<tr><td><label class="control-label">Identificateur</label>
				
				<input type="text" class="form-control" name="identificateur" data-validate="required,creditcard" value="${enseignants.identificateur }" readonly="readonly" /></td>
<td></td>
<td><label class="control-label">Nom</label>
				
				<input type="text" class="form-control" name="nom" data-validate="required,creditcard"  value="${enseignants.nom }" readonly="readonly" /></td>
</tr>

<tr>
<td><label class="control-label">Prenom </label>
				
				<input type="text" class="form-control" name="prenom" data-validate="required,creditcard" value="${enseignants.prenom }" readonly="readonly" /></td>
<td></td>
<td><label class="control-label">Type </label>
				
				<input type="text" class="form-control" name="type3" data-validate="required,creditcard"  value="${enseignants.type }" readonly="readonly"/></td>
</tr>
<tr>
<td><label class="control-label">Nombre de jours *</label>
<p id="erreurnbrj"> </p>
	<input type="number" class="form-control" name="nbrj" data-validate="required,creditcard"  />
</td><td></td>
<td><label class="control-label">Grade</label>
				
				<input type="text" class="form-control" name="grade" data-validate="required,creditcard" value="${enseignants.grade }" readonly="readonly" /></td>
<td></td>

</tr>
<tr><td><label class="control-label">Type de Congé </label>
			<p id="erreurtype"></p>
				<select  name="type"class="form-control">
								<option></option>
								<option value="Congé maladie">Congé maladie</option>
								<option value=" Congé exceptionnel" > Congé exceptionnel</option>
							
							
								
							</select>
				</td>
<td></td>
<td><label class="control-label">Type 2</label>
		 <p id="erreurtype2"></p>
			<select  name="type2"class="form-control">
			<option></option>
			<option>Congé de maternité </option>
								<option> Congé de paternité </option>
								
							
								
							</select></td>
</tr>

<tr>
<td><label class="control-label">Date de debut *</label>
				<p id="erreurdatededebut"></p>
				<input type="date" class="form-control" name="datededebut" data-validate="required,creditcard"  /></td>
<td></td>
<td><label class="control-label">Date de fin *</label>
				<p id="erreurdatedefin"></p>
				
				<input type="date" class="form-control" name="datedefin" data-validate="required,creditcard"  /></td>
</tr>

<tr><td><label class="control-label">Adresse *</label>
				<p id="erreuradresse"></p>
				<input type="text " class="form-control" name="adresse" data-validate="required,creditcard"  /></td>
<td></td>
<td><label class="control-label">Telephone </label>
				
				<input type="text" class="form-control" name="tel" data-validate="required,creditcard"  /></td>
</tr>
<tr><td><label class="control-label">Code postal  </label>
				
				<input type="text" class="form-control" name="codepostal" data-validate="required,creditcard"  /></td>
<td></td>
<td><label class="control-label">Papier</label>
				
				<input type="text" class="form-control" name="papier" data-validate="required,creditcard"  /></td>
</tr>

</table>






		<%-- 		<div class="form-group">
				<label class="control-label">Id</label>
			
				<input type="text" class="form-control" name="idfon" data-validate="required,creditcard"  value="${fonctionnaire.id }" readonly="readonly" />
			</div>
				
					<div class="form-group">
				<label class="control-label">Reste Congé annuel</label>
		<p id="ereurreste"></p> 
				<input type="text" class="form-control" name="reste" data-validate="required,creditcard"  value="${fonctionnaire.congéanull }" readonly="readonly" />
			</div>
				
				
					<div class="form-group">
			<label class="control-label">Type de Congé </label>
			<p id="erreurtype"></p>
				<select  name="type"class="form-control">
								<option></option>
								<option >Conge annuel</option>
								<option >Congé maladie</option>
								<option > Congé exceptionnel</option>
							
							
								
							</select>
				
				<!-- <input type="text" class="form-control" name="type" data-validate="required,creditcard"  /> -->
			</div>
			<div class="form-group">
			<label class="control-label">Type 2</label>
		 <p id="erreurtype2"></p>
			<select  name="type2"class="form-control">
								<option></option>
								<option>maternité </option>
							
								
							</select>
			</div>	
				
				<div class="form-group">
				<label class="control-label">Identificateur</label>
				
				<input type="text" class="form-control" name="identificateur" data-validate="required,creditcard" value="${fonctionnaire.identificateur }" readonly="readonly" />
			</div>
			
			
			
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
				
				<input type="text" class="form-control" name="type3" data-validate="required,creditcard"  value="${fonctionnaire.type }" readonly="readonly"/>
			</div>
		
			<!-- 	<input type="text" class="form-control" name="grade" data-validate="required,creditcard"  /> -->
			
			<div class="form-group">
			<label class="control-label">Grade</label>
				
				<input type="text" class="form-control" name="grade" data-validate="required,creditcard" value="${fonctionnaire.grade }" readonly="readonly" />
			</div>

		<div class="form-group"><tabel><tr><td><label class="control-label">Nombre de jours *</label></td>
			<td><p id="erreurnbrj"> </p></td></tr></tabel>
		
				
				<input type="number" class="form-control" name="nbrj" data-validate="required,creditcard"  />
				
			</div>

			<div class="form-group">
				<label class="control-label">Date de debut *</label>
				<p id="erreurdatededebut"></p>
				<input type="date" class="form-control" name="datededebut" data-validate="required,creditcard"  />
			</div>
			 <div class="form-group">
				<label class="control-label">Date de fin *</label>
				<p id="erreurdatedefin"></p>
				
				<input type="date" class="form-control" name="datedefin" data-validate="required,creditcard"  />
			</div>
		<!--	<div class="form-group">
				<label class="control-label">Adresse *</label>
				<p id="erreuradresse"></p>
				
				<input type="date" class="form-control" name="adresse" data-validate="required,creditcard"  />
			</div> -->
				<div class="form-group">
			<label class="control-label">Adresse *</label>
				<p id="erreuradresse"></p>
				<input type="text " class="form-control" name="adresse" data-validate="required,creditcard"  />
			</div>
			<div class="form-group">
			<label class="control-label">Code postal  </label>
				
				<input type="text" class="form-control" name="codepostal" data-validate="required,creditcard"  />
			</div>
				<div class="form-group">
			<label class="control-label">Telephone </label>
				
				<input type="text" class="form-control" name="tel" data-validate="required,creditcard"  />
			</div>
		
			
			
			<div class="form-group">
			<label class="control-label">Papier</label>
				
				<input type="text" class="form-control" name="papier" data-validate="required,creditcard"  />
			</div> --%>
			<center>
			<div class="form-group">	
			<button type="submit" class="btn btn-success" >Ajouter</button>
		
			<button type="reset" class="btn">Effacer</button>
			</div>
			</center>	
			</form>
				
				
				
	 
				<!--  <div class="form-group">
				<label class="control-label">code postal   </label>
				
				<div class="compose-message-editor">
					<input type="text" class="form-control" name="date" data-validate="required,creditcard" />
				</div>
					 <div class="form-group">
				<label class="control-label">telephone </label>
				
				<div class="compose-message-editor">
					<input type="text" class="form-control" name="date" data-validate="required,creditcard" />
				</div>
			</div> 
			<!--	<div class="form-group">
			<label class="control-label">Email</label>
				
				<input type="email" class="form-control" name="email" data-validate="required,creditcard"  />
			</div>
				<div class="form-group">
			<label class="control-label">Horaire  De Travail</label>
				
				<input type="text" class="form-control" name="heureTravail" data-validate="required,creditcard"  />
			</div>
			<div class="form-group">
			<label class="control-label">Type</label>
				
				<input type="text" class="form-control" name="type" data-validate="required,creditcard"  />
			</div>
			<div class="form-group">
			<label class="control-label">Grade</label>
				
				<input type="text" class="form-control" name="grade" data-validate="required,creditcard"  />
			</div>
			<div class="form-group">
			<label class="control-label">Date de recrutement</label>
				
				<input type="date" class="form-control" name="datereq" data-validate="required,creditcard"  />
			</div>
			-->

			
				
				

			
	

	
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