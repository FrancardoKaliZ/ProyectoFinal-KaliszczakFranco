package com.coderhouse.dtos;

import java.util.List;

public class entrarDTO {

	private Long clienteId;
	
	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public List<Long> getLocalesIds() {
		return localesIds;
	}

	public void setLocalesIds(List<Long> localesIds) {
		this.localesIds = localesIds;
	}

	private List<Long> localesIds;
}

