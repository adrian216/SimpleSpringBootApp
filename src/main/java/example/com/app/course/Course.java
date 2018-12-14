package example.com.app.course;

import example.com.app.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {

    @Id
    private String ID;
    private String name;
    private String description;

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @ManyToOne
    private Topic topic;


    public Course() {

    }
    public Course(String ID, String name, String description,String topicID) {
        this.topic = new Topic(topicID,"","");
        this.name = name;
        this.ID = ID;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }
}
