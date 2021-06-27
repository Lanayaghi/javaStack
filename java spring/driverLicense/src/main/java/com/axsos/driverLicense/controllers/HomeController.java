package com.axsos.driverLicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.driverLicense.models.Driver;
import com.axsos.driverLicense.models.License;
import com.axsos.driverLicense.services.DriverServices;
import com.axsos.driverLicense.services.LicenseServices;

@Controller
public class HomeController {
	@Autowired
	private DriverServices driverService;
	@Autowired LicenseServices licenseservice;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Driver> driver = driverService.findAllDrivers();
		model.addAttribute("drivers", driver);
		return"index.jsp";
	}
	
	@GetMapping("/driver/{id}")
	public String showDriver(@PathVariable Long id, Model model) {
		Driver driver = driverService.findDriver(id);
		model.addAttribute("driver",driver);
		return "showDriver.jsp";
	}
	@GetMapping("/driver/new")
	public String newDriverForm(@ModelAttribute("driver") Driver driver) {
		return "newDriver.jsp";
	}
	
	@PostMapping("/driver/new")
	public String newDriver(@Valid @ModelAttribute("driver") Driver driver, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/driver/new";
		}else {
			driverService.createDriver(driver);
			return "redirect:/driver/"+ driver.getId();
		}
	}
	
	@GetMapping("/license/new")
	public String newLicenseForm(@ModelAttribute("license") License license,Model model) {
		List<Driver> driver = driverService.findAllDrivers();
		model.addAttribute("drivers", driver);
		return"newLicense.jsp";
	}
	
	@PostMapping("/license/new")
	public String newLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/license/new";
		}else {
			license.setNumber(String.format("%05d", license.getDriver().getId()));
			licenseservice.createLicense(license);
			return "redirect:/driver/"+ license.getDriver().getId();
		}
	}

}
