<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Select2 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/AdminLTE/select2/dist/css/select2.min.css">

<div class="content-wrapper">
<!-- Content Header (Page header) -->
<section class="content-header">
  <h1>
    Blank page
    <small>it all starts here</small>
  </h1>
  <ol class="breadcrumb">
    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
    <li><a href="#">Examples</a></li>
    <li class="active">Blank page</li>
  </ol>
</section>

<!-- Main content -->
<section class="content">
    <div class="row">
    <!-- left column -->
    <div class="col-md-6">
        <!-- general form elements -->
        <div class="box box-primary">
        <div class="box-header with-border">
          <h3 class="box-title">Quick Example</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form role="form" method="POSt" action="/portal/specification/insertDOC.do"  enctype="multipart/form-data">
          <div class="box-body">
            <div class="form-group">
              <label for="exampleInputEmail1">Email address</label>
              <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Password</label>
              <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <div class="form-group">
              <label for="exampleInputFile">File input</label>
              <input type="file" id="exampleInputFile" name="files">
        
              <p class="help-block">Example block-level help text here.</p>
            </div>
            <div class="checkbox">
              <label>
                <input type="checkbox"> Check me out
              </label>
            </div>
          </div>
          <!-- /.box-body -->
        
          <div class="box-footer">
            <button type="submit" class="btn btn-primary">Submit</button>
          </div>
        </form>
        </div>
        <!-- /.box -->
        <!-- Default box -->
        <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Title</h3>
        
          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div class="box-body">
          Start creating your amazing application!
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          Footer
        </div>
        <!-- /.box-footer-->
        </div>
        <!-- /.box -->
    </div>
    <!-- /.col -->
    <!-- right column -->
    <div class="col-md-6">
        <!-- general form elements -->
        <div class="box box-primary">
        <div class="box-header with-border">
          <h3 class="box-title">서비스조회</h3>
            <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
                  <i class="fa fa-minus"></i></button>
                <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
                  <i class="fa fa-times"></i></button>
            </div>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
          <div class="box-body">
              <div class="form-group">
                <label>Minimal</label>
                <select class="form-control select2" style="width: 100%;">
                  <option selected="selected" value="" >Alabama</option>
                  <option value="">Alaska</option>
                  <option>California</option>
                  <option>Delaware</option>
                  <option>Tennessee</option>
                  <option>Texas</option>
                  <option>Washington</option>
                </select>
              </div>
              <div class="form-group">
                <label>Minimal</label>
                <select id="serviceSelectorById" class="form-control select2" style="width: 100%;">
<c:forEach var="serviceInfo" items="${ServiceInfoList}">
    <option value='<c:out value="${serviceInfo.COM_SE_ID}"/>'><c:out value="${serviceInfo.SE_NM_KR}(${serviceInfo.SE_NM_EN})"/></option>
</c:forEach>
                </select>
              </div>
            <div class="form-group">
               <label>Select Multiple</label>
               <select class="form-control">
                   <option>option 1</option>
                   <option>option 2</option>
                   <option>option 3</option>
                   <option>option 4</option>
                   <option>option 5</option>
               </select>
            </div>
            <div class="checkbox">
              <label>
                <input type="checkbox"> Check me out
              </label>
            </div>
          </div>
          <!-- /.box-body -->
        
          <div class="box-footer">
            <button type="submit" class="btn btn-primary">Submit</button>
          </div>
        </div>
        <!-- /.box -->
        <!-- Default box -->
        <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Title</h3>
        
          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div class="box-body">
          Start creating your amazing application!
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          Footer
        </div>
        <!-- /.box-footer-->
        </div>
        <!-- /.box -->
    </div>
    <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- Select2 -->
<script src="${pageContext.request.contextPath}/resources/AdminLTE/select2/dist/js/select2.full.js"></script>
<script type="text/javascript">
$(function(){
    //Initialize Select2 Elements
    $('.select2').select2();
    
    $('select#serviceSelectorById').on("change",function(){
        var serviceKeyVal = this.value;
        console.log("text::"+serviceKeyVal);
        opInfoList(serviceKeyVal);
    });

});

function opInfoList(serviceKeyVal){
    $.ajax({
        url : '/portal/specification/operationInfoList.ajax'
       ,method : "POST"
       ,data : { serviceKey: serviceKeyVal}
       ,dataType : 'json'
       ,success : function(data){
           console.log("응답후 로그");
       }
    }).done(function(){
        console.log("성공후로그");
    }).fail(function() {
        console.log("실패후로그");
    });
}
</script>