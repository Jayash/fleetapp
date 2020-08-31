package com.project.fleetapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceDto {
	
	private Long id;
	private String invoiceDate;
	private String remarks;
	private Long invoicestatusid;
	private Long clientid;
}
