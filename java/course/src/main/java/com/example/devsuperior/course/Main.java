package com.example.devsuperior.course;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.example.devsuperior.course.entities.Course;
import com.example.devsuperior.course.entities.Lesson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File jsonFile = new File("/Users/alexandreoliveira/Documents/ws-projects/project-json/java/course/src/main/resources/file.json");
            List<Course> courses = objectMapper.readValue(jsonFile, new TypeReference<List<Course>>() {});

            for (Course course : courses) {
                System.out.println("Course ID: " + course.getId());
                System.out.println("Course Title: " + course.getTitle());
                
                List<Lesson> lessons = course.getLessons();
                
                for (Lesson lesson : lessons) {
                    System.out.println();
                    System.out.println("    id: " + lesson.getId());
                    System.out.println("    title: " + lesson.getTitle());
                    System.out.println("    media: " + lesson.getMedia());
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}