package com.coderhouse.dtos;

import java.util.List;

public class asignarProductosDTO {

	private Long localId;
	
	public Long getLocalId() {
		return localId;
	}

	public void setLocalId(Long LocalId) {
		this.localId = LocalId;
	}

	public List<Long> getProductosIds() {
		return productosIds;
	}

	public void setproductosIds(List<Long> productosIds) {
		this.productosIds = productosIds;
	}

	private List<Long> productosIds;
}

