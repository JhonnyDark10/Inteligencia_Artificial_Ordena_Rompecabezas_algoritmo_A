package pasos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import puzzle8.Puzzle8;


public class Estado  implements Comparator<Estado>{
	
	private String nombre;
	private int nivel,costoRuta,fn,gn,hn;
	private int tamanoTablero = 3;
	private int[][] tablero= new int[tamanoTablero][tamanoTablero];
	
	//int f,c;
	
	public Estado() {
		super();
	}
	
	public Estado(int fn) {
		super();
		this.fn = fn;
	}
	public Estado(Estado est) {
		super();
		this.nombre = est.nombre;
		this.nivel = est.nivel;
		this.costoRuta = est.costoRuta;
		this.fn = est.fn;
		this.gn = est.gn;
		this.hn = est.hn;
		this.tablero = copiarTablero(est.getTablero());
	}
	
	
	private int[][] copiarTablero(int[][] tableroOriginal) {
		 int[][] tableroNuevo = new int[tamanoTablero][tamanoTablero];
			for(int i = 0; i<this.tamanoTablero; i++)
			{
				for(int j = 0; j<this.tamanoTablero; j++)
				{
					tableroNuevo[i][j] = tableroOriginal[i][j];
				}
			}		
			return tableroNuevo;
	}

	public Estado(String nombre, int nivel, int costoRuta, int fn, int gn, int hn, int[][] estado) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.costoRuta = costoRuta;
		this.fn = fn;
		this.gn = gn;
		this.hn = hn;
		this.tablero = estado;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getCostoRuta() {
		return costoRuta;
	}

	public void setCostoRuta(int costoRuta) {
		this.costoRuta = costoRuta;
	}

	public int getFn() {
		return fn;
	}

	public void setFn(int fn) {
		this.fn = fn;
	}

	public int getGn() {
		return gn;
	}

	public void setGn(int gn) {
		this.gn = gn;
	}

	public int getHn() {
		return hn;
	}

	public void setHn(int hn) {
		this.hn = hn;
	}

	public int[][] getTablero() {
		return tablero;
	}

	public void setEstado(int[][] estado) {
		this.tablero = estado;
	}
	
	
	
	
	public void generarHijo(Estado padre,Opcion fil_col ){
		Puzzle8 t= new Puzzle8();

		this.tablero[fil_col.getFilaFinal()][fil_col.getColumnaFinal()]=this.tablero[fil_col.getFilaInicial()][fil_col.getColumnaInicial()];
		this.tablero[fil_col.getFilaInicial()][fil_col.getColumnaInicial()]=0;
		//temporal.setEstado(problema.getEstado());
		this.gn++;
		t.presentaMatriz(this.tablero);
			//return problema;
		}
	


	public double calcularFN(Estado estadoMeta) {
		//Calcular f(n) = g(n) + h(n)
		this.hn = calcularHN(estadoMeta);

		System.out.println("fn "+this.fn+" gn "+this.gn+" hn "+this.hn);
		return this.fn = this.gn + this.hn;	
	}

	private int calcularHN(Estado estadoMeta){
		int valorHN = 0;
		for(int i = 0; i<3; i++)
			{
				for(int j = 0; j<3; j++)
				{
					if(this.tablero[i][j]!=estadoMeta.getTablero()[i][j])
						{valorHN++;}
				}
			}

		System.out.println("tempHN "+valorHN);
		return valorHN;
	}

	@Override
	public String toString() {
		return "Estado [nombre=" + nombre + ", nivel=" + nivel + ", costoRuta=" + costoRuta + ", fn=" + fn + ", gn="
				+ gn + ", hn=" + hn + ", estado=" + Arrays.toString(tablero) + "]";
	}


	/* @Override
	public int compare(Object arg0) {
		// TODO Auto-generated method stub
		
		return 0;
	}*/
  
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (!Arrays.deepEquals(tablero, other.tablero))
			return false;
		
		return true;
	}

	@Override
	public int compare(Estado o1, Estado o2) {
		// TODO Auto-generated method stub
		if(o1.getFn()>o2.getFn())
		{
			return 1;
		}else
		   if (o1.getFn()<o2.getFn()){
			return -1;}
		else
		return 0;
	}
	
	
	



	
	
	}
