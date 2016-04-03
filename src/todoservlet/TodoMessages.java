package todoservlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/")
public class TodoMessages {

	
	public TodoMessages(){}
	

	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/xmlResponse")
	public Response getXmlResponse() {
		return Response.ok(createTodoMessage(),"application/xml").build();
		//return toXml(createRandomMessage());
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/xml/{id: [0-9]+}")
	public Response getSpecificXml(@PathParam("id") int id) {
		try{
			TodoMessage r = createMessage(id);
			return Response.ok(r,"application/xml").build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/xmllist")
	public JAXBElement<TodoMessageList> getXmlList() {
		TodoMessageList messages = new TodoMessageList();
		TodoMessage m1 = createTodoMessage();
		TodoMessage m2 = createTodoMessage();
		List<TodoMessage> messageList = new ArrayList<TodoMessage>();
		messageList.add(m1);
		messageList.add(m2);
		messages.setMessages(messageList);
		return new JAXBElement<TodoMessageList>(new QName("todoMessageList"), TodoMessageList.class, messages);

	}
	

	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/xmlResponse")
	public Response addRandomMessage(TodoMessage message) {
		
		return Response.ok().build();
		//return toXml(createRandomMessage());
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/json")
	public String getJson(){
		TodoMessage response = createTodoMessage();
		String json = "{'Error':'Error'}";
		try {
			json = new ObjectMapper().writeValueAsString(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	private TodoMessage createTodoMessage(){
		TodoMessage message = new TodoMessage();
		return message;
	}
	
	private TodoMessage createMessage(int index){
		TodoMessage message = new TodoMessage();
		return message;
	}
	
	private JAXBElement<TodoMessage> toXml(TodoMessage message){
		return new JAXBElement<TodoMessage>(new QName("randomMessage"), TodoMessage.class, message);
	}
}
