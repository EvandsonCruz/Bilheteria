package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread{
	
	Random random = new Random();
	private Semaphore semaforo;
	private static int bilhetes = 100;
	
	public ThreadBilheteria(Semaphore semaforo) {
		this.semaforo = semaforo;
	}
	
	public void run() {
		if(logar()){
			
		}
		else{
			if(comprar()){
				
			}
			else{
				validar();
			}
		}
	}
	
	public boolean logar(){
		int tempo=0;
		tempo = random.nextInt(1950)+50;
		if(tempo > 1000){
			System.out.println("Timeout");
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean comprar(){
		int tempo=0;
		tempo = random.nextInt(2000)+1000;
		if(tempo > 2500){
			System.out.println("Final de tempo de sessão");
			return true;
		}
		else{
			return false;
		}
	}
	
	public void validar(){
		
	}

}
