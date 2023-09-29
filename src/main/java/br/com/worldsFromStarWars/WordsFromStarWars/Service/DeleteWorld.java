package br.com.worldsFromStarWars.WordsFromStarWars.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.worldsFromStarWars.WordsFromStarWars.Entity.World;
import br.com.worldsFromStarWars.WordsFromStarWars.Repository.WorldsRepository;

@Service
public class DeleteWorld {
@Autowired
WorldsRepository rep;
public World deleteWorld(Long id){
	
	try {
		rep.deleteById(id);
	} catch (Exception e) {
		System.out.println("World not founded: "+e);
	}
		 return null;

	}		
}
