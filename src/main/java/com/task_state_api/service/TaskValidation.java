package com.task_state_api.service;
import com.task_state_api.entity.State;
import org.springframework.stereotype.Component;

@Component
public class TaskValidation {
    public int getStateOrder(State state) {
        int stateOrder = 0;
        switch (state) {
            case DRAFT:
                break;
            case ACTIVE:
                stateOrder = 1;
                break;
            case DONE:
                stateOrder = 2;
                break;
            case ARCHIVED:
                stateOrder = 3;
                break;
            default:
                throw new IllegalArgumentException("Undefined State");
        }
        return stateOrder;
    }
}
