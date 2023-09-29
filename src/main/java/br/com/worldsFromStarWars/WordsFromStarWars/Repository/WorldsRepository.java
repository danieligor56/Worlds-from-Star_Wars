package br.com.worldsFromStarWars.WordsFromStarWars.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.worldsFromStarWars.WordsFromStarWars.Entity.World;

@Repository
public interface WorldsRepository extends JpaRepository<World, Long> {

	
	public World findByNome(String nome);
	
}
