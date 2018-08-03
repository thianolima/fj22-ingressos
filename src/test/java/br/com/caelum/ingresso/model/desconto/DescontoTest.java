package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class DescontoTest {

	private Sala sala;
	private Filme filme;
	private Sessao sessao;
	
	@Before
	public void prepararCenario(){
		sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
		filme = new Filme("Rougue One", Duration.ofMinutes(120),"SCIFI", new BigDecimal("12.0"));
		sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
	}
	
	@Test
	public void naoDeveConcederDescontoParaIngressoNormal(){
		Ingresso ingresso = new Ingresso(sessao, new SemDesconto());
		BigDecimal precoEsperado = new BigDecimal("32.5").setScale(2, RoundingMode.HALF_UP);		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	
	@Test
	public void deveConcederDesconto30PorcentoParaIngressoDeClienteDeBancos(){
		Ingresso ingresso = new Ingresso(sessao, new DescontoParaBancos());
		BigDecimal precoEsperado = new BigDecimal("22.75").setScale(2, RoundingMode.HALF_UP);		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	
	@Test
	public void deveConcederDesconto50PorcentoParaIngressoDeEstudantes(){
		Ingresso ingresso = new Ingresso(sessao, new DescontoParaEstudantes());
		BigDecimal precoEsperado = new BigDecimal("16.25").setScale(2, RoundingMode.HALF_UP);		
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
}
