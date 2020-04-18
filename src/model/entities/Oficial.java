package model.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe [OFICIAL] responsável por conter os atributos de um determinado oficial do Universo [RESIDENT EVIL].
 * @author Vinicius-PC - Vinicius Pascucci.
 */
public class Oficial implements Serializable {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Representa o identificador do departamento.
	 */	
	private Integer id;
	
	/**
	 * Representa o nome do oficial.
	 */	
	private String nome;
	
	/**
	 * Representa o email do oficial.
	 */
	private String email;
	
	/**
	 * Representa o ano do nascimento.
	 */
	private Date nascimento;
	
	/**
	 * Representa a equipe a qual pertence.
	 */
	private String equipe;
	
	/**
	 * Representa a qual departamento pertence
	 */
	private Departamento departamento;
	
	/**
	 * Construtor padrão
	 */
	public Oficial( ) { }

	/**
	 * Construtor com argumentos.
	 * @param id - Integer - id.
	 * @param nome - String - Nome.
	 * @param email - String - email.
	 * @param nascimento - Date - nascimento
	 * @param equipe - String - eqipe.
	 * @param departamento - Departamento - departamento a qual pertence
	 */
	public Oficial(Integer id, String nome, String email, Date nascimento, String equipe, Departamento departamento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.equipe = equipe;
		this.departamento = departamento;
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
	 * @return nome - String - nome do oficial.
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
	 * metodo get().
	 * @return email - String - email do oficial.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * metodo set().
	 * @param email - String - email do oficial.
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * metodo get().
	 * @return nascimento - Date - ano do nascimento.
	 */
	public Date getNascimento() {
		return this.nascimento;
	}

	/**
	 * metodo set().
	 * @param nascimento - Date - ano do nascimento.
	 */
	public void setNascimento(final Date nascimento) {
		this.nascimento = nascimento;
	}

	/**
	 * metodo get().
	 * @return equipe - String - equipe a qual pertence.
	 */
	public String getEquipe() {
		return this.equipe;
	}

	/**
	 * metodo set().
	 * @param equipe - String - equipe a qual pertence.
	 */
	public void setEquipe(final String equipe) {
		this.equipe = equipe;
	}

	/**
	 * metodo get().
	 * @return departamento - Departamento - departamento a qual esse oficial pertence.
	 */
	public Departamento getDepartamento() {
		return this.departamento;
	}

	/**
	 * metodo set().
	 * @param departamento - Departamento - departamento a qual esse oficial pertence.
	 */
	public void setDepartamento(final Departamento departamento) {
		this.departamento = departamento;
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
		Oficial other = (Oficial) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Oficial " + "\n"
				+ "[Identificador: " + id + "\n" 
				+ ", Nome: " + nome + "\n" 
				+ ", Email: " + email + "\n" 
				+ ", Nascimento: " + nascimento + "\n" 
				+ ", Equipe: "+ equipe + "\n" 
				+ ", Departamento: " + departamento + "]";
	}
}
