
import processing.core.PApplet;
import processing.core.PImage;


public class Jugador extends Cuadrado{

	private int velocidad;
	private int direccion;
	public Jugador(int x, int y, int velocidad, PImage imagen) {
		super(x, y, 50, imagen);
		this.velocidad = velocidad;
		
	}

	public void actualizar(Principal pantalla) {
		super.dibujar(pantalla);
		direccionar(pantalla);
		moverse();
		limites(pantalla); 
	
	}
	
	private void limites(Principal pantalla)
	{
		if( x < 0 || x > pantalla.AnchoPantalla - lado
				|| y < 30 || y > pantalla.AltoPantalla - lado) {
			
			perder(pantalla);
		}
	}
	
	public void perder(Principal pantalla) {
		
		pantalla.image(pantalla.imagenGO,0, 0, 800,500);
		pantalla.fill(255,0,0);
		pantalla.textSize(30);
		pantalla.text("¿Desea volver a jugar?", 240,400);
		pantalla.text("R: Si", 270,450);
		pantalla.text("E: Salir", 390,450);
		if(pantalla.key == 'e') {
			pantalla.reiniciar =  true;
		}
		else if(pantalla.key == 'r') {
			pantalla.reiniciar = false;
		}
		
	}

	private void moverse()
	{
		if( direccion == 0 ) y -= velocidad;
		if( direccion == 1 ) x -= velocidad;
		if( direccion == 2 ) y += velocidad;
		if( direccion == 3 ) x += velocidad;
	}
	
	private void direccionar(PApplet pantalla)
	{
		if( pantalla.keyPressed )
		{
			if( pantalla.key == 'w' ) direccion = 0;
			if( pantalla.key == 'a' ) direccion = 1;
			if( pantalla.key == 's' ) direccion = 2;
			if( pantalla.key == 'd' ) direccion = 3;
		}
	}
	
	public int getX() {
		return x;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	

}
