package vos;


import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class Cliente {
	//----------------------------------------------------------------------------------------------------------------------------------
	// ATRIBUTOS
	//----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Id del cliente
	 */
	@JsonProperty(value="idcliente")
	private Long idcliente;

	/**
	 * Nombre del cliente
	 */
	@JsonProperty(value="nombre")
	private String nombre;

	/**
	 * Vinculo del cliente con la universidad
	 */
	@JsonProperty(value="vinculo")
	private String vinculo;

	/**
	 * Login o nombre de usuario caracterÝstico 
	 */
	@JsonProperty(value="login")
	private String login;

	/**
	 * Contrasenia del cliente
	 */
	@JsonProperty(value="passw")
	private String passw;
	
	/**
	 * Los contratos asociados
	 */
	@JsonProperty(value="idsContratos")
	private ArrayList<Long> idsContratos;

	//----------------------------------------------------------------------------------------------------------------------------------
	// METODO CONSTRUCTOR
	//----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Metodo constructor de la clase Cliente
	 * <b>post: </b> Crea el cliente con los valores que entran por parametro
	 * @param id - Id del cliente.
	 * @param nombre - Nombre del cliente
	 * @param vinculo - El vinculo con la universidad
	 * @param login - El nombre de usuario caracterÝstico
	 * @param passw - La contrasenia de acceso
	 */
	public Cliente(@JsonProperty(value="idcliente")Long id,@JsonProperty(value="nombre")String nombre , @JsonProperty(value="vinculo") String vinculo, @JsonProperty(value="login") String login, @JsonProperty(value="passw") String passw) {
		this.idcliente = id;
		this.nombre = nombre;
		this.vinculo = vinculo;
		this.login = login;
		this.passw = passw;
		idsContratos = new ArrayList<Long>();
	}
	//----------------------------------------------------------------------------------------------------------------------------------
	// METODOS DE LA CLASE
	//----------------------------------------------------------------------------------------------------------------------------------


	public Long getIdcliente() {
		return idcliente;
	}


	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getVinculo() {
		return vinculo;
	}


	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getpassw() {
		return passw;
	}


	public void setpassw(String passw) {
		this.passw = passw;
	}


	public String getPassw() {
		return passw;
	}


	public void setPassw(String passw) {
		this.passw = passw;
	}


	public ArrayList<Long> getIdsContratos() {
		return idsContratos;
	}


	public void setIdsContratos(ArrayList<Long> idsContratos) {
		this.idsContratos = idsContratos;
	}
	
	

}
