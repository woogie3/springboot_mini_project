package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.example.demo.bean.Board;
import com.example.demo.dao.BoardMapper;
import com.example.demo.dao.PageMaker;

@Controller
public class BoardController {
	
	@Autowired
	BoardMapper boardMapper;
	
	
	
	@Bean
	public MultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
	
	
	//paging제어
	
	/*
	 * public void pagerobot(Model model) { int pagenum=1; PageMaker pagemaker = new
	 * PageMaker(); pagemaker.setTotalcount(boardMapper.pcount());//전체 게시글 개수를 지정한다.
	 * pagemaker.setPagenum(pagenum);//현재 페이지를 페이지 객체에 지정한다.-1을 해야 쿼리에서 사용할 수 있다.
	 * pagemaker.setCurrentblock(pagenum); // 현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
	 * pagemaker.setLastblock(pagemaker.getTotalcount());//마지막 블록 번호를 전체 게시글 수를 통해서
	 * 정한다.
	 * 
	 * pagemaker.prevnext(pagenum);//현재 페이지 번호로 화살표를 나타낼지 정한다.
	 * pagemaker.setStartPage(pagemaker.getCurrentblock());//시작 페이지를 페이지 블록 번호로 정한다.
	 * pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock());
	 * //마지막 페이지를 마지막 페이지 블록과 현재 블록 번호로 정한다.
	 * 
	 * List<Board> boardList = new ArrayList<Board>(); boardList =
	 * boardMapper.plist((pagemaker.getPagenum()*10)-9, pagemaker.getPagenum()*10);
	 * model.addAttribute("boardList",boardList);
	 * model.addAttribute("page",pagemaker); }
	 * 
	 * @RequestMapping("/board/boardList") public String test(Model model) {
	 * pagerobot(model); return "board/boardList"; }
	 * 
	 * 
	 * 
	 * @RequestMapping("/board/boardList1") public String test1(Model model ,int
	 * pagenum) {
	 * 
	 * PageMaker pagemaker = new PageMaker();
	 * pagemaker.setTotalcount(boardMapper.pcount());//전체 게시글 개수를 지정한다.
	 * pagemaker.setPagenum(pagenum);//현재 페이지를 페이지 객체에 지정한다.-1을 해야 쿼리에서 사용할 수 있다.
	 * pagemaker.setCurrentblock(pagenum); // 현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
	 * pagemaker.setLastblock(pagemaker.getTotalcount());//마지막 블록 번호를 전체 게시글 수를 통해서
	 * 정한다.
	 * 
	 * pagemaker.prevnext(pagenum);//현재 페이지 번호로 화살표를 나타낼지 정한다.
	 * pagemaker.setStartPage(pagemaker.getCurrentblock());//시작 페이지를 페이지 블록 번호로 정한다.
	 * pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock());
	 * //마지막 페이지를 마지막 페이지 블록과 현재 블록 번호로 정한다.
	 * 
	 * List<Board> boardList = new ArrayList<Board>(); boardList =
	 * boardMapper.plist((pagemaker.getPagenum()*10)-9, pagemaker.getPagenum()*10);
	 * model.addAttribute("boardList",boardList);
	 * model.addAttribute("page",pagemaker);
	 * 
	 * return "board/boardList1"; }
	 */
	@RequestMapping("Uploadgallery")
	public void Uploadgallery(@ModelAttribute("Board") Board board, Model model) {
		
	}
public void pagerobot2(Model model,int pagenum,int contentnum) {
		
		
		PageMaker pagemaker = new PageMaker();
		pagemaker.setTotalcount(boardMapper.pcount());//전체 게시글 개수를 지정한다.
		pagemaker.setPagenum(pagenum);//현재 페이지를 페이지 객체에 지정한다.-1을 해야 쿼리에서 사용할 수 있다.
		pagemaker.setContentnum(contentnum);
		pagemaker.setCurrentblock(pagenum); // 현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
		pagemaker.setLastblock(pagemaker.getTotalcount());//마지막 블록 번호를 전체 게시글 수를 통해서 정한다.
	
		pagemaker.prevnext(pagenum);//현재 페이지 번호로 화살표를 나타낼지 정한다.
		pagemaker.setStartPage(pagemaker.getCurrentblock());//시작 페이지를 페이지 블록 번호로 정한다.
		pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock());
		//마지막 페이지를 마지막 페이지 블록과 현재 블록 번호로 정한다.
		
