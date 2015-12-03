package com.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.model.DataTable;
import com.eshop.model.SelectDataTable;
import com.eshop.model.*;

@Controller
public class AppController {
	@RequestMapping("/webshop")
	public ModelAndView inputForm() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("msg", "You can buy different things at our shop!");
		return modelandview;
	}

	@RequestMapping("webshop/welcome")
	public ModelAndView hello() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("msg", "You can buy different things at our shop!");
		return modelandview;
	}

	@RequestMapping("webshop/BackupDB")
	public ModelAndView backupDB() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("msg", Sql.sqlCheck);
		return modelandview;
	}
	
	@RequestMapping("webshop/CreateDataTable")
	public ModelAndView createDataTable() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("msg", Sql.sqlCheck);
		return modelandview;
	}
	
	@RequestMapping("webshop/DeleteDataTable")
	public ModelAndView deleteDataTable() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("msg", Sql.sqlCheck);
		return modelandview;
	}
	
	@RequestMapping("webshop/DescribeTableInfoColumns")
	public ModelAndView describeTableInfoColumns() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("msg", Sql.sqlCheck);
		return modelandview;
	}
	
	@RequestMapping("webshop/insertDataTable")
	public ModelAndView insertDataTable() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("msg", Sql.sqlCheck);
		return modelandview;
	}
	
	@RequestMapping("webshop/SelectDataTable")
	public ModelAndView selectDataTable() {
		ModelAndView modelandview = new ModelAndView("SelectDataTable");
		SelectDataTable selectDataTable = new SelectDataTable();
		//modelandview.addObject("msg", Sql.sqlCheck);
		String[] array = {"dd", "ff"};
		modelandview.addObject("list", selectDataTable.list);
		modelandview.addObject("array", array);
		for(DataTable dt: selectDataTable.list){
			System.out.println("ID = " + dt.getID() + " | " + dt.getMinute() + " | " + dt.getColor());
		}
		return modelandview;
	}
	
	@RequestMapping("webshop/ShrinkDataDB")
	public ModelAndView shrinkDataDB() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		//new
		modelandview.addObject("msg", Sql.sqlCheck);
		return modelandview;
	}
}
