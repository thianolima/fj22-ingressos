package br.com.caelum.ingresso.validacao;

import java.time.LocalTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {

	private List<Sessao> sessaoDaSala;
	
	public GerenciadorDeSessao(List<Sessao> sessaoDaSala){
		this.sessaoDaSala = sessaoDaSala;
	}
	
	private boolean horarioIsConflitantes(Sessao sessaoExistente, Sessao sessaoNova){		
		
		LocalTime horaSessaoExistente = sessaoExistente.getHorario();
		LocalTime horaSessaoNova = sessaoNova.getHorario();		
	
		boolean antes = horaSessaoNova.isBefore(horaSessaoExistente);
		
		
		if (antes){
			return sessaoNova.getHorarioTermino().isAfter(horaSessaoExistente);
			
		} else {
			return sessaoExistente.getHorarioTermino().isAfter(horaSessaoNova);
		}
		
	}
	
	public boolean cabe (Sessao sessaoNova){
		return sessaoDaSala.stream().noneMatch(sessaoExistente -> horarioIsConflitantes(sessaoExistente, sessaoNova));
	}
}
