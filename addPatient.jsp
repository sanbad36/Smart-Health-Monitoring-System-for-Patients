<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.icu.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Smart ICU</title>



<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Baxster Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />


<script type="application/x-javascript">
	
	
	

	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 




</script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!-- chart -->
<script src="js/Chart.js"></script>
<!-- //chart -->
<!-- js-->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<!--webfonts-->
<link
	href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css"
	media="all">
<script src="js/wow.min.js"></script>
<script>
	new WOW().init();
</script>
<!--//end-animate-->
<!-- Metis Menu -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<link href="css/custom.css" rel="stylesheet">
<!--//Metis Menu -->
<style>
.hea {
	text-align: center;
	font-size: 50px;
	margin-top: 200px;
	color: blue;
	font-family: Times New Roman Georgia;
}

$
bg: #332f35 ; $fg: lighten ($bg, 20%); $borderWidth: 3px ; body {
	background: $bg;
	font-family: roboto;
}

input[type=radio] {
	position: absolute;
	visibility: hidden;
	display: none;
}

label {
	color: lighten($ bg, 40%);
	display: inline-block;
	cursor: pointer;
	font-weight: bold;
	padding: 5px 20px;
}

input[type=radio]:checked+label {
	color: black;
	background: #8e9091;
}

label+input[type=radio]+label {
	border-left: solid 2px #8e9091;
}

.radio-group {
	border: solid 2px #8e9091;
	display: inline-block;
	margin: 20px;
	border-radius: 15px;
	overflow: hidden;
	background: #a0d9e0;
	margin-top: -10px;
	margin-left: 1px;
}

@import url('https://fonts.googleapis.com/css?family=Roboto');
</style>

</head>
<body class="cbp-spmenu-push">
	<style>
