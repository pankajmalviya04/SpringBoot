package com.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
		new Topic("1", "james", "desc 1"),
		new Topic("2", "smith", "desc 2"),
		new Topic("3", "jonnny", "desc 3")
		));
	
	
	public List<Topic> getTopic() {
		return topics;
	}
	
	public Topic getTopicById(String id) {
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}
	public void updateTopic(Topic topic, String id) {
		for(int i=0;i<topics.size();i++)
		{
			Topic t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t-> t.getId().equals(id));
		
	}
		
}
