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
	
	
			<script type="text/javascript">
	function verif() {
	/* 	if(document.f.nom.value==""){
			document.getElementById("erreurnom").innerHTML="<div class='col-md-6'><div class='alert alert-danger'><strong>Oh opps!</strong> nom obligatoire </div></div>";
			
			window.location.href="#erreurnom";
			return false;
		} */
		var	v=true;
			if((document.f.type.value=="")   ){
				document.getElementById("erreurtype").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'>Selectionner le type  </font> </div></div>";
				
				
				
				window.location.href="#erreurtype";
				v= false;
				
			}
		if((document.f.grade.value=="")   ){
			document.getElementById("erreurgrade").innerHTML="<div class='col-md-6'><div class=''><font size='1' color='red'>Selectionner grade  </font> </div></div>";
			
			
			
			window.location.href="#erreurgrade";
			v= false;
			
		}
		
			
		return v;
				
			
	}
	</script>

				
				<center><h2>Modifier les ouvriers</h2></center>
	
 <form  action="modouv" method="post" enctype="multipart/form-data"name="f" onsubmit=" return verif();" >
	<div class="col-sm-8">
			
				<center>
				<table border="0">
				<col width="300px"/>
				<col width="90px"/>
				<col width="300px"/>
				<col width="90px"/>
				<col width="300px"/>
				<tr><td><label class="control-label">Id</label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="id" data-validate="required,creditcard"  value="${ouvrier.id }"  readonly="readonly"/></td><td></td>
				<td><label class="control-label">Identificateur *</label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="identificateur" data-validate="required,creditcard"  value="${ouvrier.identificateur }"  readonly="readonly" /></td></tr>
		<tr>	<td><label class="control-label">Prenom </label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="prenom" data-validate="required,creditcard" value="${ouvrier.prenom }" /></td>
<td></td>
				<td>	<label class="control-label">Nom *</label>
				<p id="erreurnom"> </p>
				<input type="text" class="form-control" name="nom" data-validate="required,creditcard" value="${ouvrier.nom }"/></td>
	<td></td><td><label class="control-label">Telephone </label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="tel" data-validate="required,creditcard"  value="${ouvrier.tel }" /></td>			</tr>
				<tr>	<td><label class="control-label">Email</label>
				<p id="erreuridentificateur"></p>
				<input type="text" class="form-control" name="email" data-validate="required,creditcard" value="${ouvrier.email }"  /></td>
