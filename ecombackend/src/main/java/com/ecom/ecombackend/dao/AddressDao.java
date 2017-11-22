package com.ecom.ecombackend.dao;

import org.springframework.stereotype.Component;

import com.ecom.ecombackend.modclass.Address;

@Component
public interface AddressDao {

	public Address getAddress(int add_id);

	public boolean addAddress(Address address);

	public boolean deleteAddress(Address address);

	public boolean updateAddress(Address address);

}
