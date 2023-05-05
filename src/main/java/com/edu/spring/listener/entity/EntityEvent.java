package com.edu.spring.listener.entity;

import org.springframework.stereotype.Component;

import java.util.EventObject;

@Component
public class EntityEvent extends EventObject {

    private final AccessType accessType;

    public EntityEvent(Object entity, AccessType accessType) {
        super(entity);
        this.accessType = accessType;
    }

    public AccessType getAccessType() {
        return accessType;
    }
}
