//package org.eventure.controller;
//
//
//
//import org.eventure.datamodel.Event;
//import org.eventure.services.Impl.EventService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/events")
//public class EventController {
//
//    @Autowired
//    private EventService eventService;
//
//    @PostMapping
//    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
//        Event createdEvent = eventService.createEvent(event);
//        return ResponseEntity.ok(createdEvent);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Event>> getAllEvents() {
//        return ResponseEntity.ok(eventService.getAllEvents());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Event> getEventById(@PathVariable String id) {
//        return ResponseEntity.ok(eventService.getEventById(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Event> updateEvent(@PathVariable String id, @RequestBody Event event) {
//        event.setId(id);
//        return ResponseEntity.ok(eventService.updateEvent(event));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEvent(@PathVariable String id) {
//        eventService.deleteEvent(id);
//        return ResponseEntity.noContent().build();
//    }
//}
//
