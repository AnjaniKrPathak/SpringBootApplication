package io.anjani.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	private List<Topic> topics=new ArrayList<Topic>(Arrays.asList(
			new Topic("Spring","Spring Framework","Spring Boot App"),
			new Topic("Hibernate","Hibernate Framework","Hibernate 5"),
			new Topic("Java","Java 8","Lameda Expersioon"),
			new Topic("JS","Angular Js","JS Application")
			));
	public List<Topic> getAllTopic(){
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return  topics;
	}
	
	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Topic getTopic(String id){
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
		
		
	}

}
