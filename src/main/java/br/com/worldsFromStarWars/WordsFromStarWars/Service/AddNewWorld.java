package br.com.worldsFromStarWars.WordsFromStarWars.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.worldsFromStarWars.WordsFromStarWars.DTO.WorldDTO;
import br.com.worldsFromStarWars.WordsFromStarWars.Entity.World;
import br.com.worldsFromStarWars.WordsFromStarWars.Repository.WorldsRepository;

@Service

public class AddNewWorld {

	@Autowired
	WorldsRepository rep;
	
	@Autowired
	ModelMapper modelMapper;
	
	public World addNewWorld(WorldDTO neoWorld) {
		//boolean exists = rep.findByNome(neoWorld.getNome());
		
		////if (exists) {
			//throw  new Exceptions_BADREQUEST("Atenção, mundo já cadastrado previamente ! ");
	//}
		
		World world = modelMapper.map(neoWorld,World.class);
				
				 
		
		return rep.save(world);
	}
}
