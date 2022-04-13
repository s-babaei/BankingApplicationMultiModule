package Controller;

import Entity.UserEntity;
import Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class UserController {

    UserService userService;



    @PostMapping("/add")
    @ResponseBody
    public void add(@RequestBody UserEntity item) {

        userService.save(item);
    }

    @GetMapping("/user")
    private List<UserEntity> creatUsers() {
        return userService.createUser();
    }


    @GetMapping("/user/{userid}")
    private UserEntity getUsers(@PathVariable("userid") int userid) {
        return userService.getUsersById(userid);
    }


    @PutMapping("/users")
    private UserEntity update(@RequestBody UserEntity user) {
        userService.saveOrUpdate(user);
        return user;
    }


    @DeleteMapping("/user/{userid}")
    private void deleteUser(@PathVariable("userid") int userid) {
        userService.delete(userid);
    }

    @PostMapping("/users")
    private int saveUser(@RequestBody UserEntity user) {
        userService.saveOrUpdate(user);
        return user.getUserid();
    }


}