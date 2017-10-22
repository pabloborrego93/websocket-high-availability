package com.pbg.SocketsDemo.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pbg.SocketsDemo.dao.PeticionDao;
import com.pbg.SocketsDemo.dto.IdPeticion;
import com.pbg.SocketsDemo.dto.Mensaje;
import com.pbg.SocketsDemo.model.Peticion;
import com.pbg.SocketsDemo.service.ServerInfoService;

@RestController
@RequestMapping(value = "/api/peticion")
@CrossOrigin(origins = "*")
public class PeticionController {

	@Autowired
	private PeticionDao peticionDao;
	
	@Autowired
	private ServerInfoService serverInfoService;
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@GetMapping
	public IdPeticion getIdPeticion() {
		String uuid = UUID.randomUUID().toString();
		Peticion peticion = new Peticion(uuid, serverInfoService.getCompleteIP(), new Date());
		peticionDao.save(peticion);
		return new IdPeticion(uuid); 
	}
	
	@GetMapping(value = "/{idPeticion}")
	public void getResponse(@PathVariable String idPeticion) {
		Peticion peticion = peticionDao.findOne(idPeticion);
		if(peticion != null) {
			RestTemplate restTemplate = new RestTemplate();
			String postUrl = new String("http://"+peticion.getNodoIP()+"/api/peticion/reenvio/"+peticion.getIdPeticion());
			Integer numeroAleatorio = (int) (Math.random() * 100);
			System.out.println(postUrl);
			restTemplate.postForEntity(postUrl, new Mensaje(numeroAleatorio.toString()), Mensaje.class);
		}
	}
	
	@PostMapping(value = "/reenvio/{idPeticion}")
	public void sendResponse(@PathVariable String idPeticion, @RequestBody Mensaje mensaje) {
		template.convertAndSend("/channel/"+idPeticion, mensaje);
	}
	
	
}
