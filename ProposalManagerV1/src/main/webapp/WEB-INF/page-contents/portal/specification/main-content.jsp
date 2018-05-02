<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Select2 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/AdminLTE/select2/dist/css/select2.min.css">
<!-- DataTables -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/AdminLTE/datatables.net-bs/css/dataTables.bootstrap.min.css">
<!-- Select2 -->
<script src="${pageContext.request.contextPath}/resources/AdminLTE/select2/dist/js/select2.full.js"></script>
<!-- DataTables -->
<script src="${pageContext.request.contextPath}/resources/AdminLTE/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/AdminLTE/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

<div class="content-wrapper">
<!-- Content Header (Page header) -->
<section class="content-header">
  <h1>
     포털 명세서서비스
    <small>홈페이지</small>
  </h1>
  <ol class="breadcrumb">
    <li class="active">Home</li>
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
          <h3 class="box-title">API 문서 임포트 서비스</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form role="form" method="POSt" action="/portal/specification/insertDOC.do"  enctype="multipart/form-data">
          <div class="box-body">
            <div class="form-group">
              <label for="exampleInputFile">File input</label>
              <input type="file" id="exampleInputFile" name="files">
        
              <p class="help-block">Example block-level help text here.</p>
            </div>
          </div>
          <!-- /.box-body -->
        
          <div class="box-footer">
            <button type="submit" class="btn btn-primary">Submit</button>
          </div>
        </form>
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
        <!-- body start -->
        <div class="box-body">
            <div class="form-group">
            <label>서비스</label>
            <select id="serviceSelectorById" class="form-control select2" style="width: 100%;">
<c:forEach var="serviceInfo" items="${ServiceInfoList}">
    <option value='<c:out value="${serviceInfo.COM_SE_ID}"/>'><c:out value="${serviceInfo.SE_NM_KR}(${serviceInfo.SE_NM_EN})"/></option>
</c:forEach>
            </select>
            </div>
            <div id="OperationSelectorDivById" class="form-group">
            </div>
        </div>
        <!-- /.box-body -->
        <!-- foot Button Bar -->
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
    <!-- row -->
    <div class="row">
    <!-- left column -->
    <div class="col-md-12">
    
     <!-- Default box -->
        <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">메시지명세서</h3>
        
          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div id="MSGSelectorById" class="box-body">
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
<script type="text/javascript">
$(function(){
    //Initialize Select2 Elements
    $('.select2').select2();
/*     $('.example1').DataTable({
        'paging'      : true,
        'lengthChange': false,
        'searching'   : false,
        'ordering'    : true,
        'info'        : true,
        'autoWidth'   : false
    }) */
    $('select#serviceSelectorById').on("change",function(){
        var serviceKeyVal = this.value;
        console.log("text::"+serviceKeyVal);
        opInfoList(serviceKeyVal, "operation");
        $("div#MSGSelectorById").html('');
    });
    $('div#OperationSelectorDivById').on("change","select#OperationSelectorById",function(){
        var operationKeyVal = this.value;
        console.log("text::"+operationKeyVal);
        opInfoList(operationKeyVal, "msg");
    });
});

function opInfoList(KeyVal, typeVal){
    $.ajax({
        url : '/portal/specification/operationInfoList.do'
       ,method : "POST"
       ,data : { serviceKey : KeyVal, type : typeVal }
       ,dataType : 'html'
       ,success : function(data){
           if('operation' == typeVal){               
               $("div#OperationSelectorDivById").html(data);
           }else if('msg' == typeVal){
               $("div#MSGSelectorById").html(data);
               $('#example1').DataTable();
               $('#example2').DataTable();
           }
       }
    }).done(function(){
<%--        console.log("성공후로그"); --%>
    }).fail(function() {
<%--        console.log("실패후로그"); --%>
    });
}
</script>