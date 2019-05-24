<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Applicant.ApplicantID</td>
			<td>Applicant.ApplicantPassword</td>
			<td>Applicant.ApplicantName</td>
			<td>Applicant.ApplicantEmail</td>
			<td>Applicant.ApplicantAddr</td>
			<td>Applicant.ApplicantPhone</td>
			<td>Applicant.ApplicantRRN</td>
			<td>Applicant.ApplicantGender}</td>
			<td>Applicant.ApplicantcreateDate </td>
			<td>Applicant.ApplicantupdateDate</td>
		</tr>
		<c:forEach var="item" items="${applicants}">
			<tr>
				<td><a href="/applicant/${item.num}">${item.username}</td>
				<td>${item.password}</td>
				<td>${item.name}</td>
				<td>${item.addr}</td>
				<td>${item.email}</td>
				<td>${item.phone}</td>
				<td>${item.gender}</td>
				<td>${item.age}</td>
				<td>${item.applicantcreateDate}</td>
				<td>${item.applicantupdateDate}</td>
			</tr>
		</c:forEach>
		</table>
		<a href="http://localhost:8000/applicantupdate/">글쓰기</a>
		<a href="http://localhost:8000/applicant/create/">회원가입</a>
</body>
</html>