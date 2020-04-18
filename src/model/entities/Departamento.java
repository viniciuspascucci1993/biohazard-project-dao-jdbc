package model.entities;

import java.io.Serializable;

/**
 * Classe [DEPARTAMENTO] responsável por conter os atributos de um departamento do Universo [RESIDENT EVIL].
 * @author Vinicius-PC - Vinicius Pascucci.
 */
public class Departamento implements Serializable {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Representa o identificador do departamento.
	 */
	private Integer id;
	
	/**
	 * Representa o nome do departamento.
	 */
	private String nome;
	
	/**
	 * Construtor padrão
	 */
	public Departamento( ) { }

	/**
	 * Construtor com argumentos.
	 * @param id - Integer - id.
	 * @param nome - String - nome.
	 */
	public Departamento(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	/**
	 * metodo get().
	 * @return id - Integer - id.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * metodo set().
	 * @param id - Integer - id.
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Metodo get().
	 * @return nome - String - nome.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * metodo set().
	 * @param nome - String - nome.
	 */
	public void setNome(final String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo hashCode (Comparar objetos por valor)
	 * Faz uma comparação entre o id
	 */	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	
	/**
	 * Metodo equals (Comparar objetos por valor)
	 * Faz uma comparação entre o id
	 */		
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * Metodo toString para ter uma facilidade com os objetos na hora que estiver testando.
	 */
	@Override
	public String toString() {
		return "Departamento "
				+ "[Identificador:" + id 
				+ ", Nome:" + nome + "]";
	}
}
