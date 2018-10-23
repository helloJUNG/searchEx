package org.zziggu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zziggu.domain.Board;
import org.zziggu.domain.PageParam;
import org.zziggu.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("/board/*")
public class BoardController {

	private BoardService service;
	
	@GetMapping({"/read","/modify"})
	public void read(@ModelAttribute("pageObj")PageParam pageParam, Model model) {
		
		model.addAttribute("board", service.read(pageParam));
		
	}
	
	@PostMapping("/modify")
	public String modifyPost(Board board, PageParam pageParam, RedirectAttributes rttr) {
		
		int result = service.modify(board);
		
		rttr.addFlashAttribute("result", result == 1? "SUCCESS":"FAIL");
		
		return pageParam.getLink("redirect:/board/read");
	}
	
	
	@PostMapping("/remove")
	public String remove(PageParam pageParam, RedirectAttributes rttr) {
		
		int result = service.remove(pageParam);
		
		rttr.addFlashAttribute("result", result == 1? "SUCCESS":"FAIL");
		
		return "redirect:/board/list?page="+pageParam.getPage();
	}
	
	@GetMapping("/register")
	public void RegisterGet(){
		
	}
	
	@PostMapping("/register")
	public String RegisterPost(Board board, RedirectAttributes rttr) {
		
		int result = service.register(board);
		
		rttr.addFlashAttribute("result", result == 1? "SUCCESS":"FAIL");
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void getList(@ModelAttribute("pageObj")PageParam pageParam, Model model) {
		
		
		
		pageParam.setTotal(service.getTotal(pageParam));
		
		model.addAttribute("list",service.getList(pageParam));
		
	}
}
