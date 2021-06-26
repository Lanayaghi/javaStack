package com.example.demo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.lookify.models.Songs;
import com.example.demo.lookify.repositories.LookifyRepository;

@Service
public class LookifyServices {
	@Autowired
	private LookifyRepository lookifyReposit;
	
	public List<Songs> findAllSongs(){
	   return lookifyReposit.findAll();
	}
	
	public Songs findSongById(Long id) {
		Optional<Songs> s = lookifyReposit.findById(id);
		if(s.isPresent()) {
			return s.get();
		}else {
			return null;
		}
	}
	
	public List<Songs> songContainingArtist(String artist){
		return lookifyReposit.findByArtistContaining(artist);
	}
	public Songs createSong(Songs s) {
		return lookifyReposit.save(s);
	}
	
	public Songs upDate(Songs s) {
		return lookifyReposit.save(s);
	}
	
	public List<Songs> topTenByRating(){
		return lookifyReposit.findTopTenByOrderByRateDesc();
		}
	
	public Songs updateSong(Long id, Songs song) {
		Songs song1 = findSongById(id);
		song1.setTitle(song.getTitle());
		song1.setArtist(song.getArtist());
		song1.setRate(song.getRate());
		lookifyReposit.save(song1);
		return song1;
	}
	
	public void deleteSong(Long id) {
		lookifyReposit.deleteById(id);
	}

}
