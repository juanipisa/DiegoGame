import java.util.Vector;

import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet{
	
	public int AnchoPantalla = 800, AltoPantalla = 500;
	private PImage imagenDiego;
	Vector <Cuadrado> a;
	Vector <Cuadrado> vectorVidas;
	public PImage imagenMessi;
	public PImage imagenAguero;
	public PImage imagenGO;
	private PImage imagenWaifu;
	private PImage imagenVidas;
	private PImage imagenFondo;
	
	
	public void settings()
	{	
		size(AnchoPantalla, AltoPantalla);
	}
	
	public void setup() 
	{
		try {
            Thread.sleep(2000);
         } catch (Exception e) {
            System.out.println(e);
         }
		imagenFondo = loadImage("fondo.png");
		imagenDiego = loadImage("diego.png");
		imagenMessi = loadImage("messi.png");
		imagenAguero = loadImage ("aguero.png");
		imagenGO = loadImage("go.png");
		imagenWaifu = loadImage("waifu.png");
		imagenVidas = loadImage("diegoVida.png");
		
		vectorVidas = new Vector <Cuadrado>();
		vectorVidas.add(new Vida(620,5, imagenVidas));
		vectorVidas.add(new Vida(670,5, imagenVidas));
		vectorVidas.add(new Vida(720,5,imagenVidas));
		
		a = new Vector <Cuadrado>();
		a.add(new Jugador(700, 400, 7,imagenDiego));
		a.add(new Fruta((int)random(0, AnchoPantalla - 50), (int)random(0, AltoPantalla - 50), imagenMessi));
		a.add(new Waifu (100, (int)random(0, AltoPantalla - 25), 50, imagenWaifu));
	
	}

	
	public void draw() {
		
		clear();
		image(imagenFondo,0,0,800,40);
		for( Cuadrado actual : a )
		{
			actual.actualizar(this);
		}
		for( Cuadrado actual : vectorVidas )
		{
			actual.actualizar(this);
		}
		
		Fruta.crearNuevaFruta(this);
		mostrarPuntajeYvidas();
	}
		
	public void mostrarPuntajeYvidas()
	{
		
		fill(0);
		textSize(30);
		text("Figuritas Conseguidas: " + Fruta.getCantidadDeFrutas(), 10, 30);
		text("Vidas: ",520,30);
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { "--location=300,100", "Principal" });
	}

}
