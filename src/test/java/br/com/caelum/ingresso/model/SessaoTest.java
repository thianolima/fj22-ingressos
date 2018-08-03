package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;



public class SessaoTest {

	@Test
	public void oPrecoDaSessaoDeveSerIgualAsomaDoPrecoDaSalaMaisOPrecoDoFilme(){
		Sala sala = new Sala("Eldorado - IMax", new BigDecimal("22.5"));
		Filme filme = new Filme("Rougue One", Duration.ofMinutes(120),"SCIFI", new BigDecimal("12.0"));
		
		BigDecimal somaDasPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());
		
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		
		Assert.assertEquals(somaDasPrecosDaSalaEFilme, sessao.getPreco());
	}
}
