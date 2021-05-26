package com.task.demo.controllers;

import com.task.demo.model.Count;
import com.task.demo.service.IService.INewClickService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/")
public class MainController {
    private INewClickService iNewClickService;

    public MainController(INewClickService iNewClickService) {
        this.iNewClickService = iNewClickService;
    }

    @PostMapping("click")
    public void clickButton(@RequestBody Count booking) {
            this.iNewClickService.clickButton(booking);
    }

    @PostMapping("create/button")
    public void createNewIdButton(@RequestBody Count booking) {
        this.iNewClickService.createNewIdButton(booking);
    }

    @GetMapping("count")
    public Iterable getClickCount() {
        return this.iNewClickService.getClickCount();
    }
}
