package services;

import java.io.IOException;

public class MainClient {
	
	public static void main (String[]args) throws IOException{
		
		for(int i= 0; i<10; i++) {
			
			Client client =new Client();
			client.OnClient("Client new" +i);
			
		}
		
		
	}

}
