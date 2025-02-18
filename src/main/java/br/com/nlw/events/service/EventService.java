package br.com.nlw.events.service;

import br.com.nlw.events.model.Event;
import br.com.nlw.events.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    public Event addNewEvent(Event event) {
        // Gerando o pretty name
        event.setPrettyName(event.getTitle().toLowerCase().replace(" ", "-"));
        return eventRepo.save(event);
    }

    public List<Event> getAllEvent() {
        return (List<Event>)eventRepo.findAll();
    }

    public Event getByPrettyName(String prettyName) {
        return eventRepo.findByPrettyName(prettyName);
    }

}
