package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread {

	Random random = new Random();
	private Semaphore semaforo;
	private static int bilhetes = 100;
	private boolean verificaCompra=false;
	public int idThread;

	public ThreadBilheteria(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}

	public void run() {
		while (bilhetes > 0 && verificaCompra==false) {
			if (logar()) {

			} else {
				if (comprar()) {

				} else {
					try {
						semaforo.acquire();
						validar();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally{
						semaforo.release();
					}
					
					
				}
			}
		}
	}

	public boolean logar() {
		int tempo = 0;
		tempo = random.nextInt(1950) + 50;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (tempo > 1000) {
			System.out.println(idThread + "# Timeout");
			return true;
		} else {
			System.out.println(idThread + "# Logado");
			return false;
		}
	}

	public boolean comprar() {
		int tempo = 0;
		tempo = random.nextInt(2000) + 1000;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (tempo > 2500) {
			System.out.println(idThread + "# Final de tempo de sess�o");
			return true;
		} else {
			System.out.println(idThread + "# Compra iniciada");
			return false;
		}
	}

	public void validar() {
		int qtd;
		qtd = random.nextInt(3)+1;
		if(qtd <= bilhetes){
			bilhetes-=qtd;
			System.out.println(idThread + "# Venda de " + qtd + " bilhetes efetuada com sucesso. Bilhetes restantes: "+ bilhetes);
		}
		else{
			System.out.println(idThread + "# bilhetes insuficientes");
		}
	}
}
