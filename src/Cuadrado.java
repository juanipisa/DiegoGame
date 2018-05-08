import processing.core.PApplet;
import processing.core.PImage;
public abstract class Cuadrado {

	protected int x;
	protected int y;
	protected int lado;
	protected int r;
	protected int g;
	protected int b;
	private PImage imagen;
	
	public Cuadrado(int x, int y, int lado, int r, int g, int b,PImage imagen) {
		super();
		this.x = x;
		this.y = y;
		this.lado = lado;
		this.r = r;
		this.g = g;
		this.b = b;
		this.imagen = imagen;
	}
	
	protected void dibujar(PApplet pantalla)
	{
		pantalla.fill(r,g,b);
		pantalla.rect(x, y, lado, lado);
		pantalla.image(imagen, x, y, lado, lado);
	}
	
	public abstract void actualizar(Principal pantalla);
	
}
