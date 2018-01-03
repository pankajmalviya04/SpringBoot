package com.springboot.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value="/topics")
	public List<Topic> getAllTopics() {
		return topicService.getTopic();
		 
	}
	
	@RequestMapping(value="/topics/{id}")
	public Topic getTopicById(@PathVariable ("id") String id) {
		return topicService.getTopicById(id);
		 
	}
	
	@PostMapping(value="/add")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@PutMapping(value="/update/{id}")
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		topicService.updateTopic(topic, id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}
