package br.com.worldsFromStarWars.WordsFromStarWars.Config;

import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
@Configuration
public class StartModelMapper {

	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
