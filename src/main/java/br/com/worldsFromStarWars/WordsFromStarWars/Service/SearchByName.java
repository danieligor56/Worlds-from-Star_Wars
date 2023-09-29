package br.com.worldsFromStarWars.WordsFromStarWars.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.worldsFromStarWars.WordsFromStarWars.Entity.World;
import br.com.worldsFromStarWars.WordsFromStarWars.Exceptions.Exceptions_NOTFOUND;
import br.com.worldsFromStarWars.WordsFromStarWars.Repository.WorldsRepository;

@Service
public class SearchByName {

	@Autowired
	WorldsRepository repository;

	public World searchByName(String nome) {
		
		if(repository.findByNome(nome) == null) {
			throw new Exceptions_NOTFOUND("Não há mundos cadastrados com esse nome.");
		}

		return repository.findByNome(nome);
	}
}
