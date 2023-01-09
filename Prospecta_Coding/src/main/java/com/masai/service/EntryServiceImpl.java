package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Entry;
import com.masai.repository.EntryRepo;

@Service
public class EntryServiceImpl implements EntryService {
	
	@Autowired
	private EntryRepo er;
	
	@Override
	public Entry saveEntries(Entry entry) {
		//Entry e=er.save(entry);
		
		return null;
	}
	
}
