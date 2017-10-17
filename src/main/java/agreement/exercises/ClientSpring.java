package agreement.exercises;

import agreement.core.dto.UserDTO;
import agreement.core.security.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Radek on 17.10.2017.
 */
public class ClientSpring {

    public static void main(String[] args){

//        RestTemplate template = new RestTemplate();
//        ResponseEntity<UserDTO> response = template.getForEntity("http://localhost:8080/rest/user/1", UserDTO.class);
//        UserDTO body = response.getBody();
//        System.out.println("Status: " + response.getStatusCode());
//        System.out.println(body.getLastName());

//        RestTemplate template = new RestTemplate();
//        ResponseEntity<List> response = template.getForEntity("http://localhost:8080/rest/user", List.class);
//        List<UserDTO> body = response.getBody();
//        System.out.println(body.toString());

//        RestTemplate template = new RestTemplate();
//        UserDTO response = template.getForObject("http://localhost:8080/rest/user/1", UserDTO.class, 2);
//        System.out.println(response.getLastName());

//----------------------POST
        RestTemplate restTemplate = new RestTemplate();
        UserDTO user = new UserDTO();
        user.setName("Radek");
        user.setLastName("Wójcik");
        user.setLogin("rdwwojcik");
        user.setPassword("tajnepassword");
        user.setEmail("rdwwojcik@gmail.com");
        user.setRole(Role.USER);

        ResponseEntity<UserDTO> responseEntity = restTemplate.postForEntity("http://localhost:8080/rest/user", user, UserDTO.class);
        System.out.println("Status post: " + responseEntity.getStatusCode());
        System.out.println("Login" + responseEntity.getBody().getLogin());
    }
}
