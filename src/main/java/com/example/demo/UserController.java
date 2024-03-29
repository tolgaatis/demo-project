package com.example.demo;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class UserController {
  @Autowired
  private UserRepository userRepository;
  /**
   * Get all users list.
   *
   * @return the list
   */
  @GetMapping("/users")
  public List<user> getAllUsers() {
    return userRepository.findAll();
  }
  /**
   * Gets users by id.
   *
   * @param userId the user id
   * @return the users by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/users/{iduser}")
  public ResponseEntity<user> getUsersById(@PathVariable(value = "iduser") Long iduser)
      throws RelationNotFoundException {
    user user =
        userRepository
            .findById(iduser)
            .orElseThrow(() -> new RelationNotFoundException("User not found on :: " + iduser));
    return ResponseEntity.ok().body(user);
  }
  /**
   * Create user user.
   *
   * @param user the user
   * @return the user
   */
  @PostMapping("/create")
  public @Valid user createUser(@Valid @RequestBody user user) {
    return userRepository.save(user);
  }
  /**
   * Update user response entity.
   *
   * @param userId the user id
   * @param userDetails the user details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/update/{iduser}")
  public ResponseEntity<user> updateUser(
		  @PathVariable(value = "iduser") Long iduser, @Valid @RequestBody user userDetails)
      throws RelationNotFoundException {
	user user =
        userRepository
            .findById(iduser)
	        .orElseThrow(() -> new RelationNotFoundException("User not found on :: " + iduser));
	  user.setUsername(userDetails.getUsername());
	  user.setPassword(userDetails.getPassword());

    final user updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }
  /*
   * Delete user map.
   *
   * @param userId the user id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/delete/{iduser}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "iduser") Long iduser) throws Exception {
    user user =
        userRepository
            .findById(iduser)
            .orElseThrow(() -> new RelationNotFoundException("User not found on :: " + iduser));
    userRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
  
 /* @RequestMapping(value = "/user/{iduser}", method = RequestMethod.PATCH  )
  public ResponseEntity<?> partialUpdateGeneric(
    @RequestBody Map<String, Object> updates,
    @PathVariable("iduser") String iduser) {
     user user =  
      userRepository.save(user);
      return ResponseEntity.ok("resource updated");
  }*/
  
  /*@PatchMapping("/user/{iduser}")
  ResponseEntity<?> saveManager(@RequestBody Map<String, String> user) {
      user toBePatchedManager = objectMapper.convertValue(user, user.class);
      managerService.patch(toBePatchedManager);
  }*/
  @PatchMapping("/patch/{iduser}")
  public ResponseEntity<user> patchUser(
		  @PathVariable(value = "iduser") Long iduser, @Valid @RequestBody user userDetails)
      throws RelationNotFoundException {
	user user =
        userRepository
            .findById(iduser)
	        .orElseThrow(() -> new RelationNotFoundException("User not found on :: " + iduser));
	  user.setUsername(userDetails.getUsername());
	  user.setPassword(userDetails.getPassword());

    final user updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }
}
  
