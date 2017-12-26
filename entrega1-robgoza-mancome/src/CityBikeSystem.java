
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fabricante.externo.tarjetas.TarjetaMonedero;

/**
 * Implementacion de la clase que modeliza un sistema de gestion de puntos de
 * aparcamientos de bici asi como el prestamo de las mismas
 * 
 * @author robgoza
 * @author mancome
 *
 */
public class CityBikeSystem {
	private static String id;
	private ArrayList<CityBikeParkingPoint> aparcamientos;
	private double fianza;
	private String ciudad;

	/**
	 * Constructor de la clase CityBikeSystem
	 * 
	 * @param fianza
	 *            la fianza que se va a imponer
	 * @param ciudad
	 *            la ciudad en la que se va a implementar el sistema
	 */
	public CityBikeSystem(double fianza, String ciudad) {
		assert fianza >= 0;
		this.id=generarId();
		this.fianza = fianza;
		this.ciudad = ciudad;
		this.aparcamientos = new ArrayList<CityBikeParkingPoint>();
	}
	/**
	 * Procedimiento que genera un identificador para cada sistema
	 * 
	 * @return El identificador unico generado
	 */
	private  static String generarId() {
		String id;
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss:SSS dd/MM/yyyy");
		// el identificador sera la fecha y hora en la que se crea el objeto en
		// formato String
		id = hourdateFormat.format(date);
		return id;
		}
	/**
	 * Procedimiento para crear un nuevo aparcamiento
	 * 
	 * @param anclajes
	 *            el numero de anclajes que va a tener el punto de aparcamiento
	 */
	public void nuevoPuntoAparcamiento(int anclajes, Coordenadas coordenadas) {
		assert coordenadas != null;
		CityBikeParkingPoint aparcamiento = new CityBikeParkingPoint(anclajes, coordenadas);
		aparcamientos.add(aparcamiento);
	}

	/**
	 * Metodo que cambia el valor de la fianza
	 * 
	 * @param nuevaFianza
	 *            valor nuevo de la fianza
	 */
	public void setFianza(double nuevaFianza) {
		assert fianza >= 0;
		this.fianza = nuevaFianza;
	}

	/**
	 * Procedimiento que elimina un punto de aparcamineto a partir de un
	 * identificador unico
	 * 
	 * @param idAparcamiento
	 *            identificador con el cual seleccionamos el  punto de aparcamiento que
	 *            queremos eliminar
	 */
	public void eliminarPuntosAparcamiento(String idAparcamiento) {
		for (CityBikeParkingPoint aparcamiento : aparcamientos) {
			if (aparcamiento.getIdentificador().equals(idAparcamiento)) {
				aparcamientos.remove(aparcamiento);
			}

		}
	}

	/**
	 * funcion que devuelve una lista de los aparcamientos
	 * 
	 * @return aparcamientos una lista de los
	 *        aparcamientos
	 * 
	 */
	public ArrayList<CityBikeParkingPoint> obtenerPuntosAparcamiento() {
		assert aparcamientos!=null;
		return aparcamientos;
	}

	/**
	 * Funcion que nos devuelve una lista de objetos con los aparcamientos que
	 * tienen bicicletas disponibles o huecos disponibles
	 * 
	 * @param OcupadosOlibres
	 *            booleano que nos indica si queremos saber los anclajes
	 *            ocupados o libres: true si queremos ver los aparcamientos que
	 *            tienen anclajes ocupados (bicicletas) false para ver la lista
	 *            de los aparcamientos que tienes anclajes libres(huecos)
	 * @return aparcamientosConBicicletas arrayList de objetos de los
	 *         aparcapientos con anclajes libres o con alguno ocupado
	 */
	public ArrayList<CityBikeParkingPoint> obtenerAparcamientosConAnclajesOcupadosOLibres(boolean OcupadosOlibres) {
		assert aparcamientos.size()>0;
		ArrayList<CityBikeParkingPoint> aparcamientosConAnclajesOcupadosOlibres = new ArrayList<CityBikeParkingPoint>();
		for (CityBikeParkingPoint aparcamiento : aparcamientos) {
			if (aparcamiento.anclajesOcupados() != 0 && OcupadosOlibres) {
				aparcamientosConAnclajesOcupadosOlibres.add(aparcamiento);
			} else if (aparcamiento.anclajesOcupados() > 0 && !OcupadosOlibres)
				aparcamientosConAnclajesOcupadosOlibres.add(aparcamiento);
		}

		return aparcamientosConAnclajesOcupadosOlibres;
		

	}

	/**
	 * Permite conocer la ciudad
	 * @return la ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * Permite modificar la ciudad
	 * @param ciudad la nueva ciudad
	 */
	public void setCiudad(String ciudad) {
		assert ciudad!=null;
		this.ciudad = ciudad;
	}
/**
 * funcion con la que sabemos los aparcamientos cercanos a una ubicacion dada
 * @param longitud de la posicion actual
 * @param latitud posicion actual
 * @param radio maxima distancia en la cual se encuantran los puntos de aparcapiento
 * @return aparcamientosCercanos lista con todos los aparcamientos cercanos
 */
	public ArrayList<CityBikeParkingPoint> puntosCercanosCoordenadas(double longitud, double latitud, double radio){
			ArrayList<CityBikeParkingPoint> aparcamientosCercanos = new ArrayList<CityBikeParkingPoint>();
			assert radio>0;
			
		for (CityBikeParkingPoint aparcamiento : aparcamientos) {
			if (aparcamiento.distancia(longitud, latitud) <= radio) {
				aparcamientosCercanos.add(aparcamiento);
			}
		}
		return aparcamientosCercanos;
	}

	/**
	 * Método que devuelve el valor de la fianza
	 * 
	 * @return [double] Valor de la fianza
	 */
	public double getFianza() {
		return fianza;
	}

	
	/**
	 * metodo que nos permite devolver prestar y devolver una bicia un anclaje y que nos devuelva
	 *  la fianza 
	 * @param tarjeta
	 *            Tarjeta del cliente que desea devolver la bici al anclaje
	 * 
	 * @param aparcamiento
	 *            Aparcamiento de bicis al que se desea devolver la bici
	 * 
	 * @param idAparcamiento
	 *            identificador del aparcamiento al que se desea devolver la
	 *            bici
	 * @param credencial
	 *            cadena que verifica si es correcta la accion
	 * @param modulo
	 *            numero del anclaje en el que se presta o se devulve una bici
	 * @param prestarOdevolver
	 *            si true: prestamos bici si false: devolver la bici
	 * 
	 */
	public void prestarODevolverBici(TarjetaMonedero tarjeta, String idAparcamiento, String credencial, int modulo,
		boolean prestarOdevolver) {
		assert tarjeta != null;
		assert idAparcamiento != null;

		for (CityBikeParkingPoint aparcamiento : aparcamientos) {
			if (aparcamiento.getIdentificador().equals(idAparcamiento)) {
				if (prestarOdevolver) {
					assert (credencial.equals("A156Bv09_1zXo894"));
					aparcamiento.prestarBici(modulo);
					tarjeta.descontarDelSaldo(credencial, fianza);
				}

				else {
					assert (credencial.equals("6Z1y00Nm31aA-571"));
					aparcamiento.devolverBici(modulo);
					tarjeta.recargaSaldo(credencial, fianza);
				}
			}
		}
	}
	/**
	 * nos permite saber un id
	 * @return
	 */
	public String getId() {
		return id;
	}
	
}