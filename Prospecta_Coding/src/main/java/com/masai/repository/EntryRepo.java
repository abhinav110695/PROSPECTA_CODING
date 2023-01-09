package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Entry;

@Repository
public interface EntryRepo extends JpaRepository<Integer, Entry> {

}
