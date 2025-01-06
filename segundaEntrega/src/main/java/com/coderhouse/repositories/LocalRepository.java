package com.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coderhouse.models.Local;

public interface LocalRepository extends JpaRepository<Local, Long> {}