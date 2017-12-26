import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Clase de test para la clase CityBikeParkingPoint
 * 
 * @author robgoza
 * @author mancome
 *
 */

public class CityBikeParkingPointTest {
	public static final double ERROR_ADMISIBLE = 0.00001;

	@Test
	public void testConstructorConParametrosValidos() {
		Coordenadas a = new Coordenadas(0.0, 0.0);
		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		assertNotNull(a);
		assertNotNull(b);
		assertEquals(b.getNumeroAnclajes(), 1);
		assertEquals(b.getLongitud(), 0.0, ERROR_ADMISIBLE);
		assertEquals(b.getLatitud(), 0.0, ERROR_ADMISIBLE);
		
	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorConAnclajesInvalidos() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(0, a);
		assertNotNull(a);
		assertNotNull(b);
	}

	@Test
	public void testGetNumeroAnclajes() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		assertEquals(b.getNumeroAnclajes(), 1, ERROR_ADMISIBLE);
	}

	@Test
	public void testSetNumeroAnclajes() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		b.setNumeroAnclajes(2);
		assertEquals(b.getNumeroAnclajes(), 2, ERROR_ADMISIBLE);

	}

	@Test
	public void testGetLatitud() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		assertEquals(b.getLatitud(), a.getLatitudGd(), ERROR_ADMISIBLE);
	}

	@Test
	public void testSetLatitud() {
		Coordenadas a = new Coordenadas(3.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		b.setLatitud(0.0);
		assertEquals(b.getLatitud(), 0.0, ERROR_ADMISIBLE);
	}

	@Test
	public void testGetLongitud() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		assertEquals(b.getLongitud(), a.getLongitudGd(), ERROR_ADMISIBLE);
	}

	@Test
	public void testSetLongitud() {
		Coordenadas a = new Coordenadas(0.0, 2.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		b.setLongitud(0.0);
		assertEquals(b.getLatitud(), 0.0, ERROR_ADMISIBLE);
	}

	@Test
	public void testGetGradosLatitud() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		assertEquals(b.getGradosLongitud(), a.getGradosLongitud(), ERROR_ADMISIBLE);
	}

	@Test
	public void testSetGradosLongitud() {
		Coordenadas a = new Coordenadas(1.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		b.setGradosLongitud(0.0);
		assertEquals(b.getGradosLongitud(), 0.0, ERROR_ADMISIBLE);
	}

	@Test
	public void testGetMinutosLongitud() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		assertEquals(b.getMinutosLongitud(), a.getMinutosLongitud(), ERROR_ADMISIBLE);
	}

	@Test
	public void testSetMinutosLongitud() {
		Coordenadas a = new Coordenadas(1.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		b.setMinutosLongitud(0.0);
		assertEquals(b.getMinutosLongitud(), 0.0, ERROR_ADMISIBLE);
	}

	@Test
	public void testGetSegundosLongitud() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		assertEquals(b.getSegundosLongitud(), a.getSegundosLongitud(), ERROR_ADMISIBLE);
	}

	@Test
	public void testSetSegundosLongitud() {
		Coordenadas a = new Coordenadas(1.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		b.setMinutosLongitud(0.0);
		assertEquals(b.getSegundosLongitud(), 0.0, ERROR_ADMISIBLE);
	}

	@Test
	public void testSetGradosLatitud() {
		Coordenadas a = new Coordenadas(0.0, 1.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		b.setGradosLatitud(0.0);
		assertEquals(b.getGradosLatitud(), 0.0, ERROR_ADMISIBLE);
	}

	@Test
	public void testGetMinutosLatitud() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		assertEquals(b.getMinutosLatitud(), a.getMinutosLatitud(), ERROR_ADMISIBLE);
	}

	@Test
	public void testSetMinutosLatitud() {
		Coordenadas a = new Coordenadas(0.0, 1.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		b.setMinutosLongitud(0.0);
		assertEquals(b.getMinutosLongitud(), 0.0, ERROR_ADMISIBLE);
	}

	@Test
	public void testGetSegundosLatitud() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		assertEquals(b.getSegundosLatitud(), a.getSegundosLatitud(), ERROR_ADMISIBLE);
	}

	@Test
	public void testSetSegundosLatitud() {
		Coordenadas a = new Coordenadas(0.0, 1.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(1, a);
		b.setMinutosLongitud(0.0);
		assertEquals(b.getSegundosLatitud(), 0.0, ERROR_ADMISIBLE);
	}

	@Test
	public void testAnclajesOcupados() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);

		b.devolverBici(1);

		assertEquals(b.anclajesOcupados(), 1, ERROR_ADMISIBLE);

	}

	@Test
	public void testAnclajesLibres() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);

		b.devolverBici(1);

		assertEquals(b.anclajesLibres(), 2, ERROR_ADMISIBLE);

	}

	@Test
	public void testEstadoModulo() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);

		assertEquals(b.estadoModulo(1), false);

	}

	@Test
	public void testPrestarBici() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);
		boolean p[] = b.getPunto();
		p[0] = true;
		b.prestarBici(1);

		assertEquals(b.estadoModulo(1), false);

	}

	@Test
	public void testDevolverBici() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);

		b.devolverBici(1);

		assertEquals(b.estadoModulo(0), true);

	}

	@Test
	public void testDistancia() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);
		double distancia = b.distancia(1.0, 1.0);
		assertEquals(distancia, 8120.194889073402, ERROR_ADMISIBLE);
	}

	@Test(expected = AssertionError.class)
	public void testDistanciaConLongitudMenor() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);
		b.distancia(-180.1, 1.0);
	}

	@Test(expected = AssertionError.class)
	public void testDistanciaConLongitudMayor() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);
		b.distancia(180.1, 1.0);
	}

	@Test(expected = AssertionError.class)
	public void testDistanciaConLatitudMenor() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);
		b.distancia(0, -90.1);
	}

	@Test(expected = AssertionError.class)
	public void testDistanciaConLatitudMayor() {
		Coordenadas a = new Coordenadas(0.0, 0.0);

		CityBikeParkingPoint b = new CityBikeParkingPoint(3, a);
		b.distancia(0, 90.1);
	}

}