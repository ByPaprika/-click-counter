package com.task.demo.controllers;

import com.task.demo.model.Count;
import com.task.demo.service.IService.IClickService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/counter")
public class CounterController {

    private final IClickService IClickService;

    public CounterController(IClickService IClickService) {
        this.IClickService = IClickService;
    }

    @PostMapping("/click")
    public void clickButton(@RequestBody Count booking) {
        IClickService.clickButton(booking);
    }

    @PostMapping("/button")
    public void createNewIdButton(@RequestBody Count booking) {
        IClickService.createNewIdButton(booking);
    }

    @GetMapping("/count/{id}")
    public Count getClickCountById(@PathVariable Long id) {
        return IClickService.getClickCountById(id);
    }
}
