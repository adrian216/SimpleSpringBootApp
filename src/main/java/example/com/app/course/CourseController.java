package example.com.app.course;

import example.com.app.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return  courseService.getAllCourses(id);
    }

    @RequestMapping("topics/{topicID}/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @PostMapping( value="/topics/{topicID}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicID) {
        course.setTopic(new Topic(topicID,"",""));
        courseService.addCourse(course);
    }

    @PutMapping(value="/topics/{topicID}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicID) {
        course.setTopic(new Topic(topicID,"",""));
        courseService.updateCourse(course);
    }

    @DeleteMapping(value="/topics/{topicID}/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
