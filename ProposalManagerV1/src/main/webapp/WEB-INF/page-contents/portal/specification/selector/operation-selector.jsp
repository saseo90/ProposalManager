<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<label id="OperationNameById">오퍼레이션</label>
<select id="OperationSelectorById" class="form-control select2" style="width: 100%;">
<c:forEach var="operationInfo" items="${OperationInfoList}">
<option value='<c:out value="${operationInfo.COM_SE_ID}"/>'><c:out value="${operationInfo.SE_NM_KR}(${operationInfo.SE_NM_EN})"/></option>
</c:forEach>     
</select>