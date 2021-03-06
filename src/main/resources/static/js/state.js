/**
 * 
 */

$('document').ready(function(){
	
	$('table #editButton').on('click', function(event) {
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		//
		$.get(href, function(state, status) {
			$('#idEdit').val(state.id);
			$('#ddlCountryEdit').val(state.countryid);
			$('#nameEdit').val(state.name);
			$('#codeEdit').val(state.code);
			$('#capitalEdit').val(state.capital);
			$('#detailsEdit').val(state.details);
		});
			
		$('#editModal').modal();
	});
	
	$('table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(state, status){
			$('#idDetails').val(state.id);
			$('#ddlCountryDetails').val(state.countryid);			
			$('#nameDetails').val(state.name);
			$('#detailsDetails').val(state.details);
			$('#codeDetails').val(state.code);
			$('#capitalDetails').val(state.capital);
			$('#lastModifiedByDetails').val(state.lastModifiedBy);
			$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});
	
	$('table #deleteButton').on('click', function(event) {
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		//after clicking delete model will be called and delete button href
		// will be set.
		$('#confirmDeleteButton').attr('href', href);
		
		$('#deleteModal').modal();
	});
	
});