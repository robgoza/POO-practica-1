import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author robgoza
 * @author mancome
 * 
 *         Implementacion de la clase que representa un punto de aparcamiento
 *         para el sistema de prestamo de bicis
 *
 */
public class CityBikeParkingPoint {
	private int numeroAnclajes;
	private String identificador;
	private boolean punto[];
	private double latitud;
	private double longitud;
	private double gradosLatitud;
	private double minutosLatitud;
	private double segundosLatitud;
	private char caracterLatitud;
	private double gradosLongitud;
	private double minutosLongitud;
	private double segundosLongitud;
	private char caracterLongitud;

	/**
	 * Constructor de la clase CityBikeParkingPoint con longitud y latitud en GD
	 * 
	 * @param anclajes
	 *            numero de anclajes del punto
	 * @param coordenadas
	 *            objeto de la clase coordenadas para la localizacion del punto
	 *            de aparcamiento
	 */
	public CityBikeParkingPoint(int anclajes, Coordenadas coordenadas) {
		assert anclajes >= 1;
		assert coordenadas != null;
		this.numeroAnclajes = anclajes;

		this.latitud = coordenadas.getLatitudGd();
		this.longitud = coordenadas.getLongitudGd();
		this.gradosLatitud = coordenadas.getGradosLatitud();
		this.minutosLatitud = coordenadas.getMinutosLatitud();
		this.segundosLatitud = coordenadas.getSegundosLatitud();
		this.gradosLongitud = coordenadas.getGradosLongitud();
		this.minutosLongitud = coordenadas.getMinutosLongitud();
		this.segundosLongitud = coordenadas.getSegundosLongitud();
		this.identificador = generarId();
		this.punto = new boolean[anclajes];
	}

	/**
	 * Permite conocer la cantidad de anclajes ocupados de un cierto punto de
	 * aparcamiento
	 * 
	 * @return El numero de anclajes ocupados del punto de aparcamiento
	 */

