package br.edu.infnet.eder.exceptions;

import br.edu.infnet.eder.Constantes;

public class LivroNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public LivroNaoEncontradoException() {
		super(Constantes.MSG_LIVRO_NOT_FOUND);
	}
}