package com.example.demo.controller;
import com.mashape.unirest.http.HttpResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.interfaces.IpersonaService;
import com.example.demo.modelo.Persona;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
@RequestMapping
public class PersonaController {
	@Autowired
	private IpersonaService service;

	@GetMapping("/")
	public String index(Model model, String term) {
		//long totalPersonas = service.contador();
		//model.addAttribute("totalPersonas", totalPersonas);
		return "adminlte_templates/home";
	}

	@GetMapping("/creaper")
	public String greeting() {
		Persona p = new Persona();
		p.setPersonaNombre1("ANDRES");
		p.setPersonaNombre2("JOSE");
		p.setPersonaApellido1("BERMUDEZ");
		p.setPersonaApellido2("SALAZAR");
		LocalDateTime datetime = LocalDateTime.now();
		p.setPersonaFechaCreacion(datetime);
		p.setPersonaTelefono("321527788");
		p.setPersonaIdentificacion("7978787878");
		p.setPersonaTipoIdentificacion("CC");
		service.save(p);
		return "adminlte_templates/home";
	}
	

	@GetMapping("/login2")
	public String  getLogin() {
	System.out.println("llego....");
	Unirest.setTimeouts(0, 0);
	try {
		HttpResponse<String> response = Unirest.post("http://172.16.37.10:8280/services/px_LoginWebappsinencrip")
		  .header("Authorization", "Bearer 16f1b1fdd5963c242ecb3ad89faa434")
		  .header("Content-Type", "application/json")
		  .body("{\n    \"usuario\": \"orlin.carrillo\",\n    \"contrasena\": \"Danisaloynico3..\"\n}")
		  .asString();
		System.out.println("llego...."+response.getBody());
		
		System.out.println("xxxxxx");
	} catch (UnirestException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return "adminlte_templates/home";
		
	}

	 
	
	
	@GetMapping("/buscar")
	public String listar(Model model, String term) {
		List<Persona>personas=service.listar(term);
		model.addAttribute("personas",personas);
		return "personas/index";
	}

	@GetMapping(value = "/buscar-persona-por-identificacion/{term}", produces = "application/json")
	public @ResponseBody List<Persona> personas(@PathVariable String term){
		return service.listar(term);

	}

	@GetMapping("/crear")
	public String agregar(Model model) {
		model.addAttribute("persona",new Persona());
		model.addAttribute("new_edit","nuevo");
		model.addAttribute("habilita","enabled");
		return "personas/create";
	}

	@GetMapping("/editar/{personaCodigo}")
	public String editar(@PathVariable Long personaCodigo ,Model model) {
		java.util.Optional<Persona>persona=service.listarId(personaCodigo);
		System.out.println("este es el codigo: "+persona.get().getPersonaCodigo());
		model.addAttribute("persona",persona);

		return "personas/create";
	}


	@PostMapping("/save")
	public String save(@Valid Persona p, Model model,@RequestParam("arlArchivoImagen") MultipartFile imagen_arl,@RequestParam("epsArchivoImagen") MultipartFile imagen_eps,
			RedirectAttributes mensaje) {


		if(!imagen_arl.isEmpty()) {
			Path directorioImagenesArl = Paths.get("src//main//resources//static/arl");
			String rutaAbsolutaArl = directorioImagenesArl.toFile().getAbsolutePath();
			System.out.println("RUTA ABSOLUTA:"+rutaAbsolutaArl);

		try {

			byte[] byteImgArl = imagen_arl.getBytes();
			Path rutaCompleta = Paths.get(directorioImagenesArl + "//" + imagen_arl.getOriginalFilename());
			Files.write(rutaCompleta,byteImgArl);

			p.setPersonaArlArchivo(imagen_arl.getOriginalFilename());
			//p.setPersona_arl_ruta(directorioImagenesArl.toString()); asi graba src/main/resources/static/arl
			p.setPersonaArlRuta("arl");
		}catch(IOException e){
			e.printStackTrace();
		}
		}


		if(!imagen_eps.isEmpty()) {
			Path directorioImagenesEps = Paths.get("src//main//resources//static/eps");
			String rutaAbsolutaEps = directorioImagenesEps.toFile().getAbsolutePath();
			System.out.println("RUTA ABSOLUTA:"+rutaAbsolutaEps);

		try {

			byte[] byteImgEps = imagen_eps.getBytes();
			Path rutaCompletaEps = Paths.get(directorioImagenesEps + "//" + imagen_eps.getOriginalFilename());
			Files.write(rutaCompletaEps,byteImgEps);
			p.setPersonaEpsArchivo(imagen_eps.getOriginalFilename());
			p.setPersonaEpsRuta("eps");

			//p.setPersona_arl_ruta(directorioImagenesArl.toString()); asi graba src/main/resources/static/arl


		}catch(IOException e){
			e.printStackTrace();
		}
		}

		service.save(p);
		Long personaCodigo=p.getPersonaCodigo();
		mensaje.addFlashAttribute("guardar","guardar");
		return "redirect:/editar/"+personaCodigo ;
	}


	

	@GetMapping("/eliminar/{personaCodigo}")
	public String delete(Model model,@PathVariable Long personaCodigo) {
		service.delete(personaCodigo);
		return "redirect:/personas/listar";
	}

	@GetMapping("/imagen/{personaCodigo}")
	public String imagen(@PathVariable Long personaCodigo ,Model model) {
		java.util.Optional<Persona>persona=service.listarId(personaCodigo);
		model.addAttribute("persona",persona);
		return "imagen";
	}


}
