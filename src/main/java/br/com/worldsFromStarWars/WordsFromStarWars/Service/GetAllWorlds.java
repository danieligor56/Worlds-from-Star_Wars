package br.com.worldsFromStarWars.WordsFromStarWars.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.worldsFromStarWars.WordsFromStarWars.Entity.World;
import br.com.worldsFromStarWars.WordsFromStarWars.Exceptions.Exceptions_NOTFOUND;
import br.com.worldsFromStarWars.WordsFromStarWars.Repository.WorldsRepository;

@Service
public class GetAllWorlds {

	@Autowired
	WorldsRepository repository;
	
	public List<World> listAllWrds(){
		List<World> verifyList = repository.findAll();
		if(verifyList.isEmpty()) {
			throw new Exceptions_NOTFOUND("Não há mundos cadastrados ! ");
		}
		else{
		
			return repository.findAll();
		}
	}


}
