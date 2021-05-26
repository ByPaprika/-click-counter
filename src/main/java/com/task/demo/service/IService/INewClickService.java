package com.task.demo.service.IService;

import com.task.demo.model.Count;
import org.springframework.web.bind.annotation.RequestBody;

public interface INewClickService {
    void clickButton(@RequestBody Count booking);
    void createNewIdButton(@RequestBody Count booking);
    Iterable getClickCount();

}
