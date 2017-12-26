import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Clase de test para la clase Coordenadas
 * 
 * @author robgoza
 * @author mancome
 *
 */
public class CoordenadasTest {
	public static final double ERROR_ADMISIBLE = 0.00001;

	@Test
	public void testConstructorGdConParametrosValidos() {
		Coordenadas a = new Coordenadas(0.0, 0.0);
		assertNotNull(a);

		assertEquals(a.getLongitudGd(), 0.0, ERROR_ADMISIBLE);
		assertEquals(a.getLatitudGd(), 0.0, ERROR_ADMISIBLE);
	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorConLongitudMenor() {
		Coordenadas a = new Coordenadas(0.0, -180.1);

		assertNotNull(a);
	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorConLongitudMayor() {
		Coordenadas a = new Coordenadas(0.0, 180.1);

		assertNotNull(a);
	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorConLatitudMenor() {
		Coordenadas a = new Coordenadas(-90.1, 0);

		assertNotNull(a);
	}

	@Test
	public void testConstructorGmsConParametrosValidos() {
		Coordenadas a = new Coordenadas(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		assertNotNull(a);

		assertEquals(a.getGradosLongitud(), 0.0, ERROR_ADMISIBLE);
		assertEquals(a.getMinutosLongitud(), 0.0, ERROR_ADMISIBLE);
		assertEquals(a.getSegundosLongitud(), 0.0, ERROR_ADMISIBLE);
		assertEquals(a.getGradosLatitud(), 0.0, ERROR_ADMISIBLE);
		assertEquals(a.getMinutosLatitud(), 0.0, ERROR_ADMISIBLE);
		assertEquals(a.getSegundosLatitud(), 0.0, ERROR_ADMISIBLE);

	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorGmsConGradosLongitudMenor() {
		Coordenadas a = new Coordenadas(-0.1, 0.0, 0.0, 0.0, 0.0, 0.0);

		assertNotNull(a);
	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorGmsConMinutosLongitudMenor() {
		Coordenadas a = new Coordenadas(0.0, -0.1, 0.0, 0.0, 0.0, 0.0);

		assertNotNull(a);
	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorGmsConSegundosLongitudMenor() {
		Coordenadas a = new Coordenadas(0.0, 0.0, -0.1, 0.0, 0.0, 0.0);
		assertNotNull(a);
	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorGmsConGradosLatitudMenor() {
		Coordenadas a = new Coordenadas(0.0, 0.0, 0.0, -0.1, 0.0, 0.0);
		assertNotNull(a);

	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorGmsConMinutosLatitudMenor() {
		Coordenadas a = new Coordenadas(0.0, 0.0, 0.0, 0.0, -0.1, 0.0);
		assertNotNull(a);

	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorGmsConSegundosLatitudMenor() {
		Coordenadas a = new Coordenadas(0.0, 0.0, 0.0, 0.0, 0.0, -0.1);
		assertNotNull(a);

	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorGmsConGradosLongitudMayor() {
		Coordenadas a = new Coordenadas(180.1, 0.0, 0.0, 0.0, 0.0, 0.0);

		assertNotNull(a);
	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorGmsConMinutosLongitudMayor() {
		Coordenadas a = new Coordenadas(0.0, 60.1, 0.0, 0.0, 0.0, 0.0);

		assertNotNull(a);
	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorGmsConSegundosLongitudMayor() {
		Coordenadas a = new Coordenadas(0.0, 0.0, 60.1, 0.0, 0.0, 0.0);
		assertNotNull(a);
	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorGmsConGradosLatitudMayor() {
		Coordenadas a = new Coordenadas(0.0, 0.0, 0.0, 180.1, 0.0, 0.0);
		assertNotNull(a);

	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorGmsConMinutosLatitudMayor() {
		Coordenadas a = new Coordenadas(0.0, 0.0, 0.0, 0.0, 60.1, 0.0);
		assertNotNull(a);

	}

	@Test(expected = AssertionError.class)
	public void testInicializarConstructorGmsConSegundosLatitudMayor() {
		Coordenadas a = new Coordenadas(0.0, 0.0, 0.0, 0.0, 0.0, 60.1);
		assertNotNull(a);

	}

	@Test
	public void testCaracterGmsConAmbasCoordenadasPositivas() {
		Coordenadas a = new Coordenadas(0.0, 0.0);
		assertEquals(a.getCaracterLatitud(), 'N');
		assertEquals(a.getCaracterLongitud(), 'E');

	}

	@Test
	public void testCaracterGmsConAmbasCoordenadasNegativas() {
		Coordenadas a = new Coordenadas(-0.1, -0.1);
		assertEquals(a.getCaracterLatitud(), 'S');
		assertEquals(a.getCaracterLongitud(), 'O');

	}

	@Test
	public void testCaracterGmsConPrimeraCoordenadaNegativaYSegundaPositiva() {
		Coordenadas a = new Coordenadas(-0.1, 0.0);
		assertEquals(a.getCaracterLatitud(), 'S');
		assertEquals(a.getCaracterLongitud(), 'E');

	}

	@Test
	public void testCaracterGmsConSegundaCoordenadaNegativaYSegundaPositiva() {
		Coordenadas a = new Coordenadas(0.0, -0.1);
		assertEquals(a.getCaracterLatitud(), 'N');
		assertEquals(a.getCaracterLongitud(), 'O');

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
}
