package com.toll.managemnt.sysem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toll.managemnt.sysem.models.TollPlaza;
import com.toll.managemnt.sysem.repositories.TollPlazaRepository;

@Service
public class TollPlazaService {
	  @Autowired
	    private TollPlazaRepository tollPlazaRepository;

	    public TollPlaza addTollPlaza(TollPlaza tollPlaza) {
	        return tollPlazaRepository.save(tollPlaza);
	    }
	    
	    public List<TollPlaza> getAllTollPlazas() {
	        return tollPlazaRepository.findAll();
	    }

}
