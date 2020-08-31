/**
 * 
 */

$('document').ready(function(){
	
	$('table #editButton').on('click', function(event) {
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(location, status) {
			$('#idEdit').val(location.id);
			$('#descriptionEdit').val(location.description);
			$('#detailsEdit').val(location.details);
		});
			
		$('#editModal').modal();
	});
	
	$('table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');	
		
		$.get(href, function(location, status){
			$('#idDetails').val(location.id);
			$('#descriptionDetail').val(location.description);
			$('#detailsDetail').val(location.details);
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