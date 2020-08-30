/**
 * 
 */

$('document').ready(function(){
	
	$('table #editButton').on('click', function(event) {
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(location, status) {
			$('#idEdit').val(location.id);
			$('#ddlCountryEdit').val(location.countryid);
			$('#ddlStateEdit').val(location.stateid);
			$('#descriptionEdit').val(location.description);
			$('#cityEdit').val(location.city);
			$('#detailsEdit').val(location.details);
			$('#addressEdit').val(location.address);
		});
			
		$('#editModal').modal();
	});
	
	$('table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');	
		
		$.get(href, function(location, status){
			$('#idDetails').val(location.id);
			$('#ddlCountryDetail').val(location.countryid);			
			$('#ddlStateDetail').val(location.stateid);
			$('#descriptionDetail').val(location.description);
			$('#cityDetail').val(location.city);
			$('#detailsDetail').val(location.details);
			$('#addressDetail').val(location.address);
			$('#lastModifiedByDetails').val(location.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(location.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});
	
	$('table #deleteButton').on('click', function(event) {
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		//after clicking delete model will be called and delete button 
		// href will be set.
		$('#confirmDeleteButton').attr('href', href);
		
		$('#deleteModal').modal();
	});
	
});