.combo-label {
	margin-bottom: .3em;
}
</style>
	<div class="main-content">
		<!--left-fixed -navigation-->
		<div class="sidebar" role="navigation">
			<div class="navbar-collapse">
				<nav
					class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right dev-page-sidebar mCustomScrollbar _mCS_1 mCS-autoHide mCS_no_scrollbar"
					id="cbp-spmenu-s1">
				<div class="scrollbar scrollbar1">
					<ul class="nav" id="side-menu">
						<li><a href="welcomeSupervisor.jsp" class="active"><i
								class="fa fa-home nav_icon"></i>HOME</a></li>

						<li><a href="viewPatient.jsp"><i
								class="fa fa-book nav_icon"></i>view Patient </a>
						<li><a href="addPatient.jsp"><i
								class="fa fa-check-square-o nav_icon"></i>Add Patient</a></li>


						<li><a href="sensor.jsp"><i
								class="fa fa-check-square-o nav_icon"></i>Sensor Values</a></li>


					</ul>
				</div>
				<!-- //sidebar-collapse --> </nav>
			</div>
		</div>
		<!--left-fixed -navigation-->
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				<!--logo -->
				<div class="logo">
					<a href="#">
						<ul>
							<li><img src="images/logo1.png" alt="" /></li>
							<li><h1>Smart ICU</h1></li>
							<div class="clearfix"></div>
						</ul>
					</a>
				</div>
				<!--//logo-->
				<div class="header-right header-right-grid">
					<div class="profile_details_left">
						<!--notifications of menu start -->

						<div class="clearfix"></div>
					</div>
				</div>


				<div class="clearfix"></div>
			</div>

			<div class="header-right">

				<!--notification menu end -->
				<div class="profile_details">
					<ul>
						<li class="dropdown profile_details_drop"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false">
								<div class="profile_img">
									<a href="index.jsp"> <i class="fa fa-sign-out nav_icon"></i>Logout
									</a>
									<div class="clearfix"></div>
								</div>
						</a></li>
					</ul>
				</div>
				<!--toggle button start-->
				<button id="showLeftPush">
					<i class="fa fa-bars"></i>
				</button>
				<!--toggle button end-->
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
		<!-- //header-ends -->
		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">

				<div class="row">

					<div class="grids">
						<div class="progressbar-heading grids-heading">
							<h2>Forms</h2>
						</div>
						<div class="panel panel-widget forms-panel">
							<div class="forms">
								<div class="form-grids widget-shadow"
									data-example-id="basic-forms">
									<div class="form-title">
										<h4>Patients details</h4>
									</div>
									<div class="form-body">



										<form method="post" action="PatientsAdd"
											enctype="multipart/form-data">
											<table border="0">



												<Div>
													<Lable class="col-sm-2 form-control-label">Patients
													Name:</Lable>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="nameTxt"
															placeholder="FirstName MiddleName LastName" required>
													</div>
												</div>
												<br>
												<br>
												<br>
												<Div>
													<Lable class="col-sm-2 form-control-label">ICU
													Ward:</Lable>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="emailTxt"
															onkeypress="return isNumberKey(event)"
															placeholder="ICU Ward" required>
													</div>
												</div>
												<br>
												<br>
												<br>
												<Div>
													<Lable class="col-sm-2 form-control-label">Bed No:</Lable>
													<div class="col-sm-10">
														<input type="text" class="form-control"
															placeholder="Bed No" name="passwordTxt" required>
														<div class="col-sm-10"></div>
													</div>
												</Div>
												<br>
												<br>
												<br>
												<Div>
													<Lable class="col-sm-2 form-control-label">Contact:</Lable>
													<div class="col-sm-10">
														<input type="text" onkeypress="return isNumberKey(event)"
															minlength="10" maxlength="10" class="form-control"
															placeholder="Contact" name="ContactTxt" required>
													</div>
												</div>
												<br>
												<br>
												<br>

												<Div>
													<Lable class="col-sm-2 form-control-label">Address</Lable>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="addressTxt"
															placeholder="Address" required>
													</div>
												</div>
												<br>
												<br>
												<br>
												<Div>
													<Lable class="col-sm-3 form-control-label">Do You
													Have Any Disease?</Lable>
													<div class="col-sm-9">
														<!-- <input type="text" class="form-control" name="diseaseTxt" placeholder="Disease" 
																required>
																 -->
														<div class="radio-group">
															<input type="radio" id="option-one1" value=""><label
																for="option-one1" value="Yes" data-toggle="collapse"
																data-target="#collapse" aria-expanded="true"
																aria-controls="collapseOne">Yes</label><input
																type="radio" id="option-two1" name="diseaseTxt"
																value="No"><label for="option-two1" value="Male">No</label>
														</div>
													</div>
												</Div>
												<div id="collapse" class="collapse"
													aria-labelledby="heading" data-parent="#accordion">
													<div class="card-body">

														<input type="checkbox" name="coffee" value="BP">
														BP<br>
														 <input type="checkbox" name="coffee"
															value="BP"> aaaaa<br>
															 <input type="checkbox"
															name="coffee" value="BP"> BP<br>
															 <input
															type="checkbox" name="coffee" value="BP"> BP<br>
															
														<div class="form-group row m-b-0">
															<div class="col-sm-offset-3 col-sm-9">
																<input type="text" name="diseaseTxt" id="order"
																	size="50"> <input type="button"
																	onclick="myFunction()" class="btn btn-primary"
																	value="Add">

															</div>

														</div>

													</div>
													<script>
													function myFunction() {
														var coffee = document.forms[0];
														var txt1 = "";
														var i;
														for (i = 0; i < coffee.length; i++) {
															if (coffee[i].checked) {
																txt1 = txt1
																		+ coffee[i].value
																		+ ",";
															}
														}
														document
																.getElementById("order").value = ","
																+ txt1;
													}
												</script>
												</div>
												<br>
												<br>
												<br>

												<Div>
													<Lable class="col-sm-2 form-control-label">Kit
													Assign</Lable>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="kitTxt"
															required>
													</div>
												</div>
												<br>
												<br>
												<br>
												<Div>
													<Lable class="col-sm-2 form-control-label">Gender:</Lable>
													<div class="col-sm-10">
														<div class="radio-group">
															<input type="radio" id="option-one" name="genderTxt"
																value="Male"><label for="option-one"
																value="Male">Male</label><input type="radio"
																id="option-two" name="genderTxt" value="Female"><label
																for="option-two" value="Female">Female</label><input
																type="radio" id="option-three" name="genderTxt"
																value="Other"><label for="option-three">Other</label>
														</div>
													</div>
												</Div>





												









												<br>
												<br>
												<br>
												<Div>
													<Lable class="col-sm-2 form-control-label">Doctor</Lable>
													<div class="col-sm-10">
														<select name='doctorTxt' class="form-control"
															required="required">
															<option>---</option>
															<%
																try {

																	Connection connection = DBconnect.getConnect();
																	Statement statement = null;
																	ResultSet resultset = null;
																	statement = connection.createStatement();

																	resultset = statement.executeQuery("select * from doctor");
															%>

															<%
																while (resultset.next()) {
															%>
															<option><%=resultset.getString(2)%></option>
															<%
																}
															%>
														</select>
													</div>
												</div>
												<br>
												<br>
												<br>
												<%
													//**Should I input the codes here?**
													} catch (Exception e) {
														out.println("wrong entry" + e);
													}
												%>


												<Div>
													<Lable class="col-sm-2 form-control-label">Portrait
													Photo: </Lable>

													<div class="col-sm-10">
														<input type="file" name="photo" size="50" required />
													</div>
												</div>
												<br>
												<br>
												<br>


												<Div>
													<Lable class="col-sm-2 form-control-label">BloodGroup:</Lable>
													<div class="col-sm-10">
														<select name='bloodTxt' class="form-control"
															required="required">
															<option>---</option>
															<option>O positive</option>
															<option>O negative</option>
															<option>A positive</option>

															<option>A negative</option>
															<option>B positive</option>

															<option>B negative</option>
															<option>AB positive</option>
															<option>AB negative</option>
														</select>
													</div>
												</div>
												<br>
												<br>
												<br>

												<Div>
													<Lable class="col-sm-2 form-control-label">Occupation:</Lable>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="Occupation"
															placeholder="Occupation" required>
													</div>
												</div>
												<br>
												<br>
												<br>


												<Div>
													<Lable class="col-sm-2 form-control-label">AdharCard
													No:</Lable>
													<div class="col-sm-10">
														<input type="text" onkeypress="return isNumberKey(event)"
															minlength="12" maxlength="12" class="form-control"
															placeholder="AdharCard No" name="adharTxt" required>
													</div>
												</div>
												<br>
												<br>
												<br>

												<Div>
													<center>
														<h2>Relative Information</h2>
														<center>
												</div>
												<br>
												<br>
												<br>

												<Div>
													<Lable class="col-sm-2 form-control-label">Relative
													Name:</Lable>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="rnameTxt"
															placeholder="FirstName MiddleName LastName" required>
													</div>
												</div>
												<br>
												<br>
												<br>

												<Div>
													<Lable class="col-sm-2 form-control-label">Relative
													Contact:</Lable>
													<div class="col-sm-10">
														<input type="text" onkeypress="return isNumberKey(event)"
															minlength="10" maxlength="10" class="form-control"
															placeholder="Contact" name="rContactTxt" required>
													</div>
												</div>
												<br>
												<br>
												<br>
												<Div>
													<Lable class="col-sm-2 form-control-label">Gender:</Lable>
													<div class="col-sm-10">
														<div class="radio-group">
															<input type="radio" id="option-one2" name="rgenderTxt" value="Male"><label
																for="option-one2" value="Male">Male</label><input
																type="radio" id="option-two2" name="rgenderTxt"
																value="Female"><label for="option-two2"
																value="Male">Female</label><input type="radio"
																id="option-three2" name="rgenderTxt" value="Other"><label
																for="option-three2">Other</label>
														</div>
													</div>
												</Div>

												<br>
												<br>
												<br>
												<Div>
													<input type="submit" value="Save" class="btn btn-info">
												</div>
											</table>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!--//row-->
			</div>
		</div>
		<!--footer-->
		<div class="dev-page">

			<!-- page footer -->
			<!-- dev-page-footer-closed dev-page-footer-fixed -->
			<div class="dev-page-footer dev-page-footer-fixed">
				<!-- container -->
				<div class="container">

					<!-- page footer buttons -->

					<!-- //page footer buttons -->
					<!-- page footer container -->
					<div class="dev-page-footer-container">

						<!-- loader and close button -->
						<div class="dev-page-footer-container-layer">
							<a href="#" class="dev-page-footer-container-layer-button"></a>
						</div>
						<!-- //loader and close button -->

						<!-- informers -->


						<!-- informers -->


						<!-- projects -->

						<!-- //projects -->
					</div>
					<!-- //page footer container -->

				</div>
				<!-- //container -->
			</div>
			<!-- /page footer -->
		</div>
		<!--//footer-->
	</div>
	<!-- Classie -->

	<script src="js/classie.js"></script>
	<script>
		var menuLeft = document.getElementById('cbp-spmenu-s1'), showLeftPush = document
				.getElementById('showLeftPush'), body = document.body;

		showLeftPush.onclick = function() {
			classie.toggle(this, 'active');
			classie.toggle(body, 'cbp-spmenu-push-toright');
			classie.toggle(menuLeft, 'cbp-spmenu-open');
			disableOther('showLeftPush');
		};

		function disableOther(button) {
			if (button !== 'showLeftPush') {
				classie.toggle(showLeftPush, 'disabled');
			}
		}
	</script>
	<!-- Bootstrap Core JavaScript -->

	<script type="text/javascript" src="js/bootstrap.min.js"></script>

	<script type="text/javascript" src="js/dev-loaders.js"></script>
	<script type="text/javascript" src="js/dev-layout-default.js"></script>
	<script type="text/javascript" src="js/jquery.marquee.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet">

	<!-- candlestick -->
	<script type="text/javascript" src="js/jquery.jqcandlestick.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/jqcandlestick.css" />
	<!-- //candlestick -->

	<!--max-plugin-->
	<script type="text/javascript" src="js/plugins.js"></script>
	<!--//max-plugin-->

	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->

	<!-- real-time-updates -->
	<script language="javascript" type="text/javascript"
		src="js/jquery.flot.js"></script>
	<script type="text/javascript">
		$(function() {

			// We use an inline data source in the example, usually data would
			// be fetched from a server

			var data = [], totalPoints = 300;

			function getRandomData() {

				if (data.length > 0)
					data = data.slice(1);

				// Do a random walk

				while (data.length < totalPoints) {

					var prev = data.length > 0 ? data[data.length - 1] : 50, y = prev
							+ Math.random() * 10 - 5;

					if (y < 0) {
						y = 0;
					} else if (y > 100) {
						y = 100;
					}

					data.push(y);
				}

				// Zip the generated y values with the x values

				var res = [];
				for (var i = 0; i < data.length; ++i) {
					res.push([ i, data[i] ])
				}

				return res;
			}

			// Set up the control widget

			var updateInterval = 30;
			$("#updateInterval").val(updateInterval).change(function() {
				var v = $(this).val();
				if (v && !isNaN(+v)) {
					updateInterval = +v;
					if (updateInterval < 1) {
						updateInterval = 1;
					} else if (updateInterval > 2000) {
						updateInterval = 2000;
					}
					$(this).val("" + updateInterval);
				}
			});

			var plot = $.plot("#placeholder", [ getRandomData() ], {
				series : {
					shadowSize : 0
				// Drawing is faster without shadows
				},
				yaxis : {
					min : 0,
					max : 100
				},
				xaxis : {
					show : false
				}
			});

			function update() {

				plot.setData([ getRandomData() ]);

				// Since the axes don't change, we don't need to call plot.setupGrid()

				plot.draw();
				setTimeout(update, updateInterval);
			}

			update();

			// Add the Flot version string to the footer

			$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
		});
	</script>
	<!-- //real-time-updates -->
	<!-- error-graph -->
	<script language="javascript" type="text/javascript"
		src="js/jquery.flot.errorbars.js"></script>
	<script language="javascript" type="text/javascript"
		src="js/jquery.flot.navigate.js"></script>
	<script type="text/javascript">
		$(function() {

			function drawArrow(ctx, x, y, radius) {
				ctx.beginPath();
				ctx.moveTo(x + radius, y + radius);
				ctx.lineTo(x, y);
				ctx.lineTo(x - radius, y + radius);
				ctx.stroke();
			}

			function drawSemiCircle(ctx, x, y, radius) {
				ctx.beginPath();
				ctx.arc(x, y, radius, 0, Math.PI, false);
				ctx.moveTo(x - radius, y);
				ctx.lineTo(x + radius, y);
				ctx.stroke();
			}

			var data1 = [ [ 1, 1, .5, .1, .3 ], [ 2, 2, .3, .5, .2 ],
					[ 3, 3, .9, .5, .2 ], [ 1.5, -.05, .5, .1, .3 ],
					[ 3.15, 1., .5, .1, .3 ], [ 2.5, -1., .5, .1, .3 ] ];

			var data1_points = {
				show : true,
				radius : 5,
				fillColor : "blue",
				errorbars : "xy",
				xerr : {
					show : true,
					asymmetric : true,
					upperCap : "-",
					lowerCap : "-"
				},
				yerr : {
					show : true,
					color : "red",
					upperCap : "-"
				}
			};

			var data2 = [ [ .7, 3, .2, .4 ], [ 1.5, 2.2, .3, .4 ],
					[ 2.3, 1, .5, .2 ] ];

			var data2_points = {
				show : true,
				radius : 5,
				errorbars : "y",
				yerr : {
					show : true,
					asymmetric : true,
					upperCap : drawArrow,
					lowerCap : drawSemiCircle
				}
			};

			var data3 = [ [ 1, 2, .4 ], [ 2, 0.5, .3 ], [ 2.7, 2, .5 ] ];

			var data3_points = {
				//do not show points
				radius : 0,
				errorbars : "y",
				yerr : {
					show : true,
					upperCap : "-",
					lowerCap : "-",
					radius : 5
				}
			};

			var data4 = [ [ 1.3, 1 ], [ 1.75, 2.5 ], [ 2.5, 0.5 ] ];

			var data4_errors = [ 0.1, 0.4, 0.2 ];
			for (var i = 0; i < data4.length; i++) {
				data4_errors[i] = data4[i].concat(data4_errors[i])
			}

			var data = [ {
				color : "blue",
				points : data1_points,
				data : data1,
				label : "data1"
			}, {
				color : "red",
				points : data2_points,
				data : data2,
				label : "data2"
			}, {
				color : "green",
				lines : {
					show : true
				},
				points : data3_points,
				data : data3,
				label : "data3"
			},
			// bars with errors
			{
				color : "orange",
				bars : {
					show : true,
					align : "center",
					barWidth : 0.25
				},
				data : data4,
				label : "data4"
			}, {
				color : "orange",
				points : data3_points,
				data : data4_errors
			} ];

			$.plot($("#placeholder1"), data, {
				legend : {
					position : "sw",
					show : true
				},
				series : {
					lines : {
						show : false
					}
				},
				xaxis : {
					min : 0.6,
					max : 3.1
				},
				yaxis : {
					min : 0,
					max : 3.5
				},
				zoom : {
					interactive : true
				},
				pan : {
					interactive : true
				}
			});

			// Add the Flot version string to the footer

			$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
		});
	</script>
	<!-- //error-graph -->
	<!-- Skills-graph -->
	<script src="js/Chart.Core.js"></script>
	<script src="js/Chart.Doughnut.js"></script>
	<script>
		var doughnutData = [ {
			value : 2,
			label : "One",
			color : "#99CC00"
		}, {
			value : 3,
			label : "Two",
			color : "#FF3300"
		}, {
			value : 3,
			label : "Three",
			color : "#944DDB"
		}, {
			value : 4,
			label : "Four",
			color : "#3399FF"
		}, {
			value : 5,
			label : "Five",
			color : "#FFC575"
		}

		];

		window.onload = function() {
			var ctx = document.getElementById("chart-area").getContext("2d");
			window.myDoughnut = new Chart(ctx).Doughnut(doughnutData, {
				responsive : true
			});
		};
	</script>
	<!-- //Skills-graph -->
	<!-- status -->
	<script src="js/jquery.fn.gantt.js"></script>
	<script>
		$(function() {

			"use strict";

			$(".gantt").gantt({
				source : [ {
					name : "Sprint 0",
					desc : "Analysis",
					values : [ {
						from : "/Date(1320192000000)/",
						to : "/Date(1322401600000)/",
						label : "Requirement Gathering",
						customClass : "ganttRed"
					} ]
				}, {
					name : " ",
					desc : "Scoping",
					values : [ {
						from : "/Date(1322611200000)/",
						to : "/Date(1323302400000)/",
						label : "Scoping",
						customClass : "ganttRed"
					} ]
				}, {
					name : "Sprint 1",
					desc : "Development",
					values : [ {
						from : "/Date(1323802400000)/",
						to : "/Date(1325685200000)/",
						label : "Development",
						customClass : "ganttGreen"
					} ]
				}, {
					name : " ",
					desc : "Showcasing",
					values : [ {
						from : "/Date(1325685200000)/",
						to : "/Date(1325695200000)/",
						label : "Showcasing",
						customClass : "ganttBlue"
					} ]
				}, {
					name : "Sprint 2",
					desc : "Development",
					values : [ {
						from : "/Date(1326785200000)/",
						to : "/Date(1325785200000)/",
						label : "Development",
						customClass : "ganttGreen"
					} ]
				}, {
					name : " ",
					desc : "Showcasing",
					values : [ {
						from : "/Date(1328785200000)/",
						to : "/Date(1328905200000)/",
						label : "Showcasing",
						customClass : "ganttBlue"
					} ]
				}, {
					name : "Release Stage",
					desc : "Training",
					values : [ {
						from : "/Date(1330011200000)/",
						to : "/Date(1336611200000)/",
						label : "Training",
						customClass : "ganttOrange"
					} ]
				}, {
					name : " ",
					desc : "Deployment",
					values : [ {
						from : "/Date(1336611200000)/",
						to : "/Date(1338711200000)/",
						label : "Deployment",
						customClass : "ganttOrange"
					} ]
				}, {
					name : " ",
					desc : "Warranty Period",
					values : [ {
						from : "/Date(1336611200000)/",
						to : "/Date(1349711200000)/",
						label : "Warranty Period",
						customClass : "ganttOrange"
					} ]
				} ],
				navigate : "scroll",
				scale : "weeks",
				maxScale : "months",
				minScale : "days",
				itemsPerPage : 10,
				onItemClick : function(data) {
					alert("Item clicked - show some details");
				},
				onAddClick : function(dt, rowId) {
					alert("Empty space clicked - add an item!");
				},
				onRender : function() {
					if (window.console && typeof console.log === "function") {
						console.log("chart rendered");
					}
				}
			});

			$(".gantt").popover({
				selector : ".bar",
				title : "I'm a popover",
				content : "And I'm the content of said popover.",
				trigger : "hover"
			});

			prettyPrint();

		});
	</script>
	<SCRIPT language=Javascript>
		function isNumberKey(evt) {
			var charCode = (evt.which) ? evt.which : event.keyCode;

			if (charCode > 31 && (charCode<48 || charCode>57))
				return false;

			return true;
		}
	</SCRIPT>
	<!-- //status -->

</body>
>