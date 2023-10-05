package com.lwp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lwp.model.Content;
import com.lwp.model.Pages;
@Repository
public interface ContentRepo extends JpaRepository<Content, Integer> {
	public List<Content> findAllByPage(Pages page);
}
