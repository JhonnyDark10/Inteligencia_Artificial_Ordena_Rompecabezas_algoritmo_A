package puzzle8;

import java.util.ArrayList;
import java.util.Random;

import pasos.AStart;
import pasos.Estado;
import pasos.Opcion;

public class Puzzle8 {

	private static Estado estadoInicial;
	 private static Estado estadoMeta;
	
	private static int n=3,f,c,hn;

	
	
	public static void main(String[] args){
		
		 
		 
		 
		 ArrayList<Estado> OpcDisponibles;
		
		Puzzle8 t=new Puzzle8();
		ArrayList<Opcion> fil_col;
		
			
		estadoMeta=new Estado("EM",0,0,0,0,0,t.meta());
		//String nombre, int nivel, int costoRuta, int fn, int gn, int hn, int[][] estado
		estadoInicial=new Estado("E0",0,0,0,0,0,t.llenarEstadoInicial());
		
		OpcDisponibles =new ArrayList<Estado>();
			
			 
		System.out.println("Estado Meta");
		t.presentaMatriz(estadoMeta.getTablero());
		
		System.out.println("Estado Inicial");
		t.presentaMatriz(estadoInicial.getTablero());
		
		//t.obteneVacio(estadoInicial.getEstado(), n);
		
		fil_col=new Opcion().opcMover(estadoInicial.getTablero(), n);
		
		
		AStart p= new AStart();
		p.prueba(fil_col,estadoInicial,estadoMeta);
		
		
		
		
		}

	
	
	
	public void obteneVacio(int[][] MatrizActual, int n){		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				if(MatrizActual[i][j]==0){
						f=i; 
						c=j;	
					}
			}
	}
	
	public int[][] llenarEstadoInicial(){
		
		Random r = new Random();	
		int k,ban,l;
		int[][] matrizInicial=new int[n][n];
		int pos=0;
		//System.out.println("entro");
		 int[] lista= new int[n*n];
		
		while(pos<(n*n)){
			 ban=0;
			 k=r.nextInt((n*n));
			 for(int j=0;j<pos;j++){
				 if(lista[j]==k)
					ban=1;
				}
			
			 if (ban==0){
				 lista[pos]=k; pos++;
				}
			 }

		l=0;
		 for(int i=0;i<n;i++)
			 for(int j=0;j<n;j++)
			 {// 	System.out.println(lista[i]);
				 matrizInicial[i][j]=lista[l];
				 l++;
			 }
		 
		 return matrizInicial ;	
	}
	
	
	public void presentaMatriz(int[][] m){		
		
		for(int j=0;j<n;j++)
		{	
			System.out.println(m[j][0] + " " + m[j][1]+ " " + m[j][2]);
		}	
}
	
	
	public int[][] meta(){		
		int k=0;
		int[][] Meta= new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{	
				Meta[i][j]=k;
				//System.out.println(" "+i+" "+" "+j+" "+k);
				k++;
			}	
		return Meta;
	}
	
	
	public boolean esMeta(Estado esMeta){
		if(esMeta.equals(estadoMeta)){
			return true;
		}else{
			return false;
		}
	}
	
	
}
