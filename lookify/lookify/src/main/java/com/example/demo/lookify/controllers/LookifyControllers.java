package com.example.demo.lookify.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.lookify.models.Songs;

import com.example.demo.lookify.services.LookifyServices;

@Controller
public class LookifyControllers {
	
	@Autowired
	private LookifyServices lookifyService;
	
   @RequestMapping("/")
   public String index() {
	   return "index.jsp";
   }
   
   @RequestMapping("/dashboard")
   public String allSongs(Model model ) {
	   List <Songs> songs = lookifyService.findAllSongs();
	   model.addAttribute("songs",songs);
	   return "dashboard.jsp";
   }
   
   @RequestMapping("/songs/search")
   public String search(@RequestParam("artist")String artist, Model model) {
	   model.addAttribute("songs", lookifyService.songContainingArtist(artist));
	   model.addAttribute("artist",artist);
	   return "searched.jsp";
   }
   @GetMapping("/songs/{id}")
   public String showSong(@PathVariable Long id, Model model ) {
	   Songs song = lookifyService.findSongById(id);
	   model.addAttribute("song", song);
	   return "showSongDetails.jsp";
   }
   
   @RequestMapping("/Search/topten")
   public String TopTen(Model model) {
	   model.addAttribute("songs", lookifyService.topTenByRating());
	   return "topTen.jsp";
   }
   @GetMapping("/songs/new")
   public String songAddingPage(@ModelAttribute ("song") Songs song) {
	   return "addSong.jsp";
   }
   
   @PostMapping("/songs/new")
   public String addSong(@Valid @ModelAttribute("song") Songs song, BindingResult result) {
	   if(result.hasErrors()) {
		   return"addSong.jsp";
		   
	   }else {
		   lookifyService.createSong(song);
	   }
	   return "redirect:/dashboard";
   }


   
}
