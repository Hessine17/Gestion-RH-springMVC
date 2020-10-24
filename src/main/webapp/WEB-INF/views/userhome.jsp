<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>



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
		
									
			
			<!-- open/close menu icon (do not remove if you want to enable menu on mobile devices) -->
			<div class="sidebar-mobile-menu visible-xs">
				<a href="#" class="with-animation"><!-- add class "with-animation" to support animation -->
					<i class="entypo-menu"></i>
				</a>
			</div>
			
		</header>
				
		
		
				
		
				
		<%@ include file="UserNavigationbar.jsp" %>
				
	</div>	
	<div class="main-content">
		
<div class="row">

	
	<!-- Profile Info and Notifications -->
	<div class="col-md-6 col-sm-8 clearfix">
		
		<ul class="user-info pull-left pull-none-xsm">
		
						<!-- Profile Info -->
			<li class="profile-info dropdown"><!-- add class "pull-right" if you want to place this from right -->
				<c:out value="${requestScope['username']}"></c:out>
					<a href="<c:url value="/j_spring_security_logout" />" >
					Déconnexion <i class="entypo-logout right"></i></a>
			
			
			</li>
	
		</ul>
				
		<ul class="user-info pull-left pull-right-xs pull-none-xsm">
			
			<!-- Raw Notifications -->
			<li class="notifications dropdown">
				
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					<i class="entypo-bell"></i>
					<span class="badge badge-info">${notification}</span>
				</a>
				
				<ul class="dropdown-menu">
					<li class="top">
	<p class="small">
	
			Vous avez <strong>${notification}</strong> nouvelle(s) notification(s).
		
	</p>
</li>

<li>
	<ul class="dropdown-menu-list scroller">
		<!-- Notification -->
		<c:forEach items="${notifications}" var="notif">		<li class="unread notification-success">
			<a >
				
				
				<span class="line">
					<strong>L'employé ${notif.prenom }  ${notif.nom } retourne aujorud'hui au travail </strong>
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
					<i class="entypo-list"></i>
					<span class="badge badge-warning">${titu }</span> 
					<span class="badge badge-warning"></span>
				</a>
				
				<ul class="dropdown-menu">
					<li class="top">

<p>	Vous avez ${titu} nouvelle(s) notifications de titularisation(s)</p>
</li>
			
 	<ul class="dropdown-menu-list scroller">
	<c:forEach items="${titulis}" var="ens">
	<li class="notification-warning">
			<a>
			
			
			
				<span class="line">
				C'est la date de titularisation du fonctionnnaire	"${ens.prenom} ${ens.nom} "
				</span>
				
			
			</a>
			
		</li>
	</c:forEach> 
	
	<c:forEach items="${tituliso}" var="ens">
	<li class="notification-warning">
			<a >
			
			
			
				<span class="line">
				C'est la date de titularisation de l'ouvrier   " ${ens.prenom} ${ens.nom} "
				</span>
				
			
			</a>
			
		</li>
	</c:forEach>
	
</ul>



				

	
	<!-- Raw Links -->
	<div class="col-md-6 col-sm-4 clearfix hidden-xs">
		
				
	</div>

