package rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.AlohAndesTM;
import vos.Alojamiento;
import vos.Promocion;

public class PromocionService 
{

	
	//----------------------------------------------------------------------------------------------------------------------------------
			// ATRIBUTOS
			//----------------------------------------------------------------------------------------------------------------------------------
			
			/**
			 * Atributo que usa la anotacion @Context para tener el ServletContext de la conexion actual.
			 */
			@Context
			private ServletContext context;

			//----------------------------------------------------------------------------------------------------------------------------------
			// METODOS DE INICIALIZACION
			//----------------------------------------------------------------------------------------------------------------------------------
			/**
			 * Metodo que retorna el path de la carpeta WEB-INF/ConnectionData en el deploy actual dentro del servidor.
			 * @return path de la carpeta WEB-INF/ConnectionData en el deploy actual.
			 */
			private String getPath() {
				return context.getRealPath("WEB-INF/ConnectionData");
			}


			private String doErrorMessage(Exception e){
				return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
			}

			//----------------------------------------------------------------------------------------------------------------------------------
			// METODOS REST
			//----------------------------------------------------------------------------------------------------------------------------------

			/**
			 * Metodo GET que trae a todos los alojamientos en la Base de datos. <br/>
			 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
			 * <b>URL: </b> http://localhost:8080/TutorialParranderos/rest/bebedores <br/>
			 * @return	<b>Response Status 200</b> - JSON que contiene a todos los bebedores que estan en la Base de Datos <br/>
			 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
			 */			
			@GET
			@Produces({ MediaType.APPLICATION_JSON })
			public Response getPromociones() {
				
				try {
					AlohAndesTM tm = new AlohAndesTM(getPath());
					
					List<Promocion> promociones;
					
					promociones = tm.getAllPromociones();
					return Response.status(200).entity(promociones).build();
				} 
				catch (Exception e) {
					return Response.status(500).entity(doErrorMessage(e)).build();
				}
			}

			/**
			 * Metodo GET que trae al bebedor en la Base de Datos con el ID dado por parametro <br/>
			 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
			 * <b>URL: </b> http://localhost:8080/TutorialParranderos/rest/bebedores/{id} <br/>
			 * @return	<b>Response Status 200</b> - JSON Bebedor que contiene al bebedor cuyo ID corresponda al parametro <br/>
			 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
			 */
			@GET
			@Path( "{id: \\d+}" )
			@Produces( { MediaType.APPLICATION_JSON } )
			public Response getPromocionById( @PathParam( "id" ) Long id )
			{
				try{
					AlohAndesTM tm = new AlohAndesTM( getPath( ) );
					
					Promocion promocion = tm.getPromocionById( id );
					return Response.status( 200 ).entity( promocion ).build( );			
				}
				catch( Exception e )
				{
					return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
				}
			}
			
			/**
			 * Método que agrega un Alojamiento a AlohAndes
			 * <b>Precondicion: </b> El archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
			 * <b>Postcondicion: </b> Se agrega a la Base de datos la informacion correspondiente al bebedor. <br/>
			 * <b>URL: </b> http://localhost:8080/AlohAndes/rest/alojamiento <br/>
			 * @param Alojamiento, información del Alojamiento.
			 * @return <b>Response Status 200</b> - JSON que contiene al bebedor que ha sido agregado <br/>
			 * 		   <b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
			 */
			@POST
			@Consumes({ MediaType.APPLICATION_JSON })
			@Produces({ MediaType.APPLICATION_JSON })
			public Response createPromocion(Promocion promocion) {
				AlohAndesTM tm = new AlohAndesTM(getPath());
				try {
					Promocion res = tm.createPromocion(promocion);
					return Response.status( 200 ).entity( res ).build();	
				}catch( Exception e )
				{
					return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
				}
			}
			
			
			/**
			 * Metodo que recibe un bebedor en formato JSON y lo agrega a la Base de Datos <br/>
			 * <b>Precondicion: </b> El archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
			 * <b>Postcondicion: </b> Se actualiza la Base de datos con la informacion correspondiente al bebedor.<br/>
			 * @param bebedor JSON con la informacion del bebedor que se desea agregar
			 * @return	<b>Response Status 200</b> - JSON que contiene al bebedor que se desea modificar <br/>
			 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
			 */
			
			@POST
			@DELETE
			@Consumes({ MediaType.APPLICATION_JSON})
			@Produces({ MediaType.APPLICATION_JSON})
			public Response updatePromocion(Promocion promocion)
			{
				AlohAndesTM tm = new AlohAndesTM(getPath());
				try {
					Promocion res = tm.updatePromocion(promocion);
					return Response.status( 200 ).entity( res ).build();	
				}catch( Exception e )
				{
					return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
				}
			}
			

			/**
			 * Metodo que recibe un bebedor en formato JSON y lo elimina de la Base de Datos <br/>
			 * <b>Precondicion: </b> El archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
			 * <b>Postcondicion: </b> Se elimina de la Base de datos al bebedor con la informacion correspondiente.<br/>
			 * <b>URL: </b> http://localhost:8080/TutorialParranderos/rest/bebedores <br/>
			 * @param bebedor JSON con la informacion del bebedor que se desea eliminar
			 * @return	<b>Response Status 200</b> - JSON que contiene al bebedor que se desea eliminar <br/>
			 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
			 */
			
			@DELETE
			@Path("{IdPromocion: \\d+}")
			@Produces( { MediaType.APPLICATION_JSON } )
			public Response borrarPromocion(@PathParam("IdPromocion") int idPromocion)
			{
				AlohAndesTM tm = new AlohAndesTM(getPath());
				try {
					tm.deletePromocion(idPromocion);
					return Response.status( 200 ).entity( null ).build( );		
				}catch( Exception e )
				{
					return Response.status( 412 ).entity( doErrorMessage( e ) ).build( );
				}
			}
		
		
	
}
