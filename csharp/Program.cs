using System;
using System.Collections.Generic;
using Newtonsoft.Json;
using Entities;

namespace ReadJsonFile
{
    class Program
    {
        static void Main(string[] args) {
            try {
                string jsonFilePath = "/Users/alexandreoliveira/Documents/ws-projects/project-json/csharp/bin/Debug/file.json"; // Caminho relativo ao diretório de saída

                // read file
                string jsonContent = System.IO.File.ReadAllText(jsonFilePath);

                List<Course> courses = JsonConvert.DeserializeObject<List<Course>>(jsonContent);

                foreach (Course course in courses) {
                    Console.WriteLine($"Course ID: {course.Id}");
                    Console.WriteLine($"Course Title: {course.Title}");

                    foreach (Lesson lesson in course.Lessons) {
                        Console.WriteLine();
                        Console.WriteLine($"    id: {lesson.Id}");
                        Console.WriteLine($"    title: {lesson.Title}");
                        Console.WriteLine($"    media: {lesson.Media}");
                        Console.WriteLine($"    timestamp: {lesson.Timestamp}");
                    }
                    Console.WriteLine();

                }
            }
            catch (Exception ex) {
                Console.WriteLine($"Error: {ex.Message}");
            }
        }
    }
}