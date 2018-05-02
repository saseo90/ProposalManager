<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table id="example1" class="table table-bordered table-striped">
<thead>
<tr>
  <th>구분</th>
  <th>국문이름</th>
  <th>영문이름</th>
  <th>항목크기</th>
  <th>항목구분</th>
  <th>샘플데이터</th>
  <th>설명</th>
</tr>
</thead>
<tbody>
<c:forEach var="MSGRqsInfo" items="${MSGRqsInfoALL}">
    <tr>
    <c:choose>
        <c:when test="${ 'RQS' eq MSGRqsInfo.MSG_GB}">
            <td>요청</td>
        </c:when>
        <c:when test="${ 'RSP' eq MSGRqsInfo.MSG_GB}">
            <td>응답</td>
        </c:when>
        <c:otherwise><td></td></c:otherwise>
    </c:choose>
    <td><c:out value="${MSGRqsInfo.ITEM_NM_KR}" /></td>
    <td><c:out value="${MSGRqsInfo.ITEM_NM_EN}" /></td>
    <td><c:out value="${MSGRqsInfo.ITEM_SIZE}" /></td>
    <td><c:out value="${MSGRqsInfo.ITEM_GB}" /></td>
    <td><c:out value="${MSGRqsInfo.SAMPLE_DATA}" /></td>
    <td><c:out value="${MSGRqsInfo.ITEM_CONT}" /></td>
    </tr>
</c:forEach>
</tbody>
<tfoot>
<tr>
  <th>구분</th>
  <th>국문이름</th>
  <th>영문이름</th>
  <th>항목크기</th>
  <th>항목구분</th>
  <th>샘플데이터</th>
  <th>설명</th>
</tr>
</tfoot>
</table>
<table id="example2" class="table table-bordered table-striped">
<thead>
<tr>
  <th>구분</th>
  <th>국문이름</th>
  <th>영문이름</th>
  <th>항목크기</th>
  <th>항목구분</th>
  <th>샘플데이터</th>
  <th>설명</th>
</tr>
</thead>
<tbody>
<c:forEach var="MSGRspInfo" items="${MSGRspInfoALL}">
    <tr>
    <c:choose>
        <c:when test="${ 'RQS' eq MSGRspInfo.MSG_GB}">
            <td>요청</td>
        </c:when>
        <c:when test="${ 'RSP' eq MSGRspInfo.MSG_GB}">
            <td>응답</td>
        </c:when>
        <c:otherwise><td></td></c:otherwise>
    </c:choose>
    <td><c:out value="${MSGRspInfo.ITEM_NM_KR}" /></td>
    <td><c:out value="${MSGRspInfo.ITEM_NM_EN}" /></td>
    <td><c:out value="${MSGRspInfo.ITEM_SIZE}" /></td>
    <td><c:out value="${MSGRspInfo.ITEM_GB}" /></td>
    <td><c:out value="${MSGRspInfo.SAMPLE_DATA}" /></td>
    <td><c:out value="${MSGRspInfo.ITEM_CONT}" /></td>
    </tr>
</c:forEach>
</tbody>
<tfoot>
<tr>
  <th>구분</th>
  <th>국문이름</th>
  <th>영문이름</th>
  <th>항목크기</th>
  <th>항목구분</th>
  <th>샘플데이터</th>
  <th>설명</th>
</tr>
</tfoot>
</table>