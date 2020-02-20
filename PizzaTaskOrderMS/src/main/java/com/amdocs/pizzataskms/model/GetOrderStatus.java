package com.amdocs.pizzataskms.model;

import lombok.Data;

@Data
public class GetOrderStatus {
	private String orderIdNumber;
	private String orderIdStatus;
}
