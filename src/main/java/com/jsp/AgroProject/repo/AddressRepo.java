package com.jsp.AgroProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.AgroProject.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
