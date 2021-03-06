package org.dcsc.web.controller;

import org.dcsc.core.event.Event;
import org.dcsc.core.event.EventService;
import org.dcsc.web.here.HereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HereController {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    @Autowired
    private HereService hereService;
    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/here", method = RequestMethod.GET)
    public String here(Model model) {
        List<Event> events = hereService.getCurrentEvent();

        model.addAttribute("events", events);

        return "main/here";
    }

    private boolean validEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
