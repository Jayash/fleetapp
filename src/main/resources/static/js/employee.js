/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(employee, status){
			$('#txtAddressEdit').val(employee.address);
			$('#txtCityEdit').val(employee.city);
			$('#ddlNationalityEdit').val(employee.countryid);			
			var dob = employee.dateOfBirth.substr(0,10);
			$('#txtDateOfBirthEdit').val(dob);
			$('#txtEmailEdit').val(employee.email);
			$('#ddlTitleEdit').val(employee.title);
			
			$('#txtFirstnameEdit').val(employee.firstName);
			$('#ddlGenderEdit').val(employee.gender);
			$('#txtIdEdit').val(employee.id);
			$('#txtInitialsEdit').val(employee.initials);
			$('#txtLastnameEdit').val(employee.lastName);
			$('#ddlMaritalStatusEdit').val(employee.maritalStatus);
			$('#txtMobileEdit').val(employee.mobile);
			$('#txtOthernameEdit').val(employee.otherName);		
			$('#txtPhoneEdit').val(employee.phone);			
			$('#fupPhotoEdit').val(employee.photo);			
			$('#txtSSNEdit').val(employee.aadharNumber);			
			$('#ddlStateEdit').val(employee.stateid);	
			$('#ddlEmployeeTypeEdit').val(employee.employeetypeid);				
			var hireDate = employee.hireDate.substr(0,10);
			$('#txtHireDateEdit').val(hireDate);
			$('#ddlJobTitleEdit').val(employee.jobTitleid);			
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(employee, status){
			$('#txtAddressDetail').val(employee.address);
			$('#ddlTitleDetail').val(employee.title);
			$('#txtCityDetail').val(employee.city);
			$('#ddlNationalityDetail').val(employee.countryid);			
			var dob = employee.dateOfBirth.substr(0,10);
			$('#txtDateOfBirthDetail').val(dob);
			$('#txtEmailDetail').val(employee.email);
			$('#txtFirstnameDetail').val(employee.firstName);
			$('#ddlGenderDetail').val(employee.gender);
			$('#txtIdDetail').val(employee.id);
			$('#txtInitialsDetail').val(employee.initials);
			$('#txtLastnameDetail').val(employee.lastName);
			$('#ddlMaritalStatusDetail').val(employee.maritalStatus);
			$('#txtMobileDetail').val(employee.mobile);
			$('#txtOthernameDetail').val(employee.otherName);		
			$('#txtPhoneDetail').val(employee.phone);			
			$('#fupPhotoDetail').val(employee.photo);			
			$('#txtSSNDetail').val(employee.aadharNumber);			
			$('#ddlStateDetail').val(employee.stateid);			
			$('#ddlEmployeeTypeDetail').val(employee.employeetypeid);				
			var hireDate = employee.hireDate.substr(0,10);
			$('#txtHireDateDetail').val(hireDate);
			$('#ddlJobTitleDetail').val(employee.jobTitleid);
			$('#lastModifiedByDetails').val(employee.lastModifiedBy);
			$('#lastModifiedDateDetails').val(employee.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
	
	$('.table #photoButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #employeePhoto').attr('src', href);
		$('#photoModal').modal();		
	});	
	
	$('#uploadButton').on('click',function(event){
		var href = $(this).attr('href');
		
		$.post(href, function(data, status){
			console.log(data);
		});
	});	
});




//function fcnUpload(url){
//	console.log("Upload button was clicked");
//	//var href = $(this).attr('href');
//	var href = url;
//	console.log("End point of upload: " + href);
//	$.post(href, function(data, status){
//		console.log(data);
//	});
//}