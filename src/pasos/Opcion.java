package pasos;

import java.util.ArrayList;

public class Opcion {
	public int filaInicial = -1;
	public int filaFinal = -1;
	public int columnaInicial = -1;
	public int columnaFinal = -1;
	
	public Opcion()
	{
		super();
	}
	
	public Opcion(int filaInicial, int columnaInicial,int filaFinal, int columnaFinal) {
		super();
		this.filaInicial = filaInicial;
		this.filaFinal = filaFinal;
		this.columnaInicial = columnaInicial;
		this.columnaFinal = columnaFinal;
	}



	public int getFilaInicial() {
		return filaInicial;
	}

	public void setFilaInicial(int filaInicial) {
		this.filaInicial = filaInicial;
	}

	public int getFilaFinal() {
		return filaFinal;
	}

	public void setFilaFinal(int filaFinal) {
		this.filaFinal = filaFinal;
	}

	public int getColumnaInicial() {
		return columnaInicial;
	}

	public void setColumnaInicial(int columnaInicial) {
		this.columnaInicial = columnaInicial;
	}

	public int getColumnaFinal() {
		return columnaFinal;
	}

	public void setColumnaFinal(int columnaFinal) {
		this.columnaFinal = columnaFinal;
	}
	

	//opciones para mover
	public ArrayList<Opcion> opcMover(int[][] MatrizActual, int n){
		ArrayList<Opcion> opMover= new ArrayList<Opcion>();
		Opcion mov;
		
		
		ArrayList<Integer> opc=new ArrayList<Integer>() ;
		//System.out.println("posiciones f:"+f+"c:"+ c);
		
		//int k=0,d;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				//System.out.println("entra al for "+ MatrizActual[i][j]+" "+" i:"+i+" j:"+j);
				if(MatrizActual[i][j]==0){
					if(!(i==0)){
						System.out.println("Abajo");
						//opc.add(i-1);//fila
						//opc.add(j);//columna	
						mov= new Opcion(i-1,j,i,j);
						opMover.add(mov);
						
					}
					
					if(!(j==(n-1))){
						System.out.println("A la izquierda");
						//opc.add(i);//fila
						//opc.add(j+1);//columna
						mov= new Opcion(i,j+1,i,j);
						opMover.add(mov);	
					}
					
					if(!(i==(n-1))){
						System.out.println("Arriba");
						//opc.add(i+1);//fila
						//opc.add(j);//columna	
						mov= new Opcion(i+1,j,i,j);
						opMover.add(mov);	
					}
					
					if(!(j==0)){
						System.out.println("A la derecha");
					//	opc.add(i);//fila
						//opc.add(j-1);//columna
						mov= new Opcion(i,j-1,i,j);
						opMover.add(mov);	
					}
					
					
				}
			}
		
		
		
		return opMover;
		
	}
	
	
	
	
	
	
	
}
