<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인페이지</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper" id="wrapper">
  <!-- Main Header -->
  <tiles:insertAttribute name="main-header"/>
  <!-- /.Main Header -->
  
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
</body>
</html>