package com.masai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.masai.exception.EntryException;
import com.masai.model.CountAndEntries;
import com.masai.model.DTO;
import com.masai.model.Entry;

@RestController
public class MainController {
	
	@Autowired
	private RestTemplate rt;
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<DTO>> getEntriesByCategory(@PathVariable("category") String category) throws EntryException{
		
		CountAndEntries ce=rt.getForObject("https://api.publicapis.org/entries", CountAndEntries.class);
		
		List<Entry> entryList=ce.getEntries();
		
		List<DTO> dtoList = new ArrayList<>();
		
		for(Entry e:entryList) {
			
			if(e.getCategory().equals(category))
				dtoList.add(new DTO(e.getApi(), e.getDescription()));
		}
		
		return new ResponseEntity<List<DTO>>(dtoList,HttpStatus.OK);
		
	}
	
}
