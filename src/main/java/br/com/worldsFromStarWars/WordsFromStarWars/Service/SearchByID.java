package br.com.worldsFromStarWars.WordsFromStarWars.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.worldsFromStarWars.WordsFromStarWars.Entity.World;
import br.com.worldsFromStarWars.WordsFromStarWars.Exceptions.Exceptions_NOTFOUND;
import br.com.worldsFromStarWars.WordsFromStarWars.Repository.WorldsRepository;

@Service
public class SearchByID {
	
	@Autowired
	WorldsRepository rep;
	
	public World searchByID(long id) {
	return rep.findById(id)
			.orElseThrow(()-> new Exceptions_NOTFOUND("Mundo não encontrado..."));
		
	}

}
