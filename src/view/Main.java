package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBilheteria;

public class Main {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int i=0;i<300;i++){
			ThreadBilheteria threadb = new ThreadBilheteria(i,semaforo);
		}
	}

}
