<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="form-group">
<label>서비스</label>
<select id="serviceSelectorById" class="form-control select2" style="width: 100%;">
<c:forEach var="serviceInfo" items="${ServiceInfoList}">
<option value='<c:out value="${serviceInfo.COM_SE_ID}"/>'><c:out value="${serviceInfo.SE_NM_KR}(${serviceInfo.SE_NM_EN})"/></option>
</c:forEach>
</select>
</div>
              