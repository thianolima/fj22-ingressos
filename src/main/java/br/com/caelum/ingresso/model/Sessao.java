package br.com.caelum.ingresso.model;

import java.time.LocalTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Sessao {

	@Id
	@GeneratedValue
	private Integer id;
	private LocalTime horario;
	private Sala sala;
	private Filme filme;
	
	/*
	 * @@deprecated onli hibernate
	 */
	public Sessao(){
		
	}
	
	public Sessao(Integer id, LocalTime horario, Filme filme){
		this.id = id;
		this.horario = horario;
		this.filme = filme;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalTime getHorario() {
		return horario;
	}
	
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	public Sala getSala() {
		return sala;
	}
	
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public Filme getFilme() {
		return filme;
	}
	
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	public LocalTime getHorarioTermino(){
		return this.horario.plusMinutes(filme.getDuracao().toMinutes());
	}
	
	
}
