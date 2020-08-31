/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(contact, status){
			$('#txtEmailEdit').val(contact.email);
			$('#txtFirstnameEdit').val(contact.firstName);
			$('#txtIdEdit').val(contact.id);
			$('#txtLastnameEdit').val(contact.lastName);	
			$('#txtMobileEdit').val(contact.mobile);
			$('#txtPhoneEdit').val(contact.phone);			
			$('#txtRemarksEdit').val(contact.remarks);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(contact, status){
			$('#txtEmailDetail').val(contact.email);
			$('#txtFirstnameDetail').val(contact.firstName);
			$('#txtIdDetail').val(contact.id);
			$('#txtLastnameDetail').val(contact.lastName);	
			$('#txtMobileDetail').val(contact.mobile);
			$('#txtPhoneDetail').val(contact.phone);			
			$('#txtRemarksDetail').val(contact.remarks);
			$('#lastModifiedByDetails').val(contact.lastModifiedBy);
			$('#lastModifiedDateDetails').val(contact.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});