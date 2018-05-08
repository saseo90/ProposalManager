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
    <!-- blueimp Gallery styles -->
<link rel="stylesheet" href="https://blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
    <!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fileupload.9.21.0/css/jquery.fileupload.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fileupload.9.21.0/css/jquery.fileupload-ui.css">

<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="${pageContext.request.contextPath}/resources/fileupload.9.21.0/js/vendor/jquery.ui.widget.js"></script>
<!-- The Templates plugin is included to render the upload/download listings -->
<script src="https://blueimp.github.io/JavaScript-Templates/js/tmpl.min.js"></script>
<!-- The Load Image plugin is included for the preview images and image resizing functionality -->
<script src="https://blueimp.github.io/JavaScript-Load-Image/js/load-image.all.min.js"></script>
<!-- The Canvas to Blob plugin is included for image resizing functionality -->
<script src="https://blueimp.github.io/JavaScript-Canvas-to-Blob/js/canvas-to-blob.min.js"></script>
<!-- Bootstrap JS is not required, but included for the responsive demo navigation -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- blueimp Gallery script -->
<script src="https://blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="${pageContext.request.contextPath}/resources/fileupload.9.21.0/js/jquery.iframe-transport.js"></script>
<!-- The basic File Upload plugin -->
<script src="${pageContext.request.contextPath}/resources/fileupload.9.21.0/js/jquery.fileupload.js"></script>
<!-- The File Upload processing plugin -->
<script src="${pageContext.request.contextPath}/resources/fileupload.9.21.0/js/jquery.fileupload-process.js"></script>
<!-- The File Upload image preview & resize plugin -->
<script src="${pageContext.request.contextPath}/resources/fileupload.9.21.0/js/jquery.fileupload-image.js"></script>
<!-- The File Upload audio preview plugin -->
<script src="${pageContext.request.contextPath}/resources/fileupload.9.21.0/js/jquery.fileupload-audio.js"></script>
<!-- The File Upload video preview plugin -->
<script src="${pageContext.request.contextPath}/resources/fileupload.9.21.0/js/jquery.fileupload-video.js"></script>
<!-- The File Upload validation plugin -->
<script src="${pageContext.request.contextPath}/resources/fileupload.9.21.0/js/jquery.fileupload-validate.js"></script>
<!-- The File Upload user interface plugin -->
<script src="${pageContext.request.contextPath}/resources/fileupload.9.21.0/js/jquery.fileupload-ui.js"></script>
<!-- The main application script -->
<script src="${pageContext.request.contextPath}/resources/fileupload.9.21.0/js/main.js"></script>
        <!-- general form elements -->
        <div class="box box-primary">
        <div class="box-header with-border">
          <h3 class="box-title">API 문서 임포트 서비스</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form id="fileupload" role="form" method="POST" action="/portal/specification/insertDOC.do"  enctype="multipart/form-data">
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
          
        <div class="container">
<!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
        <div class="row fileupload-buttonbar">
            <div class="col-lg-7">
                <!-- The fileinput-button span is used to style the file input field as button -->
                <span class="btn btn-success fileinput-button">
                    <i class="glyphicon glyphicon-plus"></i>
                    <span>Add files...</span>
                    <input type="file" name="files[]" multiple>
                </span>
                <button type="submit" class="btn btn-primary start">
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Start upload</span>
                </button>
                <button type="reset" class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel upload</span>
                </button>
                <button type="button" class="btn btn-danger delete">
                    <i class="glyphicon glyphicon-trash"></i>
                    <span>Delete</span>
                </button>
                <input type="checkbox" class="toggle">
                <!-- The global file processing state -->
                <span class="fileupload-process"></span>
            </div>
            <!-- The global progress state -->
            <div class="col-lg-5 fileupload-progress fade">
                <!-- The global progress bar -->
                <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
                    <div class="progress-bar progress-bar-success" style="width:0%;"></div>
                </div>
                <!-- The extended global progress state -->
                <div class="progress-extended">&nbsp;</div>
            </div>
        </div>
        <!-- The table listing the files available for upload/download -->
        <table role="presentation" class="table table-striped"><tbody class="files"></tbody></table>
        </div>
        </form>
        <!-- /.form -->
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
<!-- The template to display files available for upload -->
<script id="template-upload" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade">
        <td>
            <span class="preview"></span>
        </td>
        <td>
            <p class="name">{%=file.name%}</p>
            <strong class="error text-danger"></strong>
        </td>
        <td>
            <p class="size">Processing...</p>
            <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="progress-bar progress-bar-success" style="width:0%;"></div></div>
        </td>
        <td>
            {% if (!i && !o.options.autoUpload) { %}
                <button class="btn btn-primary start" disabled>
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Start</span>
                </button>
            {% } %}
            {% if (!i) { %}
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
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