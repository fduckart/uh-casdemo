package edu.hawaii.its.casdemo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class ActionRecorder implements ApplicationEventPublisherAware {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(String code, Long uhuuid) {
        this.publisher.publishEvent(new ActionEvent(this, code, uhuuid, null));
    }

    public void publish(String code, Long uhuuid, Long viewUhuuid) {
        this.publisher.publishEvent(new ActionEvent(this, code, uhuuid, viewUhuuid));
    }
}