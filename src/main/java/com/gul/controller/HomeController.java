package com.gul.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gul.dao.StudentRepository;
import com.gul.entity.Student;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

@Controller
public class HomeController {

	@Autowired
	StudentRepository repo;

	@GetMapping("/")
	public ModelAndView view() {
		ModelAndView mav = new ModelAndView("index");
		Student student = new Student();
		List<String> hobbies = new ArrayList<>();
		hobbies.add("Reading");
		hobbies.add("Internet Surfing");
		hobbies.add("Horse Riding");
		mav.addObject("hobbies", hobbies);
		mav.addObject("student", student);
		return mav;
	}

	@PostMapping("save")
	public ModelAndView save(@ModelAttribute("student") Student student,@RequestParam("file") MultipartFile file) throws IOException {
		ModelAndView mav = new ModelAndView("index");
		Student student2 = new Student();
		System.out.println("..............");
		student.setDocName(file.getOriginalFilename());
		student.setDocument(file.getBytes());
		repo.save(student);
		List<String> hobbies = new ArrayList<>();
		hobbies.add("Reading");
		hobbies.add("Internet Surfing");
		hobbies.add("Horse Riding");
		mav.addObject("hobbies", hobbies);
		mav.addObject("student", student2);
		return mav;
	}

	@GetMapping("/list")
	public ModelAndView list(@RequestParam(name = "page", required = false) Integer pno) {
		ModelAndView mav = new ModelAndView("listStudent");
		int pno2 = 0;
		if (pno != null) {
			pno2 = pno - 1;
		}
		Pageable pageable = PageRequest.of(pno2, 4);
		Page<Student> page = repo.findAll(pageable);
		System.out.println("test list" + page.getContent());
//		List<Student> list = repo.findAll();
		mav.addObject("pageno", page.getTotalPages());
		mav.addObject("list", page.getContent());
		mav.addObject("next", pno2);
		return mav;
	}

	@GetMapping("/update")
	public ModelAndView update(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView("index");
		List<String> hobbies = new ArrayList<>();
		hobbies.add("Reading");
		hobbies.add("Internet Surfing");
		hobbies.add("Horse Riding");
		mav.addObject("hobbies", hobbies);
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
		mav.addObject("pageno", page.getTotalPages());
		mav.addObject("list", page.getContent());
//		mav.addObject("next", pno2);

//		List<Student> list = repo.findAll();
//		mav.addObject("list", list);
		return mav;
	}
	
//	fetch Documents from database
	
	@GetMapping("/download/{documentId}")
	public String download(@PathVariable("documentId")
			Integer documentId, HttpServletResponse response) {
		
		Student doc = repo.getDocument(documentId);
		try {
			InputStream inputStream = new  ByteArrayInputStream(doc.getDocument());
			OutputStream out = response.getOutputStream();
			IOUtils.copy(inputStream, out);
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return null;
	}
}
