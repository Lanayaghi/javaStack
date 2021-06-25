package com.axsos.driverLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.driverLicense.models.Driver;
import com.axsos.driverLicense.models.License;
import com.axsos.driverLicense.repositories.DriverRepository;
import com.axsos.driverLicense.repositories.LicenseRepository;

@Service
public class LicenseServices  {
	@Autowired
	private LicenseRepository licenseReposit;
	
	public List<License> findAllLicenses(){
		return licenseReposit.findAll();
	}
	
	public License findLicense(Long id) {
		Optional<License> l = licenseReposit.findById(id);
		if (l.isPresent()) {
			return l.get();
		}else {
			return null;
		}
	}
	
	public License createLicense(License l) {
		return licenseReposit.save(l);
		
	}
	public License UpdateLicense(Long id, License l) {
		License license= findLicense(id);
		license.setNumber(l.getNumber());
		license.setState(l.getState());
		license.setExpirationDate(l.getExpirationDate());
		license.setDriver(l.getDriver());
		licenseReposit.save(license);
		return license;
	}
	
	public void delteLicense(Long id) {
		licenseReposit.deleteById(id);
	}

}
