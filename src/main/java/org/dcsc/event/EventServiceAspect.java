package org.dcsc.event;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.dcsc.activity.Actions;
import org.dcsc.activity.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tktong on 8/6/2015.
 */
@Aspect
@Component
public class EventServiceAspect {
    @Autowired
    private ActivityService activityService;

    @AfterReturning(
            pointcut = "execution(* org.dcsc.event.EventService.saveEvent(long,EventForm))",
            returning = "result"
    )
    public void saveEventWithId(JoinPoint joinPoint, Object result) {
        Event event = (Event) result;

        logActivity(String.format("Event #%d (%s) updated.", event.getId(), event.getName()), Actions.UPDATE);
    }

    @AfterReturning(
            pointcut = "execution(* org.dcsc.event.EventService.saveEvent(EventForm))",
            returning = "result"
    )
    public void createEvent(JoinPoint joinPoint, Object result) {
        Event event = (Event) result;

        logActivity(String.format("Event #%d (%s) created.", event.getId(), event.getName()), Actions.CREATE);
    }

    private void logActivity(String description, Actions action) {
        activityService.save("Event", description, action);
    }
}
