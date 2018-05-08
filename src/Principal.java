import java.util.Vector;

import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet{
	
	int AnchoPantalla = 800, AltoPantalla = 500;
	PImage imagenDiego;
	Vector <Cuadrado> a;
	PImage imagenMessi;
	PImage imagenDimaria;
	PImage imagenAguero;
	PImage imagenGO;
	
	
	public void settings()
	{	
		size(AnchoPantalla, AltoPantalla);
	}
	
	public void setup() 
	{
		imagenDiego = loadImage("diego.png");
		imagenMessi = loadImage("messi.png");
		imagenAguero = loadImage ("aguero.png");
		imagenGO = loadImage("go.png");
		a = new Vector <Cuadrado>();
		a.add(new Jugador((int)random(0, AnchoPantalla - 25), (int)random(0, AltoPantalla - 25), 3,imagenDiego));
		a.add(new Fruta((int)random(0, AnchoPantalla - 25), (int)random(0, AltoPantalla - 25), imagenMessi));
		
	
	}

	
	public void draw() {
		
		clear();
		
		for( Cuadrado actual : a )
		{
			actual.actualizar(this);
		}
		
		Fruta.crarNuevaFruta(this);
		mostrarPuntaje();
	}
		
	
	public void mostrarPuntaje()
	{
		fill(255);
		textSize(30);
		text(Fruta.getCantidadDeFrutas(), 10, 30);
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { "--location=300,100", "Principal" });
	}

}
