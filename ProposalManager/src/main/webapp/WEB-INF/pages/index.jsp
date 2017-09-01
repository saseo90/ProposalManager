<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- Main Header -->
<tiles:insertAttribute name="main-header"/>
<!-- /.Main Header -->
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/AdminLTE/bootstrap/dist/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/AdminLTE/bootstrap/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/AdminLTE/bootstrap/Ionicons/css/ionicons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/AdminLTE/dist/css/AdminLTE.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/AdminLTE/dist/css/skins/skin-green.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper" id="wrapper">
  <!-- Main TopBar -->
  <tiles:insertAttribute name="main-topbar"/>
  <!-- /.Main TopBar -->
  
  <!-- Left side column. contains the logo and sidebar -->
  <tiles:insertAttribute name="main-sidebar" />
  <!-- /.Left side column -->
  
    <!-- content-wrapper -->
  <tiles:insertAttribute name="content-wrapper"/>
  <!-- /.content-wrapper -->
  
  
  <!-- Main Footer -->
  <tiles:insertAttribute name="main-footer" />
  <!-- /.Main Footer -->
  <!-- Control Sidebar -->
  <tiles:insertAttribute name="control-sidebar"/>
  <!-- /.control-sidebar -->
  
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="${pageContext.request.contextPath}/resources/AdminLTE/jquery/dist/jquery.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/resources/AdminLTE/bootstrap/dist/js/bootstrap.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/resources/AdminLTE/dist/js/adminlte.js"></script>

</body>
</html>