		List<Board> boardList = new ArrayList<Board>();
		boardList = boardMapper.plist((pagemaker.getPagenum()*6)-5, pagemaker.getPagenum()*6);
		model.addAttribute("boardList1",boardList);
		model.addAttribute("page",pagemaker);
	}
	
	public void pagerobot2(Model model) {
		HttpServletRequest request = null; 
		String testnum = request.getParameter("pagenum");
		
		if(testnum==null) {
			testnum="1";
		}
		int contentnum = 6;
		int pagenum = Integer.parseInt(testnum);
		
		
		PageMaker pagemaker = new PageMaker();
		pagemaker.setTotalcount(boardMapper.pcount());//전체 게시글 개수를 지정한다.
		pagemaker.setPagenum(pagenum);//현재 페이지를 페이지 객체에 지정한다.-1을 해야 쿼리에서 사용할 수 있다.
		pagemaker.setCurrentblock(pagenum); // 현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
		pagemaker.setLastblock(pagemaker.getTotalcount());//마지막 블록 번호를 전체 게시글 수를 통해서 정한다.
		pagemaker.prevnext(pagenum);//현재 페이지 번호로 화살표를 나타낼지 정한다.
		pagemaker.setStartPage(pagemaker.getCurrentblock());//시작 페이지를 페이지 블록 번호로 정한다.
		pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock());
		pagemaker.setContentnum(contentnum);
		//마지막 페이지를 마지막 페이지 블록과 현재 블록 번호로 정한다.
		
		List<Board> boardList = new ArrayList<Board>();
		boardList = boardMapper.plist((pagemaker.getPagenum()*6)-5, pagemaker.getPagenum()*6);
		model.addAttribute("boardList",boardList);
		model.addAttribute("page",pagemaker);
	}
	@RequestMapping("/listL/boardList")
	public String test2(Model model) {
		pagerobot2(model);
		return "listL/boardList";
	}
	@RequestMapping("/listL/boardList1")
	public String test2(Model model ,@RequestParam(value = "pagenum")int pagenum, @RequestParam(value="contentnum")int contentnum) {
	
		PageMaker pagemaker = new PageMaker();
		pagemaker.setTotalcount(boardMapper.pcount());//전체 게시글 개수를 지정한다.
		pagemaker.setPagenum(pagenum);//현재 페이지를 페이지 객체에 지정한다.-1을 해야 쿼리에서 사용할 수 있다.
		pagemaker.setCurrentblock(pagenum); // 현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
		pagemaker.setLastblock(pagemaker.getTotalcount());//마지막 블록 번호를 전체 게시글 수를 통해서 정한다.
		pagemaker.setContentnum(contentnum);
		pagemaker.prevnext(pagenum);//현재 페이지 번호로 화살표를 나타낼지 정한다.
		pagemaker.setStartPage(pagemaker.getCurrentblock());//시작 페이지를 페이지 블록 번호로 정한다.
		pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock());
		//마지막 페이지를 마지막 페이지 블록과 현재 블록 번호로 정한다.
		
		List<Board> boardList = new ArrayList<Board>();
		boardList = boardMapper.plist((pagemaker.getPagenum()*6)-5, pagemaker.getPagenum()*6);
		model.addAttribute("pagenum",pagenum);
		model.addAttribute("contentnum",contentnum);
		model.addAttribute("boardList1",boardList);
		model.addAttribute("page",pagemaker);

		return "listL";
	}
	
	
	
	
	
	//board제어
	
	@RequestMapping("/board/updateForm")
	public String updateForm(Model model, int boardno) {
		model.addAttribute("board", boardMapper.getBoard(boardno));
		return "board/updateForm";
	}
	
	@RequestMapping(value = "/board/updateBoard", method = RequestMethod.POST)
	public String updateBoard(Board board) {
		boardMapper.updateBoard(board);
		return "redirect:/board/boardList";
	}
	@RequestMapping(value =  "/board/deleteBoard", method = RequestMethod.POST)
	public String deleteBoard(@RequestParam("boardno") String boardno) {
		System.out.println(boardno);
		int a = Integer.parseInt(boardno);
		boardMapper.deleteBoard(a);
		return "redirect:/board/boardList";
	}
	@RequestMapping("/board/getBoard")
	public String getBoard(Model model, int boardno) {
		boardMapper.updateCount(boardno);
		model.addAttribute("board", boardMapper.getBoard(boardno));
		return "board/boardView";
	}
	
	@RequestMapping("/search")
	public String search(Model model, String keyword, String searchType,
			@ModelAttribute("Board") Board board, @RequestParam(value = "pagenum", defaultValue = "1")int pagenum) {
		System.out.println(keyword);
		System.out.println(searchType);
		model.addAttribute("board",board);
		if(searchType.equals("boardtitle")) {
			model.addAttribute("boardlist1", boardMapper.searchTitle(keyword));
			System.out.println(boardMapper.searchTitle(keyword));
		} else if (searchType.equals("usid")) {
			model.addAttribute("boardlist1", boardMapper.searchUserid(keyword));
			System.out.println(boardMapper.searchUserid(keyword));
		}
		return "listL2";
	}
