package com.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.models.Comprobante;
import com.coderhouse.models.Local;

public interface ComprobanteRepository extends JpaRepository<Comprobante, Long> {}