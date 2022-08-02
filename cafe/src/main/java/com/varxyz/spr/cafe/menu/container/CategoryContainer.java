package com.varxyz.spr.cafe.menu.container;

import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.varxyz.spr.cafe.menu.domain.MenuCategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component("categoryConatiner")
@SessionAttributes
public class CategoryContainer {
	private List<MenuCategory> categoryList;
}
