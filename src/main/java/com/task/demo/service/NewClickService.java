package com.task.demo.service;

import com.task.demo.model.Count;
import com.task.demo.repo.CountRepository;
import com.task.demo.service.IService.INewClickService;
import org.springframework.stereotype.Service;

@Service
public class NewClickService implements INewClickService {
    private CountRepository countRepository;

    public NewClickService(CountRepository countRepository) {
        this.countRepository = countRepository;
    }


    @Override
        public synchronized void clickButton(Count booking) {
        Count count = null;
        try {
            count = this.countRepository.findById(booking.getId()).orElseThrow(() -> new Exception("not found in db"));
            count.setCount(count.getCount() + 1);
            this.countRepository.save(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createNewIdButton(Count booking) {
        this.countRepository.save(booking);
    }

    @Override
    public Iterable getClickCount() {
        return this.countRepository.findAll();
    }

}
