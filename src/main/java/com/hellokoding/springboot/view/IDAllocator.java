package com.hellokoding.springboot.view;

import org.springframework.stereotype.Component;

@Component
public class IDAllocator {
    private long id = 0;

    public long getNext() {
        return id++;
    }
}
