package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread {

	Random random = new Random();
	private Semaphore semaforo;
	private static int bilhetes = 100;
	private boolean verificaCompra=false;

	public ThreadBilheteria(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	public void run() {
		while (bilhetes > 0 && verificaCompra==false) {
			if (logar()) {

			} else {
				if (comprar()) {

				} else {
					validar();
				}
			}
		}
	}

	public boolean logar() {
		int tempo = 0;
		tempo = random.nextInt(1950) + 50;
		if (tempo > 1000) {
			System.out.println("Timeout");
			return true;
		} else {
			return false;
		}
	}

	public boolean comprar() {
		int tempo = 0;
		tempo = random.nextInt(2000) + 1000;
		if (tempo > 2500) {
			System.out.println("Final de tempo de sessão");
			return true;
		} else {
			return false;
		}
	}

	public void validar() {
		int qtd;
		qtd = random.nextInt(3)+1;
		if(qtd >= bilhetes){
			bilhetes-=qtd;
		}
	}
}
