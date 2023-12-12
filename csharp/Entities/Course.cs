namespace Entities
{
    public class Course {
        public int Id { get; set; }
        public string Title { get; set; }
        public List<Lesson> Lessons { get; set; }

        public Course() {
        }

        public Course(int id, string title) {
            Id = id;
            Title = title;
        }

        public void AddLesson(Lesson item) {
            Lessons.Add(item);
        }
    }
}