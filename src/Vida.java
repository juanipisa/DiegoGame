import processing.core.PApplet;
import processing.core.PImage;

public class Vida extends Cuadrado {

	public Vida(int x, int y, PImage imagen) {
		super(x, y, 30, imagen);
		
	}
	public void actualizar(Principal pantalla) {
		super.dibujar(pantalla);

	}
	@Override
	protected void dibujar(PApplet pantalla) {
		// TODO Auto-generated method stub
		super.dibujar(pantalla);
	}

}
