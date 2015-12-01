package com.eshop.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView selectDataTable() throws SQLException {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		Sql sql = new Sql();
		modelandview.addObject("msg", sql.sqlSelect());
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