	public int anclajesOcupados() {
		int contador = 0;
		for (int i = 0; i < punto.length; i++) {
			if (punto[i] == true) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Permite conocer la cantidad de anclajes libres de un cierto punto de
	 * aparcamiento
	 * 
	 * @return El numero de anclajes libres del punto de aparcamiento
	 */
	public int anclajesLibres() {
		int contador = 0;
		for (int i = 0; i < punto.length; i++) {
			if (punto[i] == false) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Permite conocer el estado de un punto de anclaje
	 * 
	 * @param modulo
	 *            el modulo del que se desea consultar el estado
	 * @return El estado del punto de anclaje. Si es false significa que el
	 *         modulo esta libre y viceversa
	 */
	public boolean estadoModulo(int modulo) {

		return punto[modulo];
	}

	/**
	 * Gestion del prestamo de una bici de un modulo de anclaje
	 * 
	 * @param modulo
	 *            el modulo en el cual se encuentra la bici que va a ser
	 *            prestada
	 */
	public void prestarBici(int modulo) {
		assert punto[modulo - 1] == true;
		assert modulo >= 1;
		punto[modulo - 1] = false;

	}

	/**
	 * Gestion de la devolucion de una bici de un modulo de anclaje
	 * 
	 * @param modulo
	 *            el modulo en el cual se va a insertar la bici que va a ser
	 *            devuelta
	 */
	public void devolverBici(int modulo) {
		assert punto[modulo - 1] == false;
		assert modulo >= 1;
		punto[modulo - 1] = true;

	}

	/**
	 * Procedimiento que genera un identificador para el punto de aparcamiento
	 * 
	 * @return El identificador generado
	 */
	private String generarId() {
		String id;
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss:SSS dd/MM/yyyy");
		// el identificador sera la fecha y hora en la que se crea el objeto en
		// formato String
		id = hourdateFormat.format(date);
		return id;

	}

	/**
	 * Calculo de la distancia en km entre una posicion y el punto de
	 * aparcamiento
	 * 
	 * @param longitud2
	 *            lonngitud de la direccion
	 * @param latitud2
	 *            latitud de la direccion
	 * @return distancia la distancia entre las dos posiciones en km
	 */
	public double distancia(double longitud2, double latitud2) {
		assert latitud2 >= -90;
		assert latitud2 <= 90;
		assert longitud2 >= -180;
		assert longitud2 <= 180;
		double longitud1 = this.longitud;
		double latitud1 = this.latitud;
		double distanciaLongitud = longitud2 - longitud1;
		double distanciaLatitud = latitud2 - latitud1;
		double a = Math.pow(Math.sin(distanciaLatitud / 2), 2)
				+ Math.cos(latitud1) * Math.cos(latitud2) * Math.pow(Math.sin((distanciaLongitud / 2)), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distancia = 6371 * c;
		Math.toRadians(distancia);
		return distancia;
	}

	/**
	 * Permite conoocer el numero de anclajes que tiene el punto de aparcamiento
	 * 
	 * @return numeroAnclajes el numero de anclajes del punto
	 */

	public int getNumeroAnclajes() {
		return numeroAnclajes;
	}

	/**
	 * Permite modificar el numero de anclajes de un punto
	 * 
	 * @param numeroAnclajes
	 *            el numero de anclajes de ese punto
	 */
	public void setNumeroAnclajes(int numeroAnclajes) {
		assert numeroAnclajes >= 1;
		this.numeroAnclajes = numeroAnclajes;
	}

	/**
	 * Permite conoocer el identificador del punto de aparcamiento
	 * 
	 * @return el identificador del punto
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * Permite conocer la latitud del punto de aparcamiento
	 * 
	 * @return la latitud
	 */
	public double getLatitud() {
		return latitud;
	}

	/**
	 * Permite modificar la latitud del punto de aparcamiento
	 * 
	 * @param latitud
	 *            la latitud a modificar
	 */
	public void setLatitud(double latitud) {
		assert latitud >= -90;
		assert latitud <= 90;
		this.latitud = latitud;
	}

	/**
	 * Permite conocer la longitud del punto de aparcamiento
	 * 
	 * @return la longitud
	 */
	public double getLongitud() {
		return longitud;
	}

	/**
	 * Permite modificar la longitud del punto de aparcamiento
	 * 
	 * @param longitud
	 *            la longitud a modificar
	 */
	public void setLongitud(double longitud) {
		assert longitud >= -180;
		assert longitud <= 180;
		this.longitud = longitud;
	}

	/**
	 * Permite conocer los grados de la latitud del punto de aparcamiento
	 * 
	 * @return los grados de la latitud
	 */
	public double getGradosLatitud() {
		return gradosLatitud;
	}

	/**
	 * Permite modificar los grados de la latitud del punto de aparcamiento
	 * 
	 * @param gradosLatitud
	 *            los grados a modificar
	 */
	public void setGradosLatitud(double gradosLatitud) {
		assert gradosLatitud >= 0;
		assert gradosLatitud < 60;
		this.gradosLatitud = gradosLatitud;
	}

	/**
	 * Permite conocer los minutos de la latitud del punto de aparcamiento
	 * 
	 * @return los minutos de la latitud
	 */
	public double getMinutosLatitud() {

		return minutosLatitud;
	}

	/**
	 * Permite modificar los minutos de la latitud del punto de aparcamiento
	 * 
	 * @param minutosLatitud
	 *            los minutos a modificar
	 */
	public void setMinutosLatitud(double minutosLatitud) {
		assert minutosLatitud >= 0;
		assert minutosLatitud < 60;
		this.minutosLatitud = minutosLatitud;
	}

	/**
	 * Permite conocer los segundos de la latitud del punto de aparcamiento
	 * 
	 * @return los segundos de la latitud
	 */
	public double getSegundosLatitud() {
		return segundosLatitud;
	}

	/**
	 * Permite modificar los segundos de la latitud del punto de aparcamiento
	 * 
	 * @param segundosLatitud
	 *            los segundos a modificar
	 */
	public void setSegundosLatitud(double segundosLatitud) {
		assert segundosLatitud >= 0;
		assert segundosLatitud < 60;
		this.segundosLatitud = segundosLatitud;
	}

	/**
	 * Permite conocer el caracter de la latitud del punto de aparcamiento
	 * 
	 * @return the caracterLatitud
	 */
	public char getCaracterLatitud() {
		return caracterLatitud;
	}

	/**
	 * Permite conocer los grados de la longitud del punto de aparcamiento
	 * 
	 * @return los grados de la longitud
	 */
	public double getGradosLongitud() {
		return gradosLongitud;
	}

	/**
	 * Permite modificar los grados de la longitud del punto de aparcamiento
	 * 
	 * @param gradosLongitud
	 *            los grados a modificar
	 */
	public void setGradosLongitud(double gradosLongitud) {
		assert gradosLongitud >= 0;
		assert gradosLongitud < 60;
		this.gradosLongitud = gradosLongitud;
	}

	/**
	 * Permite conocer los minutos de la longitud del punto de aparcamiento
	 * 
	 * @return los minutos de la longitud
	 */
	public double getMinutosLongitud() {
		return minutosLongitud;
	}

	/**
	 * Permite conocer los minutos de la longitud del punto de aparcamiento
	 * 
	 * @param minutosLongitud
	 *            los minutos a modificar
	 */
	public void setMinutosLongitud(double minutosLongitud) {
		assert minutosLongitud >= 0;
		assert minutosLongitud < 60;
		this.minutosLongitud = minutosLongitud;
	}

	/**
	 * Permite conocer los segundos de la longitud del punto de aparcamiento
	 * 
	 * @return los segundos de la Longitud
	 */
	public double getSegundosLongitud() {
		return segundosLongitud;
	}

	/**
	 * Permite modificar los segundos de la longitud del punto de aparcamiento
	 * 
	 * @param segundosLongitud
	 *            los segundos a modificar
	 */
	public void setSegundosLongitud(double segundosLongitud) {
		assert segundosLongitud >= 0;
		assert segundosLongitud < 60;
		this.segundosLongitud = segundosLongitud;
	}

	/**
	 * Permite conocer el caracter de la longitud del punto de aparcamiento
	 * 
	 * @return el caracter de la longitud
	 */
	public char getCaracterLongitud() {
		return caracterLongitud;
	}

	/**
	 * Permite modificar el caracter de la longitud del punto de aparcamiento
	 * 
	 * @param caracterLongitud
	 *            el caracter a modificar
	 */
	public void setCaracterLongitud(char caracterLongitud) {
		this.caracterLongitud = caracterLongitud;
	}

	/**
	 * Permite obtener el array del punto de aparcamiento
	 * 
	 * @return el punto de aparcamiento
	 */
	public boolean[] getPunto() {
		return punto;
	}

	/**
	 * Permite modificar el array del punto de aparcamiento
	 * 
	 * @param punto
	 *            el punto a modificar
	 */
	public void setPunto(boolean[] punto) {
		this.punto = punto;
	}

}
