package com.odontologos.odonto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odontologos.odonto.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {}

