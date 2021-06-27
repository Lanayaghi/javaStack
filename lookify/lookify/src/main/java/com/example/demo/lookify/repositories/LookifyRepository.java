package com.example.demo.lookify.repositories;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.lookify.models.Songs;

@Repository
public interface LookifyRepository extends CrudRepository<Songs, Long>{
	List<Songs> findAll();
	List<Songs> findTop10ByOrderByRateDesc();
	List<Songs> findByArtistContaining(String artist);
	


}
