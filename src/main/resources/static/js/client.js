/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');

		$.get(href, function(client, status){
			$('#txtIdEdit').val(client.id);
			$('#txtAddressEdit').val(client.address);
			$('#txtCityEdit').val(client.city);
			$('#ddlCountryEdit').val(client.countryid);
			$('#txtDetailsEdit').val(client.details);
			$('#txtEmailEdit').val(client.email);
			$('#txtMobileEdit').val(client.mobile);
			$('#txtNameEdit').val(client.name);	
			$('#txtPhoneEdit').val(client.phone);			
			$('#ddlStateEdit').val(client.stateid);	
			$('#txtWebsiteEdit').val(client.website);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(client, status){
			$('#txtIdDetail').val(client.id);
			$('#txtAddressDetail').val(client.address);
			$('#txtCityDetail').val(client.city);
			$('#ddlCountryDetail').val(client.countryid);
			$('#txtDetailsDetail').val(client.details);
			$('#txtEmailDetail').val(client.email);
			$('#txtMobileDetail').val(client.mobile);
			$('#txtNameDetail').val(client.name);	
			$('#txtPhoneDetail').val(client.phone);			
			$('#ddlStateDetail').val(client.stateid);	
			$('#txtWebsiteDetail').val(client.website);
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
			$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
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