
import processing.core.PApplet;
import processing.core.PImage;


public class Jugador extends Cuadrado{

	private int velocidad;
	private int direccion;
	
	public Jugador(int x, int y, int velocidad, PImage imagen) {
		super(x, y, 50, 255, 0, 0, imagen);
		this.velocidad = velocidad;
	}

	public void actualizar(Principal pantalla) {
		super.dibujar(pantalla);
		direccionar(pantalla);
		moverse();
		limites(pantalla); 
	
	}
	
	public void limites(Principal pantalla)
	{
		if( x < 0 || x > pantalla.AnchoPantalla - lado
				|| y < 0 || y > pantalla.AltoPantalla - lado) {
			
			pantalla.image(pantalla.imagenGO,0,0,800,500);
			try {
	           
	            Thread.sleep(1000);
	         } catch (Exception e) {
	            System.out.println(e);
	         }
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
	
	public void aumentarVelocidad()
	{
		velocidad *= 1.35;
	}

}
