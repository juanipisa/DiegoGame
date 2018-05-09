import processing.core.PImage;

public class Waifu extends Cuadrado {
	
	int dx = 4;
	int dy = 4;
	boolean cojido=false;
	public Waifu(int x, int y, int lado, PImage imagen) {
		super(x, y, lado, imagen);
		
	}

	@Override
	public void actualizar(Principal pantalla) {
		super.dibujar(pantalla);
		mover(pantalla);
		if( !cojido ) comprobarChoque((Jugador)pantalla.a.get(0), pantalla);

	}
	
	public void comprobarChoque(Jugador j, Principal pantalla)
	{
		if( j.y < y + lado && j.y + j.lado > y && 
				j.x < x + lado && j.x + j.lado > x)
		{
			
			pantalla.vectorVidas.remove(pantalla.vectorVidas.size() - 1);
			System.out.println(pantalla.vectorVidas.size());
			j.setX(700);
			j.setY(400);
			j.setDireccion(1);
			if(pantalla.vectorVidas.size()== 0) {
				this.cojido = true;
				j.perder(pantalla);
			}
			
		}
	}
	void mover(Principal pantalla) {
	    x += dx;
	    y += dy;
	    if (x >= (pantalla.AnchoPantalla-lado) || x <= 0) dx*= -1;
	    if (y >= (pantalla.AltoPantalla-lado) || y <= 40) dy*= -1;
	}

}
