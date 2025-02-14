package services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import data.Empleado;
import data.Estudiante;
import data.Persona;

public class ServerThread extends Thread {
	
	
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket s;
	private int idClient;
	
	
	public ServerThread(Socket s, int idClient) throws IOException {
		
		this.s = s;
		this.idClient = idClient;
		
		try {
			
			ois =  new ObjectInputStream(s.getInputStream());
			oos = new  ObjectOutputStream(s.getOutputStream());
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void run() {
		
		do {
				
try {
	
	Persona persona = new Persona();
	persona = (Persona)ois.readObject();
	
	System.out.println("Server> client "+persona);
	
	oos.writeObject("Server> object recived");
	
		}catch (Exception e) {
		
			
			try {
				
				Estudiante estudiante = new Estudiante();
				estudiante = (Estudiante)ois.readObject();
				System.out.println("Server>  "+estudiante);
				oos.writeObject("Server> object recived");
				
			}catch (Exception e2) {
				
				try {
					
					Empleado empleado = new Empleado();
					empleado = (Empleado)ois.readObject();
					System.out.println("Server>  "+empleado);
					oos.writeObject("Server> object recived");
					
				}catch (Exception e3) {
				break;
			}
		}
		}
	
	}while(true);
		
		try {s.close();
		
		}catch (IOException e) {e.printStackTrace();
		}

}
}
