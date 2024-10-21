package br.edu.infnet.eder.client;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.eder.model.domain.Estado;
import br.edu.infnet.eder.model.domain.Municipio;

@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", name = "ibge")
public interface LocalidadeClient {
	
	@GetMapping(value = "/estados")
	Collection<Estado> obterEstados();
	
	
	@GetMapping(value = "/estados/{id}/municipios")
	Collection<Municipio> obterMunicipios(@PathVariable Integer id);
}
