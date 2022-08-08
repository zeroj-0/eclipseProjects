package com.varxyz.spr.cafe.menu.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.varxyz.spr.cafe.menu.domain.MenuCategory;
import com.varxyz.spr.cafe.menu.domain.MenuItem;
import com.varxyz.spr.cafe.menu.domain.MenuItemCommand;
import com.varxyz.spr.cafe.menu.service.MenuCategoryService;
import com.varxyz.spr.cafe.menu.service.MenuService;

@Controller("menu.controller.addMenuItemController")
public class AddMenuItemController {
	
//	private static final String SAVE_DIR = "C:/JAVA_lgm/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/cafe/resources/img/";
	private static final String SAVE_DIR = "/Users/zeroj/yeongjeong/Study/eclipseProjects/cafe/out/artifacts/jv330_war_exploded/resources/img/";

	@Autowired
	private MenuService menuService;
	@Autowired
	private MenuCategoryService menuCategoryService;
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/management/add_menuItem")
	public String addMenuItemForm(Model model) {
		model.addAttribute("menuItem", new MenuItemCommand());
		List<MenuCategory> categoryList = menuCategoryService.getMenuCategory();
		List<MenuCategory> categoryMainTitleList = menuCategoryService.getMenuCategoryMainTitle();
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("categoryMainTitleList", categoryMainTitleList);
		
		return "cafe/management/add_menuItem";
	}
	
	@PostMapping("/management/add_menuItem")
	public String addMenuItem(HttpServletRequest request, HttpServletResponse response, Model model, @RequestPart("imgURL") MultipartFile multifile) throws IOException, ServletException{
		
		// parameter 값 받아오기
		String mainTitle = request.getParameter("mainTitle");
		String subTitle = request.getParameter("subTitle");
		String name = request.getParameter("name");
		double cost = Double.parseDouble(request.getParameter("cost"));
		String explanation = request.getParameter("explanation");
		
		// menuItemcommand에다가 값 넣어주기
		MenuItemCommand menuItem = new MenuItemCommand();
		menuItem.setMainTitle(mainTitle);
		menuItem.setSubTitle(subTitle);
		menuItem.setName(name);
		menuItem.setCost(cost);
		menuItem.setExplanation(explanation);
		menuItem.setImgURL(multifile.getOriginalFilename());
		
		// 유효성 검사
		List<String> err = new ArrayList<String>();
		if(menuItem.getMainTitle() == null || menuItem.getMainTitle().length() == 0) {
			err.add("대분류를 입력하지 않으셨습니다.");
		}
		if (menuItem.getSubTitle() == null || menuItem.getSubTitle().length() == 0) {
			err.add("소분류를 입력하지 않으셨습니다.");
		}
		if (menuItem.getName() == null || menuItem.getName().length() == 0) {
			err.add("상품명을 입력하지 않으셨습니다.");
		}
		if (menuItem.getImgURL() == null || menuItem.getImgURL().length() == 0) {
			err.add("사진 선택하지 않으셨습니다.");
		}
		
		if(err.size() > 0) {
			model.addAttribute("error", err);
			return "/error/category";
		}

		
		// 파일 만들기
		File saveDir = new File(SAVE_DIR);
		// 파일 경로 확인 없으면 만들어줌
		if(!saveDir.exists()) {
			saveDir.mkdir();
		}

		// 업로드한 파일로 새로운 파일 만들어서 경로에다가 복사해주기
		File a = new File(saveDir.getPath()+ File.separator + multifile.getOriginalFilename());
		// 복사해주는 메소드
		multifile.transferTo(a);
		
		// attribute에 저장
		model.addAttribute("menuItem", menuItem);
		
		// 메인카테고리랑 서브카테고리를 이용해 카테고리 pk 불러오기
		MenuCategory category = menuCategoryService.getCidByMainTitleSubTitle(mainTitle, subTitle);
		menuItem.setMenucategory(category);
		
		
		menuService.addMenuItem(menuItem);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.println("<script>alert('정상처리 되었습니다.');location.href='/cafe/management/add_menuItem';</script>"); // 경고창 띄우기
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/cafe/management/add_menuItem";
	}
	
	

}
