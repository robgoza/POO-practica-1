
/**
 * Clase de Test de la clase CityBikeSystem
 * @author robgoza
 * @author mancome
 * 
 */
import static org.junit.Assert.*;

import org.junit.Test;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class CityBikeSystemTest {

	public static final double ERROR_ADMISIBLE = 0.00001;

	@Test
	public void testConstructorConParametrosValidos() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		assertNotNull(a);
		assertEquals(a.getFianza(), 0.0, ERROR_ADMISIBLE);

	}

	@Test(expected = AssertionError.class)
	public void testConstructorConParametrosNoValidos() {
		CityBikeSystem a = new CityBikeSystem(-1, "madrid");
		assertNotNull(a);
		assertEquals(a.getFianza(), 0.0, ERROR_ADMISIBLE);

	}

	@Test
	public void testNuevoPuntoAparcamientoValido() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		Coordenadas c = new Coordenadas(0.0, 0.0);
		a.nuevoPuntoAparcamiento(4, c);
	}

	@Test(expected = AssertionError.class)
	public void testNuevoPuntoAparcamientoNoValido() {
		CityBikeSystem a = new CityBikeSystem(-1, "madrid");
		Coordenadas c = null;
		a.nuevoPuntoAparcamiento(4, c);
	}

	@Test
	public void testEliminarPuntosAparcamiento() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		Coordenadas c = new Coordenadas(0.0, 0.0);
		a.nuevoPuntoAparcamiento(4, c);
		a.eliminarPuntosAparcamiento(a.getId());

	}

	@Test
	public void testObtenerPuntosAparcamiento() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");

		Coordenadas ca = new Coordenadas(0.0, 0.0);
		Coordenadas c1 = new Coordenadas(0.0, 0.0);
		a.nuevoPuntoAparcamiento(4, ca);
		a.nuevoPuntoAparcamiento(3, c1);
		a.obtenerPuntosAparcamiento();

	}

	@Test
	public void testObtenerAparcamientosConAnclajesOcupadosValido() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		Coordenadas c = new Coordenadas(0.0, 0.0);
		a.nuevoPuntoAparcamiento(3, c);
		a.obtenerAparcamientosConAnclajesOcupadosOLibres(false);

	}

	@Test
	public void testObtenerAparcamientosConAnclajesLibresValido() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		Coordenadas c = new Coordenadas(0.0, 0.0);
		a.nuevoPuntoAparcamiento(3, c);
		a.obtenerAparcamientosConAnclajesOcupadosOLibres(true);

	}

	@Test(expected = AssertionError.class)
	public void testObtenerAparcamientosConAnclajesLibresNoValido() {
		CityBikeSystem a = new CityBikeSystem(0.0, "madrid");
		a.obtenerAparcamientosConAnclajesOcupadosOLibres(true);

	}

}