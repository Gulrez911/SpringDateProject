package com.gul.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gul.dao.StudentRepository;
import com.gul.entity.Student;

@Controller
public class HomeController {

	@Autowired
	StudentRepository repo;

	@GetMapping("/")
	public ModelAndView view() {
		ModelAndView mav = new ModelAndView("index");
		Student student = new Student();
		mav.addObject("student", student);
		return mav;
	}

	@PostMapping("save")
	public ModelAndView save(@ModelAttribute("student") Student student) {
		ModelAndView mav = new ModelAndView("index");
		repo.save(student);
		Student student2 = new Student();
		mav.addObject("student", student2);
		return mav;
	}

	@GetMapping("/list")
	public ModelAndView list(@RequestParam(name = "page", required = false) Integer pno) {
		ModelAndView mav = new ModelAndView("listStudent");
		int pno2 = 0;
		if (pno != null) {
			pno2 = pno-1;
		}
		Pageable pageable = PageRequest.of(pno2, 4);
		Page<Student> page = repo.findAll(pageable);
		System.out.println("test list" + page.getContent());
//		List<Student> list = repo.findAll();
		mav.addObject("pageno",page.getTotalPages());
		mav.addObject("list", page.getContent());
		mav.addObject("next", pno2);
		return mav;
	}

	@GetMapping("/update")
	public ModelAndView update(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView("index");
		Optional<Student> student = repo.findById(id);
		mav.addObject("student", student);
		return mav;
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView("listStudent");
		repo.deleteById(id);
		
		Pageable pageable = PageRequest.of(0, 4);
		Page<Student> page = repo.findAll(pageable);
		System.out.println("test list" + page.getContent());
//		List<Student> list = repo.findAll();
		mav.addObject("pageno",page.getTotalPages());
		mav.addObject("list", page.getContent());
//		mav.addObject("next", pno2);
		
		
//		List<Student> list = repo.findAll();
//		mav.addObject("list", list);
		return mav;
	}
}
