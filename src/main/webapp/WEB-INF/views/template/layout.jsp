<%@page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
	
	<spring:url value="/resources/public/jquery/jquery.validate.min.js" var="jQuery"/>
  	<spring:url value="/resources/public/uikit/css/uikit.min.css" var="uikitMinCSS"/>
  	<spring:url value="/resources/public/uikit/css/uikit.css" var="uikitCSS"/>
  	<spring:url value="/resources/public/font-awesome/css/font-awesome.min.css" var="fontawesome"/>
  	<spring:url value="/resources/public/css/style.css" var="customCSS"/>
  	<spring:url value="/resources/public/uikit/js/uikit.min.js" var="uikitJS"/>
  	<spring:url value="/resources/jspdf/libs/FileSaver/FileSaver.min.js" var="fileSaverJS"/>
  	<spring:url value="/resources/jspdf/libs/js-xlsx/xlsx.core.min.js" var="xlsxJS"/>
  	<spring:url value="/resources/jspdf/libs/jsPDF/jspdf.min.js" var="jspdfJS"/>
  	<spring:url value="/resources/jspdf/libs/jsPDF-AutoTable/jspdf.plugin.autotable.js" var="jspdfAutoTableJS"/>
  	<spring:url value="/resources/jspdf/tableExport.min.js" var="tableExportJS"/>
  	<spring:url value="/resources/public/js/main.js" var="mainJS"/>
  	<spring:url value="/resources/Bootstrap/css/bootstrap.min.css" var="bootstrapMinCss"/>
  	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  	
 <!-- 	<script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	
  	<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">
  	
  	<link href="${uikitMinCSS}" rel="stylesheet"/>
  	<link href="${uikitCSS}" rel="stylesheet"/>
  	<link href="${fontawesome}" rel="stylesheet"/>
  	<link href="${customCSS}" rel="stylesheet"/>
  	
  <!-- 	<script src="https://www.gstatic.com/firebasejs/4.12.0/firebase.js"></script> -->
  	<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
<!-- <script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyCmHQz3u4gSoKA-9p1tlEtf4sx5RqHTMbE",
    authDomain: "homesmart-292b5.firebaseapp.com",
    databaseURL: "https://homesmart-292b5.firebaseio.com",
    projectId: "homesmart-292b5",
    storageBucket: "",
    messagingSenderId: "621505529007"
  };
  firebase.initializeApp(config);
</script> -->
  	
</head>

<body>

<div class="loading-spinner">
	
</div>
    <div class="site">
        <tiles:insertAttribute name="navigation" />
        <div class="site-content">
            <div class="top_jumbotron">
                <div class="uk-container">
                    <div class="text_wrapper uk-text-center">
                        <h1 class="heading">
                            We are Escott Team
                        </h1>
                        <p class="team_desc">
                            We build and manage IOT (Internet Of Things) System.
                        </p>
                    </div>
                </div>
            </div>

            <div class="section_menu_bar uk-flex  uk-flex-center">
                <ul class="section_menu_nav uk-flex-inline uk-flex-wrap-around" uk-switcher="connect: .section_container">
                    <li>
                        <a id="dashboardMenu" href="#">Dashboard</a>
                    </li>
                    <li>
                        <a id="sourceMenu" href="#">Source</a>
                    </li>
                    <li>
                        <a id="eventMenu" href="#">Event</a>
                    </li>
                    <li>
                        <a id="exportMenu" href="#">Export</a>
                    </li>
                    <li>
                        <a id="boardRegistration" href="#">Registration</a>
                    </li>
                  
                </ul>
            </div>
            
            
            <tiles:insertAttribute name="body" />
            
            </div>
		</div>
		
<!--  	<script>
   $( function() {
    var dateFormat = "mm/dd/yy",
      from = $( "#export_from" )
        .datepicker({
          defaultDate: "+1w",
          changeMonth: true,
          numberOfMonths: 1
        })
        .on( "change", function() {
        	 var date = Date.parse($(this).val());
        	 if (date > Date.now()){
                 alert('Please select another date');
                 $(this).val('');
             }
          to.datepicker( "option", "minDate", getDate( this ) );
        }),
      to = $( "#export_until" ).datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 1
      })
      .on( "change", function() {
    	  var date = Date.parse($(this).val());
     	 if (date > Date.now()){
              alert('Please select another date');
              $(this).val('');
          }
        from.datepicker( "option", "maxDate", getDate( this ) );
      });
 
    function getDate( element ) {
      var date;
      try {
        date = $.datepicker.parseDate( dateFormat, element.value );
      } catch( error ) {
        date = null;
      }
 
      return date;
    }
  } ); 
   </script>  -->
		 
		<script src="${uikitJS}"></script>
		<script src="${fileSaverJS}"></script>
		<script src="${xlsxJS}"></script>
		<script src="${jspdfJS}"></script>
		<script src="${jspdfAutoTableJS}"></script>
		<script src="${tableExportJS}"></script>
		<script src="${mainJS}"></script>
		
	</body>
</html>
		
