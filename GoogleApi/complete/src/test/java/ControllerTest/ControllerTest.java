package ControllerTest;

import junit.framework.TestCase;
import junit.framework.TestSuite; 
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.Application;
import com.stackroute.domain.SearchResultsModel;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest  extends TestCase {
   
	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	SearchResultsModel user;    
    
	@Before
    
	
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + "/v1.0/userservice" + uri;
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testSaveUser() throws Exception { 

    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("a", headers); 
        System.out.println(createURLWithPort("/semantic/fetchurls"));
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/semantic/fetchurls"),
                HttpMethod.GET, entity, String.class); 
        assertNotNull(response);
        String actual = response.getBody();
        assertEquals("Success",actual); 
    }
    
//    @Test
//    public void testSaveUserWithoutEmail() throws Exception { 
//    	String actual = ""; 
//    		HttpHeaders headers = new HttpHeaders();
//	    	headers.setContentType(MediaType.APPLICATION_JSON); 
//	    	user.(null);
//	        HttpEntity<User> entity = new HttpEntity<User>(user, headers); 
//	        ResponseEntity<String> response = restTemplate.exchange(
//	                createURLWithPort("/user"),
//	                HttpMethod.POST, entity, String.class); 
//	        assertNotNull(response);
//	        actual = response.getBody();
//    	 
//        assertEquals("Please make sure that both username and email id are entered.",actual); 
//        
//    }
    
//    @Test
//    public void testSaveUserWithoutName() throws Exception { 
//    	String actual = ""; 
//    	HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON); 
//	    user.setFirstname(null);
//	    HttpEntity<User> entity = new HttpEntity<User>(user, headers); 
//	    ResponseEntity<String> response = restTemplate.exchange(
//	             createURLWithPort("/user"),
//	             HttpMethod.POST, entity, String.class); 
//	    assertNotNull(response);
//	    actual = response.getBody();
//    	 
//        assertEquals("Please make sure that both username and email id are entered.",actual); 
//        
//    }
//    
//    @Test
//    public void testList() throws Exception {
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/user"),
//                HttpMethod.GET, entity, String.class);
//        assertNotNull(response);
//    } 
//    
//    @Test
//    public void testDeleteUser() throws Exception {
//    	HttpHeaders headers = new HttpHeaders();
//    	headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<User> entity = new HttpEntity<User>(user, headers); 
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/user"),
//                HttpMethod.DELETE, entity, String.class); 
//        assertNotNull(response);
//        String actual = response.getBody();
//        assertEquals("User deleted successfully",actual);
//    }
//    
//    @Test
//    public void testDeleteInvalidUser() throws Exception {
//    	HttpHeaders headers = new HttpHeaders();
//    	headers.setContentType(MediaType.APPLICATION_JSON);
//    	user.setId(10);
//        HttpEntity<User> entity = new HttpEntity<User>(user, headers); 
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/user"),
//                HttpMethod.DELETE, entity, String.class); 
//        assertNotNull(response);
//        String actual = response.getBody();
//        assertEquals("Couldn't delete user. User with ID not found!",actual);
//    }
//    
    @Test
    public void testUpdateUser() throws Exception {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("", headers);  
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/semantic/fetchurls"),
                HttpMethod.PUT, entity, String.class); 
        assertNotNull(response);
        String actual = response.getBody();
        assertEquals("Success",actual);
    }
    
  
    
}