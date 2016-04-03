package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TodoClient {
	
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		
	while(true)
	{
		System.out.println("1. Create or Update ToDo Message");
		System.out.println("2. Display ToDO Message by ID");
		System.out.println("3. Display All TODO Message");
		System.out.println("4. Delete a todo Message");
		System.out.println("Enter option : ");
		int opt = scn.nextInt();
			
			if(opt==1)
			{
				Scanner scn1 = new Scanner(System.in);
				System.out.print("Enter ID: ");
				String id = scn1.nextLine();
				System.out.print("Enter Message: ");
				String message = scn1.nextLine();
				
				try {
					String urlParameters  = "id="+id+"&message="+message;
					byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
					int    postDataLength = postData.length;
					String request        = "http://localhost:8080/Lab3/TodoExeServlet";
					URL    url            = new URL( request );
					HttpURLConnection conn= (HttpURLConnection) url.openConnection();   
					
					conn.setDoOutput( true );
					conn.setInstanceFollowRedirects( false );
					conn.setRequestMethod( "POST" );
					conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
					conn.setUseCaches( false );
					try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
					   wr.write( postData );
					}
				
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String next_record = null;
					while ((next_record = reader.readLine()) != null) {
						System.out.println(next_record);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
				else if(opt==2)
			{
				System.out.println("2");
				Scanner scn2 = new Scanner(System.in);
				System.out.print("Enter ID to display message: ");
				String id = scn2.nextLine();
				
				try {
					System.out.println("Making GET call");
					String request = "http://localhost:8080/Lab3/TodoExeServlet?id=";
					URL url = new URL(request+id);
					HttpURLConnection conn= (HttpURLConnection) url.openConnection();   
					
					conn.setInstanceFollowRedirects( false );
					conn.setRequestMethod( "GET" );
					conn.setUseCaches( false );
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String next_record = null;
					while ((next_record = reader.readLine()) != null) {
						System.out.println(next_record);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				else if(opt==3)
			{
				try {
					System.out.println("Making GET call");
					String request        = "http://localhost:8080/Lab3/TodoExeServlet?id=ALL";
					URL    url            = new URL( request );
					HttpURLConnection conn= (HttpURLConnection) url.openConnection();   
					
					conn.setInstanceFollowRedirects( false );
					conn.setRequestMethod( "GET" );
					conn.setUseCaches( false );
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String next_record = null;
					while ((next_record = reader.readLine()) != null) {
						System.out.println(next_record);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
				else if(opt==4)
			{
				System.out.println("4");
				Scanner scn3 = new Scanner(System.in);
				System.out.print("Enter ID to delete message: ");
				String id = scn3.nextLine();
				
				try {
					String request = "http://localhost:8080/Lab3/TodoExeServlet?id=";
					URL url = new URL(request+id);
					HttpURLConnection conn= (HttpURLConnection) url.openConnection();   
					
					conn.setDoOutput( true );
					conn.setInstanceFollowRedirects( false );
					conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
					conn.setRequestMethod( "DELETE" );
					conn.connect();
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String next_record = null;
					while ((next_record = reader.readLine()) != null) {
						System.out.println(next_record);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
	}
			
	}
			
	}


}

