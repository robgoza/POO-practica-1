/**
 * 
 * @author robgoza
 * @author mancome
 * 
 *         Implementacion de la clase que se encarga de la gestion de las
 *         coordenadas de los puntos de aparcamiento
 *
 */
public class Coordenadas {
	private double gradosLatitud;
	private double minutosLatitud;
	private double segundosLatitud;
	private char caracterLatitud;
	private double gradosLongitud;
	private double minutosLongitud;
	private double segundosLongitud;
	private char caracterLongitud;
	private double latitudGd;
	private double longitudGd;

	/**
	 * Constructor de la clase coordenadas en GD
	 * 
	 * @param lat
	 *            la latitud
	 * @param lon
	 *            la longitud
	 */
	public Coordenadas(double lat, double lon) {
		assert lat >= -90;
		assert lat <= 90;
		assert lon >= -180;
		assert lon <= 180;
		this.latitudGd = lat;
		this.longitudGd = lon;
		caracterGMS();
	}

	/**
	 * Constructor de la clase coordenadas en GMS
	 * 
	 * @param gLa
	 *            los grados de la latitud
	 * @param mLa
	 *            los minutos de la latitud
	 * @param sLa
	 *            los segundos de la latitud
	 * @param gLo
	 *            los grados de la longitud
	 * @param mLo
	 *            los minutos de la longitud
	 * @param sLo
	 *            los segundos de la longitud
	 */
	public Coordenadas(double gLa, double mLa, double sLa, double gLo, double mLo, double sLo) {
		assert gLa >= 0;
		assert mLa >= 0;
		assert sLa >= 0;
		assert gLo >= 0;
		assert mLo >= 0;
		assert sLo >= 0;
		assert gLa <= 180;
		assert mLa <= 60;
		assert sLa <= 60;
		assert gLo <= 180;
		assert mLo <= 60;
		assert sLo <= 60;
		this.gradosLatitud = gLa;
		this.minutosLatitud = mLa;
		this.segundosLatitud = sLa;
		this.gradosLongitud = gLo;
		this.minutosLongitud = mLo;
		this.segundosLongitud = sLo;
	}

	

	/**
	 * Asignacion del caracter a las coordenadas en GMS
	 */
	public void caracterGMS() {
		if (latitudGd < 0.0) {
			caracterLatitud = 'S';
		} else {
			caracterLatitud = 'N';
		}
		if (longitudGd < 0.0) {
			caracterLongitud = 'O';
		} else {
			caracterLongitud = 'E';
		}
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
	 * Permite conocer la latitud en GD
	 * 
	 * @return la latitud en GD
	 */
	public double getLatitudGd() {
		return latitudGd;
	}

	/**
	 * Permite modificar la latitud en GD
	 * 
	 * @param latitudGd
	 *            la latitud a modificar
	 */
	public void setLatitudGd(double latitudGd) {
		this.latitudGd = latitudGd;
	}

	/**
	 * Permite consultar la longitud en GD
	 * 
	 * @return la longitud en GD
	 */
	public double getLongitudGd() {
		return longitudGd;
	}

	/**
	 * Permite modificar la longitud en GD
	 * 
	 * @param longitudGd
	 *            la longitud a modificar
	 */
	public void setLongitudGd(double longitudGd) {
		this.longitudGd = longitudGd;
	}

}
