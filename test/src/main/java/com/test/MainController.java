package com.test;

import java.text.ParseException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.Models.Cases;
import com.Models.Detalle;
import com.Models.DetalleV;
import com.Models.PaisesV;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(Model model) throws JsonMappingException, JsonProcessingException {
		RestTemplate rest = new RestTemplate();
		Cases Casos = new Cases();
		List<PaisesV> modelo = new ArrayList<PaisesV>();
		// llamar servicio
		ResponseEntity<String> respuesta = rest.getForEntity("https://api.covid19api.com/summary", String.class);
		if (respuesta.getStatusCode() == HttpStatus.OK) {
			// si esta OK extraer data a objeto
			String data = respuesta.getBody();
			ObjectMapper mapper = new ObjectMapper();
			Casos = mapper.readValue(data, Cases.class);

			// mappear objeto a desplegar en vista
			for (int i = 0; i < Casos.Countries.size(); i++) {
				PaisesV nuevo = new PaisesV();
				nuevo.Country = Casos.Countries.get(i).Country;
				nuevo.TotalDeaths = Casos.Countries.get(i).TotalDeaths;
				nuevo.TotalRecovered = Casos.Countries.get(i).TotalRecovered;
				modelo.add(nuevo);
			}
		}

		model.addAttribute("casos", modelo);
		return "main";
	}

	@GetMapping("/detalle")
	public String greeting(@RequestParam(name = "c", required = true, defaultValue = "Chile") String name, Model model)
			throws JsonMappingException, JsonProcessingException, ParseException {
		RestTemplate rest = new RestTemplate();
		List<Detalle> Detail = new ArrayList<Detalle>();
		List<DetalleV> DetailV = new ArrayList<DetalleV>();
		//llamar servicio
		ResponseEntity<String> respuesta = rest.getForEntity("https://api.covid19api.com/country/" + name, String.class);
		if(respuesta.getStatusCode()==HttpStatus.OK){
			//si esta OK extraer data a objeto
			String data = respuesta.getBody();
			ObjectMapper mapper = new ObjectMapper();
			Detail = mapper.readValue(data, new TypeReference<List<Detalle>>(){});
			
			DateTimeFormatter formatter =
    		DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withZone(ZoneId.of("UTC"));
                    //  .withLocale(Locale.US)

			//mappear objeto a desplegar en vista
			for(int i=0;i<Detail.size();i++){
				DetalleV nuevo = new DetalleV();
				nuevo.Confirmed = Detail.get(i).Confirmed;
				nuevo.Deaths = Detail.get(i).Deaths;
				nuevo.Recovered = Detail.get(i).Recovered;
				nuevo.Active = Detail.get(i).Active;
				Instant fecha = Instant.parse(Detail.get(i).Date);
				nuevo.Date = formatter.format(fecha);
				DetailV.add(nuevo);
			}
		}
		model.addAttribute("country", name);
		model.addAttribute("detail", DetailV);
		return "detalle";
	}

}