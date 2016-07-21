package com.business.controller;

import com.business.service.UsersService;
import com.entity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YT on 2016/1/26.
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public int insert(@RequestBody Users users) {
        return  this.usersService.insert(users);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public int update(@RequestBody Users users) {

        return  this.usersService.update(users);
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public int delete(@RequestBody Users users) {

        return  this.usersService.delete(users);
    }

    @ResponseBody
    @RequestMapping("/get")
    public Users toIndex(@RequestHeader ("host") String host,@CookieValue(value="JSESSIONID", defaultValue="") String cookie,@RequestParam(defaultValue = "1") String id) {
        return  this.usersService.getById(id);
    }

    @ResponseBody
    @RequestMapping("/get/{id}")
    public Users getById(@PathVariable String id) {
        String userId = "1";

        return  this.usersService.getById(userId);
    }

    @ResponseBody
    @RequestMapping("/getlist")
    public List<Users> getList() {

        return  this.usersService.getUsers();
    }



}
