import { jsonData } from "./file.js";

function parseTimestamp(timestamp) {
    return new Date(timestamp);
}

for (const course of jsonData) {
    console.log(`Curso: ${course.title}`);

    for (const lesson of course.lessons) {
        console.log(`      Aula ${lesson.id}: ${lesson.title}`);
        // console.log(`           Timestamp: ${parseTimestamp(lesson.timestamp)}`);
    }

    console.log();
}