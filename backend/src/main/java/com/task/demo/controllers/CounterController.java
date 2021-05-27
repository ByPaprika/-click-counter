package com.task.demo.controllers;

import com.task.demo.model.Count;
import com.task.demo.service.IService.IClickService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000", "https://cosanostralounge.ru", "http://45.67.59.183:3000"})
@RestController
@RequestMapping("/counter")
public class CounterController {

    private final IClickService IClickService;

    public CounterController(IClickService IClickService) {
        this.IClickService = IClickService;
    }

    @CrossOrigin
    @PostMapping("/click")
    @ApiOperation(value = "New click button")
    public Count clickButton(@RequestBody Count booking) {

        Count count = IClickService.clickButton(booking);
        return count;
    }
    @CrossOrigin
    @PostMapping("/button")
    @ApiOperation(value = "New id button")
    public void createNewIdButton(@RequestBody Count booking) {
        IClickService.createNewIdButton(booking);
    }

    @GetMapping("/count/{id}")
    @ApiOperation(value = "Count by id button")
    public Count getClickCountById(@PathVariable Long id) {
        return IClickService.getClickCountById(id);
    }
}
