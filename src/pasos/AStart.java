package pasos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import puzzle8.Puzzle8;


public class AStart {
	
	//h=heuristica= numero de piezas desornedas.
	//Frontera
	public Estado prueba(ArrayList<Opcion> fil_col,Estado p,Estado estadoMeta){
		Puzzle8 t=new Puzzle8();
		Estado estActual =p;
		//calcular fn
		estActual.calcularFN(estadoMeta);
		
		
		Comparator<Estado> comp = new Estado(estActual);
		PriorityQueue<Estado> front =new PriorityQueue<Estado>(comp);
		ArrayList<Estado> explorados = new ArrayList<Estado>(); 
		
		front.add(estActual);
		
		
		
		do{
				
 			if(front.isEmpty()) System.out.println("No existe solucion!! "); 
			else{
				
				estActual = front.poll();
				//prueba de estado meta
				if (t.esMeta(estActual))
				{	System.out.println("Solucion encontrada.");
					return estActual; }
		
				
				explorados.add(estActual);
				//generar los movimientos posible aqui
				
				ArrayList<Opcion> opMovimientos = new Opcion().opcMover(estActual.getTablero(), 3);
				for(Opcion opc: opMovimientos){
					System.out.println(" ");
					Estado estadoTran=new Estado(estActual);	
					estadoTran.generarHijo(estActual,opc);
					estadoTran.calcularFN(estadoMeta);
				//verificar si se encuentra en la frontera si no agregarlo
				
					if(!explorados.contains(estadoTran) && !front.contains(estadoTran))
					{
						front.offer(estadoTran);
						System.out.println("\nEstado Generado : " + estadoTran);
					}else{
						System.out.println("\nEstado Generado pero repetido: " + estadoTran);
					}
				
				}
				
				
			}
		
			
			
			//este no es
		//	return estAcual;
		}while(true);
	}
	
}