//	@GetMapping("listL/searching")
//	public void listL2(@ModelAttribute("Board") Board board, Model model, @RequestParam(value = "pagenum",defaultValue = "1")int pagenum, 
//			@RequestParam(value = "contentnum",defaultValue = "6")int contentnum) {
//		String boardtitle;
//		String userid;
//		model.addAttribute("board",board);
//		model.addAttribute("pagenum",pagenum);
//		model.addAttribute("contentnum",contentnum);
//		model.addAttribute("boardtitle",boardtitle);
//		model.addAttribute("userid",userid);
//		model.addAttribute("boardlist1", boardMapper.Stitle(boardtitle, pagenum, contentnum));
//		model.addAttribute("boardlist1", boardMapper.Wtitle(userid, pagenum, contentnum));
//		pagerobot2(model,pagenum,contentnum);
//		System.out.println(pagenum);
//		System.out.println(contentnum);
//	}
		
	@RequestMapping(value = "/board/insertA" , method = RequestMethod.POST)
	public String insertA(Board board) {
		boardMapper.updateGrouplayer(board.getGroupord(), board.getGrouplayer());
		boardMapper.insertA(board.getUserid(), board.getBoardtitle(), board.getBoardpw(), board.getContentp(), board.getOriginno(),board.getGroupord()+1, board.getGrouplayer()+1);
		return "redirect:/board/boardList";
	}
	@RequestMapping(value = "/board/insertQ" , method = RequestMethod.POST)
	public String insertQ(Board board) {
		boardMapper.insertQ(board);
		return "redirect:/board/boardList";
	}
	@RequestMapping("/board/insertForm")
	public String insertForm() {
		return "board/insertQ";
	}
	@RequestMapping("/board/boardList2")
	public String boardList2(Model model) {
		model.addAttribute("boardList", boardMapper.getBoardList());
		return "board/boardList";
	}

	@GetMapping("update")
	public void Update(@ModelAttribute("Board") Board board, Model model,HttpServletRequest request) {
		
		model.addAttribute("BoardNo",request.getParameter("BoardNo"));
		model.addAttribute("BoardPw", request.getParameter("BoardPw"));
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/updateU")
	public void UpdateD(@ModelAttribute("Board") Board board, Model model,HttpServletRequest request) {
		
		model.addAttribute("boardno",request.getParameter("boardno"));
		model.addAttribute("boardpw", request.getParameter("boardpw"));
	}

	@RequestMapping(value = "UpdateBoardD",method = RequestMethod.GET)
	public String updateBoardD(@ModelAttribute("Board") Board board, Model model, HttpServletRequest request) {

		board.setBoardtitle(request.getParameter("boardtitle"));
		board.setContentp(request.getParameter("contentp"));

		boardMapper.UpdateBoardD(board);

		return "redirect:listL";
	}
	
	
	@RequestMapping(value = "regg", method = RequestMethod.POST)
	public String reggallery(@RequestParam("Img") MultipartFile img, @ModelAttribute Board board, Model model,
			HttpServletRequest request) throws IllegalStateException, IOException {

		String fileName = img.getOriginalFilename();
		String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
		File destinationFile;
		String destinationFileName;
		String fileUrl = "/uploadFiles/";


		do {
			destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
			destinationFile = new File(request.getServletContext().getRealPath(fileUrl) + destinationFileName);

		} while (destinationFile.exists());

		destinationFile.getParentFile().mkdirs();

		String cut = fileUrl + destinationFileName;
		String cut1 = cut.substring(1);

		img.transferTo(destinationFile);

		board.setImagesrc(cut1);
		boardMapper.RegBoardD(board);

		System.out.println(cut1);
		System.out.println(img);
		System.out.println(destinationFile);	
		System.out.println(destinationFileName);
		return "redirect:listL";

	}

	@GetMapping("listL")
	public void listL(@ModelAttribute("Board") Board board, Model model, @RequestParam(value = "pagenum",defaultValue = "1")int pagenum, 
			@RequestParam(value = "contentnum",defaultValue = "6")int contentnum) {
	
		model.addAttribute("board",board);
		model.addAttribute("pagenum",pagenum);
		model.addAttribute("contentnum",contentnum);
		pagerobot2(model,pagenum,contentnum);
		model.addAttribute("boardlist1", boardMapper.lookingD(pagenum,contentnum));
		System.out.println(pagenum);
		System.out.println(contentnum);
	}
	@RequestMapping("listL")
	public String listL2(@ModelAttribute("Board") Board board, Model model, @RequestParam(value = "pagenum")int pagenum, 
			@RequestParam(value = "contentnum",defaultValue = "6")int contentnum) {
	
//		model.addAttribute("board",board);
//		model.addAttribute("pagenum",pagenum);
//		model.addAttribute("contentnum",contentnum);
//		pagerobot2(model,pagenum,contentnum);
//		model.addAttribute("boardlist1", boardMapper.lookingD(pagenum,contentnum));
//		System.out.println(pagenum);
//		System.out.println(contentnum);
//		
//		return "listL";
		PageMaker pagemaker = new PageMaker();
		pagemaker.setTotalcount(boardMapper.pcount());//전체 게시글 개수를 지정한다.
		pagemaker.setPagenum(pagenum);//현재 페이지를 페이지 객체에 지정한다.-1을 해야 쿼리에서 사용할 수 있다.
		pagemaker.setCurrentblock(pagenum); // 현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다.
		pagemaker.setLastblock(pagemaker.getTotalcount());//마지막 블록 번호를 전체 게시글 수를 통해서 정한다.
		pagemaker.setContentnum(contentnum);
		pagemaker.prevnext(pagenum);//현재 페이지 번호로 화살표를 나타낼지 정한다.
		pagemaker.setStartPage(pagemaker.getCurrentblock());//시작 페이지를 페이지 블록 번호로 정한다.
		pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock());
		//마지막 페이지를 마지막 페이지 블록과 현재 블록 번호로 정한다.
		
		List<Board> boardList = new ArrayList<Board>();
		boardList = boardMapper.plist((pagemaker.getPagenum()*6)-5, pagemaker.getPagenum()*6);
		model.addAttribute("pagenum",pagenum);
		model.addAttribute("contentnum",contentnum);
		model.addAttribute("boardList1",boardList);
		model.addAttribute("page",pagemaker);
		
		return "listL";
	}
	
	/*
	 * @GetMapping("/listL") public void listL(@ModelAttribute("Board") Board board,
	 * Model model, @RequestParam(value = "pagenum",defaultValue = "1")int pagenum,
	 * tyutytt
	 * @RequestParam(value = "contentnum",defaultValue = "10")int contentnum) {
	 * 
	 * 
	 * 
	 * model.addAttribute("pagenum",pagenum);
	 * model.addAttribute("cpoiuttyttyyttyontentnum",contentnum); model.addAttribute("boardlist1",
	 * boardMapper.lookingD(pagenum,contentnum)); pagerobot2(model);
	 * System.out.println(pagenum); System.out.println(contentnum); }
	 */
		
	@RequestMapping("deleteD")
	public String deleteD(@ModelAttribute("Board") Board board, Model model, HttpServletRequest request) {
		boardMapper.DeleteBoardD(board);
		return "redirect:listL";
	}

	@GetMapping("detail")
	public void detail(@ModelAttribute("Board") Board board, Model model, HttpServletRequest request) {

		String NUM = request.getParameter("boardno");
		board.setBoardtitle(NUM);
		boardMapper.updatecountp(board);
		model.addAttribute("boarddetail", boardMapper.detail(board));

	}

}
