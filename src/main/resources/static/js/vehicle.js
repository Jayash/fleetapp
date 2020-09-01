/**
 * 
 */

$('document').ready(function() {	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicle, status){
			var acDate = vehicle.acquisationDate.substr(0,10);
			$('#txtAcquisitionDateEdit').val(acDate);
			$('#txtDescriptionEdit').val(vehicle.description);
			$('#ddlEmployeeEdit').val(vehicle.employeeid);
			$('#txtFuelCapacityEdit').val(vehicle.fuelCapacity);
			$('#txtIdEdit').val(vehicle.id);
			$('#ddlLocationEdit').val(vehicle.locationid);
			$('#txtNameEdit').val(vehicle.name);
			$('#txtNetWeightEdit').val(vehicle.netWeight);
			$('#txtPowerEdit').val(vehicle.power);
			var regDate = vehicle.registrationDate.substr(0,10);
			$('#txtRegistrationDateEdit').val(regDate);
			$('#txtRemarksEdit').val(vehicle.remarks);
			$('#ddlVehicleMakeEdit').val(vehicle.vehicleMakeid);		
			$('#ddlVehicleModelEdit').val(vehicle.vehicleModelid);			
			$('#txtVehicleNumberEdit').val(vehicle.vehicleNumber);			
			$('#ddlVehicleStatusEdit').val(vehicle.vehicleStatueid);			
			$('#ddlVehicleTypeEdit').val(vehicle.vehicleTypeid);	
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');
		$.get(href, function(vehicle, status){
			var acDate = vehicle.acquisationDate.substr(0,10);
			$('#txtAcquisitionDateDetail').val(acDate);
			$('#txtDescriptionDetail').val(vehicle.description);
			$('#ddlEmployeeDetail').val(vehicle.employeeid);
			$('#txtFuelCapacityDetail').val(vehicle.fuelCapacity);
			$('#txtIdDetail').val(vehicle.id);
			$('#ddlLocationDetail').val(vehicle.locationid);
			$('#txtNameDetail').val(vehicle.name);
			$('#txtNetWeightDetail').val(vehicle.netWeight);
			$('#txtPowerDetail').val(vehicle.power);
			var regDate = vehicle.registrationDate.substr(0,10);
			$('#txtRegistrationDateDetail').val(regDate);
			$('#txtRemarksDetail').val(vehicle.remarks);
			$('#ddlVehicleMakeDetail').val(vehicle.vehicleMakeid);		
			$('#ddlVehicleModelDetail').val(vehicle.vehicleModelid);			
			$('#txtVehicleNumberDetail').val(vehicle.vehicleNumber);			
			$('#ddlVehicleStatusDetail').val(vehicle.vehicleStatueid);			
			$('#ddlVehicleTypeDetail').val(vehicle.vehicleTypeid);
			$('#lastModifiedByDetails').val(vehicle.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicle.lastModifiedDate.substr(0,19).replace("T", " "));
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
		$('#photoModal #vehiclePhoto').attr('src', href);
		$('#photoModal').modal();		
	});	
});