</div>






	
	
		





	
	<div class="col-sm-8">
			<form action="stat">
	
			<script src="<%=request.getContextPath()%>/resources/assets/canvasjs.min.js"></script>
			<table>
			<tr>
			<td><input type="date" name="date1" class="form-control"></td>
			<td></td>
			<td><input type="date" name="date2"class="form-control"></td>
			</tr>
			<tr><td></td>
			<td><input type="submit" class="btn btn-success" value="Valider"></td></tr>
			</table>
	
	
	
	
	</form>

			
							<div id="chartContainer" style="height: 300px; width: 100%;"></div>		

			<div class="panel-heading"><br>
				<div class="row">
	<div class="col-sm-3">
	
		<div class="tile-stats tile-red">
	
			<div class="icon"></div>
			<h3>Nombre	 des enseignants</h3>
			<div class="num" data-start="0" data-end="${enseignants }" data-postfix="" data-duration="1500" data-delay="0">0</div>
			
			
		</div>
		
	</div>
	

	
	<div class="col-sm-3">
	
		<div class="tile-stats tile-aqua">
			<div class="icon"></div>
			<h3>Nombre des fonctionnaires</h3>
			<div class="num" data-start="0" data-end="${fonctionnaires }" data-postfix="" data-duration="1500" data-delay="1200">0</div>
			
			
		
		</div>
		
	</div>
	<div class="col-sm-3">
	
		<div class="tile-stats tile-blue">
			<div class="icon"></div>
				<h3>Nombre des ouvriers</h3>
			<div class="num" data-start="0" data-end="${ouvriers }" data-postfix="" data-duration="1500" data-delay="1800">0</div>
			
		
			
		</div>
	
			</div>
						
	</div>

		
<!-- 		<script type="text/javascript">
		window.onload = function () {
			var chart = new CanvasJS.Chart("chartContainer",
			{
				title:{
					text: "Bar chart"
				},

				data: [
				{
					type: "bar",

					dataPoints: [
					{ x: 10, y: ${ouvriers }, label:"Apple" },
					{ x: 20, y: ${enseignants }, label:"Mango" },
					{ x: 30, y: 50, label:"Orange" },
					{ x: 40, y: 60, label:"Banana" },
					{ x: 50, y: 20, label:"Pineapple" },
					{ x: 60, y: 30, label:"Pears" },
					{ x: 70, y: 35, label:"Grapes" },
					{ x: 80, y: 40, label:"Lychee" },
					{ x: 90, y: 30, label:"Jackfruit" }
					]
				}
				]
			});

			chart.render();
		}
	</script> -->
<!-- 	<script type="text/javascript">
		window.onload = function () {
			var chart = new CanvasJS.Chart("chartContainer",
			{
				title: {
					text: "Gaming Consoles Sold in 2012"
				},
				animationEnabled: true,
				animationDuration: 2000,
				legend: {
					verticalAlign: "bottom",
					horizontalAlign: "center"
				},
				data: [
				{
					indexLabelFontSize: 20,
					indexLabelFontFamily: "Monospace",
					indexLabelFontColor: "darkgrey",
					indexLabelLineColor: "darkgrey",
					indexLabelPlacement: "outside",
					type: "pie",
					showInLegend: true,
					toolTipContent: "{y} - <strong>#percent%</strong>",
					dataPoints: [
						{ y: ${ouvriers }, legendText: "ouvriers", indexLabel: "ouvriers" },
						{ y: ${enseignants }, legendText: "enseignants", indexLabel: "enseignants" },
						{  y: ${fonctionnaires }, legendText: "fonctionnaires", indexLabel: "fonctionnaires"},
						{  y: ${heureretardouv}, indexLabel: "retard" },


					]
				}
				]
			});
			chart.render();
		}
	</script> -->
	
<script type="text/javascript">
  window.onload = function () {
    var chart = new CanvasJS.Chart("chartContainer",
    {
      title:{
      text: "Taux de présence "   
      },
      animationEnabled: true,
      axisX:{
        title: ""
      },
      axisY:{
        title: "Pourcentage"
      },
      data: [
      {        
        type: "stackedColumn100",
        name: "retardataire ",
        showInLegend: "true",
        toolTipContent: "{y} - <strong>#percent%</strong>",
        dataPoints: [
        	
        {  y: ${heureretardouv}, label:"aaa"},
        {  y: ${heureretardfon}, label:"aaa"},
              
        ]
      }, {        
        type: "stackedColumn100",        
        name: "Présent",
        showInLegend: "true",
        dataPoints: [
        {  y: ${presentouv }, label: "Ouvriers"},
        {  y: ${presentfon }, label: "Fonctionnaires" },
                 
        ]
      }

      ]
    });

    chart.render();
  }
  </script>
	
	
							

	</div>
	</div>


<br />


</div>

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