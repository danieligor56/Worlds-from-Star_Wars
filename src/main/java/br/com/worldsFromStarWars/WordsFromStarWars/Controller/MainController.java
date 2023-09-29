package br.com.worldsFromStarWars.WordsFromStarWars.Controller;

import java.net.URI;
import java.util.List;

import org.hibernate.result.NoMoreReturnsException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.sym.Name;

import br.com.worldsFromStarWars.WordsFromStarWars.DTO.WorldDTO;
import br.com.worldsFromStarWars.WordsFromStarWars.Entity.World;
import br.com.worldsFromStarWars.WordsFromStarWars.Exceptions.Exceptions_BADREQUEST;
import br.com.worldsFromStarWars.WordsFromStarWars.Exceptions.Exceptions_NOTFOUND;
import br.com.worldsFromStarWars.WordsFromStarWars.Service.AddNewWorld;
import br.com.worldsFromStarWars.WordsFromStarWars.Service.DeleteWorld;
import br.com.worldsFromStarWars.WordsFromStarWars.Service.GetAllWorlds;
import br.com.worldsFromStarWars.WordsFromStarWars.Service.SearchByID;
import br.com.worldsFromStarWars.WordsFromStarWars.Service.SearchByName;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Tag(name = "WORLDS FROM STAR WARS")
@RestController
@RequestMapping("/api/v1/worlds")
public class MainController {

	@Autowired
	ModelMapper modelMapper;

	// FUNÇÕES:
	// Adicionar novo planeta com (Nome,Clima,Terreno) OK.
	@Autowired
	AddNewWorld newWorld;
	// -----------------------------------
	// Implementação ok.
	@Autowired
	SearchByID searchByID;

	// -----------------------------------
	@Autowired
	SearchByName findName;

	// -----------------------------------
	// IMPLENTAÇÃO OK. FALTANDO EXCEPTIONS
	@Autowired
	DeleteWorld deleteThing;

	// -----------------------------------
	// IMPLEMENTAÇÃO OK.
	@Autowired
	GetAllWorlds getAllWorlds;

	@Operation(summary = "ListAll", description = "List all worlds inserted ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Todos os mundos foram listados com sucesso.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = World.class)) }),
			@ApiResponse(responseCode = "404", description = "Não há mundos cadastrados", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Exceptions_NOTFOUND.class)) }) })
	@GetMapping("{listAll}")
	public ResponseEntity<List> listAllWrd() {
		return ResponseEntity.ok().body(getAllWorlds.listAllWrds());
	}

	@Operation(summary = "Search by ID", description = "Finds the world by ID")
	@GetMapping("/worlds/{id}")
	public ResponseEntity<World> searchID(@PathVariable Long id) {
		return ResponseEntity.ok().body(searchByID.searchByID(id));
	}

	@Operation(summary = "Search by name", description = "Finds the world by name...")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Todos os mundos foram listados com sucesso.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = World.class)) }),
			@ApiResponse(responseCode = "404", description = "Insira um nome !", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Exceptions_NOTFOUND.class)) }) })
	@GetMapping("/nome=/{nome}")
	public ResponseEntity<World> searchName(@PathVariable String nome) {

		return ResponseEntity.ok().body(findName.searchByName(nome));

	}

	@Operation(summary = "InsertNewWorld", description = "add new world...")
	@CrossOrigin(allowedHeaders = "http://localhost:8080")
	@PostMapping
	public ResponseEntity<World> insertNewWorld(@RequestBody WorldDTO neoWorld) {
		World world = newWorld.addNewWorld(neoWorld);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(world.getID())
				.toUri();

		return ResponseEntity.created(location).body(world);

	}

	@Operation(summary = "Delete world", description = "Delete world by id")
	@DeleteMapping("/worlds/{id}")
	public ResponseEntity<World> deleteWorld(@PathVariable Long id) {
		return ResponseEntity.ok().body(deleteThing.deleteWorld(id));
	}
}
