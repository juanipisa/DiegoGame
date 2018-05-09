import processing.core.PImage;

public class Fruta extends Cuadrado{
	
	private static int cantidadDeFrutas = 0;
	private boolean comido;
	private static int figurita=0;

	public Fruta(int x, int y, PImage imagen) {
		super(x, y, 50, imagen);
		this.comido = false;
		Fruta.cantidadDeFrutas++;
	}
	
	
	public void actualizar(Principal pantalla)
	{
		super.dibujar(pantalla);
		if( !comido ) comprobarChoque((Jugador)pantalla.a.get(0));
	}
	
	public void comprobarChoque(Jugador j)
	{
		if( j.y < y + lado && j.y + j.lado > y && 
				j.x < x + lado && j.x + j.lado > x)
		{
			this.comido = true;
			this.lado = 0;
		}
	}
	
	public static void crearNuevaFruta(Principal pantalla)
	{
		boolean crearNueva = true;
		for( Cuadrado actual : pantalla.a )
		{
			if( actual instanceof Fruta )
			{
				if( !((Fruta) actual).comido ) crearNueva = false;
			}
		}
		
		if( crearNueva ) {
			if(figurita==0) {
				pantalla.a.add(new Fruta((int)pantalla.random(0, pantalla.AnchoPantalla - 50), (int)pantalla.random(0, pantalla.AltoPantalla -50), pantalla.imagenMessi));
				figurita=1;
			}
			else {
				pantalla.a.add(new Fruta((int)pantalla.random(0, pantalla.AnchoPantalla - 50), (int)pantalla.random(0, pantalla.AltoPantalla -50), pantalla.imagenAguero));
				figurita=0;
			}

			}
		}
			
	// getters
	public static int getCantidadDeFrutas()
	{
		return cantidadDeFrutas;
	}
}
