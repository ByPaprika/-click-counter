package com.task.demo.service.IService;

import com.task.demo.model.Count;

public interface IClickService {
    Count clickButton(Count booking);

    void createNewIdButton(Count booking);

    Count getClickCountById(Long id);
}
