//package org.eventure.services.Impl;
//
//
//
//
//
//import org.eventure.datamodel.Event;
//import org.eventure.repository.EventRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class EventService {
//
//    @Autowired
//    private EventRepository eventRepository;
//
//    public Event createEvent(Event event) {
//        return eventRepository.save(event);
//    }
//
//    public List<Event> getAllEvents() {
//        return eventRepository.findAll();
//    }
//
//    public Event getEventById(String eventId) {
//        return eventRepository.findById(eventId).orElse(null);
//    }
//
//    public void deleteEvent(String eventId) {
//        eventRepository.deleteById(eventId);
//    }
//
//    public Event updateEvent(Event event) {
//        return eventRepository.save(event);
//    }
//}
