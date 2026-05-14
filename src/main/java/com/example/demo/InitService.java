package com.example.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class InitService {
    private StudentRepo studentRepo;

    private InitService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        //deleting elements which might be existing at the beginning
        studentRepo.deleteAll()
                .thenMany(
                        Flux.just("Jacob", "Anna", "Ron")
                )
                .map(Student::new)
                .flatMap(studentRepo::save)
                .thenMany(studentRepo.findAll())
                .subscribe(System.out::println);

        studentRepo.save(
                new Student("Przemek")
        ).subscribe();
    }
}
