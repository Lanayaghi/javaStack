package com.axsos.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.dojosandninjas.models.Dojos;
import com.axsos.dojosandninjas.models.Ninjas;
import com.axsos.dojosandninjas.rebositories.DojosRepository;
import com.axsos.dojosandninjas.rebositories.NinjasRepository;

@Service
public class DojoNinjaServices {
	private final DojosRepository dojoreposit;
	private final NinjasRepository ninjareposit;
	public DojoNinjaServices(DojosRepository dojoreposit, NinjasRepository ninjareposit) {
		super();
		this.dojoreposit = dojoreposit;
		this.ninjareposit = ninjareposit;
	}
	public List<Dojos> allDojos(){
		return dojoreposit.findAll();
	}
	
	public Dojos createDojo(Dojos d) {
		return dojoreposit.save(d);
	}
	
	public Dojos findDojo(Long id) {
		Optional<Dojos> optionaldojo =  dojoreposit.findById(id);
		if(optionaldojo.isPresent()) {
			return optionaldojo.get();
		}else {
			return null;
		}
		
	}
	public List<Ninjas> allNinjas(){
		return ninjareposit.findAll();
	}
	
	public Ninjas createNinja(Ninjas n) {
		return ninjareposit.save(n);
	}
	
	public Ninjas findNinja(Long id) {
		Optional<Ninjas> optionalNinja =  ninjareposit.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}else {
			return null;
		}
		
	}

}
