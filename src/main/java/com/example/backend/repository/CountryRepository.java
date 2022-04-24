package com.example.backend.repository;

import com.example.backend.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository  extends JpaRepository<Country,Long> {
}