<td></td>
				<td>	<label class="control-label">Adresse </label>
				<p id="erreurnom"> </p>
				<input type="text" class="form-control" name="adresse" data-validate="required,creditcard" value="${ouvrier.adresse }" /></td>
				
		<td></td>		<td>	<label class="control-label">Photo</label>
					<img src="photoouv?id=${ouvrier.id}">
				<input type="file" name="file"></td>
				</tr>
		<tr><td><label class="control-label">Heure d'entrée  </label>
				
				<input type="time" class="form-control" name="heureTravaildebut" data-validate="required,creditcard"   value ="${ouvrier.heureTravaildebut }"  />
			
				
			
			</td>
			
			<td></td>
			<td><label class="control-label">Heure de sortie </label>
				
				<input type="time" class="form-control" name="heureTravailfin" data-validate="required,creditcard"  value ="${ouvrier.heureTravailfin }"  /></td>
			</tr>		
				
					<tr>	
				
				
				
							<tr>	<td><label class="control-label">Type *</label>
							existe :${ouvrier.type }<br>
		changer type
			
				<p id="erreurtype"> </p>
				
					<select  name="type"class="form-control" ">
				<option></option>
								<option>C1 </option>
								<option>C2</option>
								<option>C3 </option>
								<option>C4 </option>
								<option>C5 </option>							
								
							</select></td>
			<td></td>				

				<td>	<label class="control-label">Grade *</label>
						existe :${ouvrier.grade }<br>
		changer type
					<p id="erreurgrade"> </p>
			<input type="text" class="form-control" name="grade" data-validate="required,creditcard" value="${ouvrier.grade }"  /></td>
							
						<td></td>	
						
						<td><label class="control-label">Date de recrutement *</label>
									<p id="erreurdate"> </p>
				
				<input type="date" class="form-control" name="datereq" data-validate="required,creditcard"  value="${ouvrier.datereq }" /></td>
				</tr>
				
				
				
				</table>
			
		<center>
			<div class="form-group">	
			<button type="submit" class="btn btn-success">Modifier</button>
		
			<button type="reset" class="btn">Effacer</button>
			</div>
			</center>	
		</center>

				<%-- 	<br>
				<br>
				
				<div class="form-group">
				<label class="control-label">Id</label>
				
				<input type="text" class="form-control" name="id" data-validate="required,creditcard"  value="${ouvrier.id }"  readonly="readonly"/>
			</div>
				<div class="form-group">
				<label class="control-label">Identificateur</label>
				
				<input type="text" class="form-control" name="identificateur" data-validate="required,creditcard"  value="${ouvrier.identificateur }" readonly="readonly" />
			</div>
			<div class="form-group">
				<label class="control-label">Nom</label>
				
				<input type="text" class="form-control" name="nom" data-validate="required,creditcard" value="${ouvrier.nom }"/>
			</div>
			<div class="form-group">
				<label class="control-label">Prenom</label>
				
				<input type="text" class="form-control" name="prenom" data-validate="required,creditcard" value="${ouvrier.prenom }" />
			</div>
			<div class="form-group">
				<label class="control-label">Telephone</label>
				
				<input type="text" class="form-control" name="tel" data-validate="required,creditcard" value="${ouvrier.tel }" />
			</div>
			<div class="form-group">
				<label class="control-label">Adresse</label>
				
				<input type="text" class="form-control" name="adresse" data-validate="required,creditcard" value="${ouvrier.adresse }"  />
			</div>
				<div class="form-group">
			<label class="control-label">Email</label>
				
				<input type="email" class="form-control" name="email" data-validate="required,creditcard" value="${ouvrier.email }" />
			</div>
			<div class="form-group">
			<label class="control-label">heureTravaildébut </label>
				
				<input type="time" class="form-control" name="heureTravaildebut" data-validate="required,creditcard" value ="${ouvrier.heureTravaildebut }" />
			</div>
				<div class="form-group">
			<label class="control-label">heureTravailfin </label>
				
				<input type="time" class="form-control" name="heureTravailfin" data-validate="required,creditcard" value="${ouvrier.heureTravaildebut }" />
			</div>
			
			<div class="form-group">
			<label class="control-label">Type</label>
					existe :${ouvrier.type }<br>
		changer type
		<p id="erreurtype"> </p>
				<select  name="type"class="form-control" ">
				<option></option>
								<option>C1 </option>
								<option>C2</option>
								<option>C3 </option>
								<option>C4 </option>
								<option>C5 </option>							
								
							</select>
			</div>
			<div class="form-group">
			<label class="control-label">Grade</label>
				<p id="erreurgrade"> </p>
				<input type="text" class="form-control" name="grade" data-validate="required,creditcard" value="${ouvrier.grade }"  />
			</div>
			<div class="form-group">
			<label class="control-label">Date de recrutement</label>
				
				<input type="date" class="form-control" name="datereq" data-validate="required,creditcard"  value="${ouvrier.datereq }"/>
			</div>
			<img src="photoouv?id=${ouvrier.id}">
			<input type="file" name="file">
			<center>
			<div class="form-group">	
			<button type="submit" class="btn btn-success">Modifier</button>
		
			<button type="reset" class="btn">Effacer</button>
			</div>
			</center>	 --%>
			</form>

				
				

			
			
		</div>
		
	</div>
	
</div>


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