package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bean.ApplicationBase;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(ApplicationBase.class)
@RequestMapping(value = "/request", produces = "application/json")
public class ApplicationBaseController {
	
  /*  @Autowired
    private OrderRepository repository;

    @Autowired

    private OrderResourceAssembler assembler;
*/
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> findAllOrders() {

        //List<Roles> orders = repository.findAll();

        return new ResponseEntity<String>("In the requet section", HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> createOrder(@RequestBody ApplicationBase app) {

        //Order createdOrder = repository.create(order);

        return new ResponseEntity<String>("In the post method ", HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)

    public ResponseEntity<String> findOrderById(@PathVariable Long id) {

       // Optional<Order> order = repository.findById(id);

        if (true) {

            return new ResponseEntity<String>("Roles found", HttpStatus.OK);

        }
		return null;

        /*else {

            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

        }*/

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)

    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {

        boolean wasDeleted = true;//repository.delete(id);

        HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;

        return new ResponseEntity<Void>(responseStatus);

    }

   /* @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")

    public ResponseEntity<Roles> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {

        boolean wasUpdated = repository.update(id, updatedOrder);

        if (wasUpdated) {

            return findOrderById(id);

        }

        else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }*/
}
