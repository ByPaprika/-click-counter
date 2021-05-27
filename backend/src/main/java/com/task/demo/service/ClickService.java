package com.task.demo.service;

import com.task.demo.exceptions.ActionWasBlockedException;
import com.task.demo.model.Count;
import com.task.demo.repo.CountRepository;
import com.task.demo.service.IService.IClickService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClickService implements IClickService {

    private final CountRepository countRepository;

    public ClickService(CountRepository countRepository) {
        this.countRepository = countRepository;
    }

    @Override
    public synchronized Count clickButton(Count booking) {
        Count count = countRepository.findById(booking.getId())
                .orElseThrow(() -> new ActionWasBlockedException("not found button id"));

        count.setCount(count.getCount() + 1L);
        countRepository.save(count);
        return count;
    }

    @Override
    public void createNewIdButton(Count booking) {
        countRepository.save(booking);
    }

    @Override
    public Count getClickCountById(Long id) {
        return countRepository.findById(id)
                .orElseThrow(() -> new ActionWasBlockedException("not found button id"));
    }

}
