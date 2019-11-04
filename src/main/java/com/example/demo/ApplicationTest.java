/*import org.hibernate.sql.Template;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo21Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

@Autowired
private Template restTemplate;
@LocalServerPort
private int port;
private String getRootUrl() {
return "http://localhost:" + port;
}
@Test
public void contextLoads() {
}
@Test
public void testGetAllUsers() {
	RestTemplate restTemplate = new RestTemplate();


HttpHeaders headers = new HttpHeaders();
HttpEntity<String> entity = new HttpEntity<String>(null, headers);
ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/users",
HttpMethod.GET, entity, String.class);
Assert.assertNotNull(response.getBody());
}

RestTemplate restTemplate1 = new RestTemplate();

@Test
public void testGetUserById() {user user = restTemplate1.getForObject(getRootUrl() + "/users/1", user.class);
System.out.println(user.getUsername());
Assert.assertNotNull(user);
}
@Test
public void testCreateUser() {
user user = new user();
user.setPassword("asdasdasd");
user.setUsername("admin");
ResponseEntity<user> postResponse = restTemplate1.postForEntity(getRootUrl() + "/users", user, user.class);
Assert.assertNotNull(postResponse);
Assert.assertNotNull(postResponse.getBody());
}
@Test
public void testUpdatePost() {
int id = 1;
user user = restTemplate1.getForObject(getRootUrl() + "/users/" + id, user.class);
user.setUsername("admin123");

user.setUsername("admin");
restTemplate1.put(getRootUrl() + "/users/" + id, user);
user updatedUser = restTemplate1.getForObject(getRootUrl() + "/users/" + id, user.class);
Assert.assertNotNull(updatedUser);
}
@Test
public void testDeletePost() {
int id = 2;
user user = restTemplate1.getForObject(getRootUrl() + "/users/" + id, user.class);
Assert.assertNotNull(user);
restTemplate1.delete(getRootUrl() + "/users/" + id);
try {
user = restTemplate1.getForObject(getRootUrl() + "/users/" + id, user.class);
} catch (final HttpClientErrorException e) {
Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
}
}
}*/