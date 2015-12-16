package com.eshop.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.eshop.model.BackupDB;
import com.eshop.model.InsertDataTable;
import com.eshop.model.SelectDataTable;
import com.eshop.model.DeleteDataTable;
import com.eshop.model.CreateDataTable;
import com.eshop.model.ShrinkDataDB;

@Controller
public class AppController {
	
	@Autowired
	InsertDataTable insertDataTable;
	@Autowired
	CreateDataTable createDataTable;
	@Autowired
	DeleteDataTable deleteDataTable;
	@Autowired
	SelectDataTable selectDataTable;

	@RequestMapping("/")
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

	@RequestMapping("createtable")
	public String createTableView() {
		return "createtable";
	}

	@RequestMapping("createDataTable")
	public ModelAndView createDataTable(@RequestParam(value = "tableName") String tableName) {
		ModelAndView modelandview = new ModelAndView("createtable");
		createDataTable.createDataTable(tableName);
		modelandview.addObject("result", createDataTable.getResult());
		return modelandview;
	}

	@RequestMapping("webshop/CreateDataTable")
	public ModelAndView createDataTable() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("msg", CreateDataTable.class);
		return modelandview;
	}

	@RequestMapping("insertdata")
	public ModelAndView insertDataView() {
		ModelAndView modelandview = new ModelAndView("insertdata");
		return modelandview;
	}

	@RequestMapping("insertDataTable")
	public ModelAndView insertDataTable(@RequestParam(value = "tableName") String tableName,
			@RequestParam(value = "name") String name, @RequestParam(value = "amount") String amount) {
		ModelAndView modelandview = new ModelAndView("insertdata");
		insertDataTable.insertDataInTable(tableName, name, amount);
		modelandview.addObject("result", insertDataTable.getResult());
		return modelandview;
	}

	@RequestMapping("selectdata")
	public ModelAndView selectDataView() {
		ModelAndView modelandview = new ModelAndView("selectdatatable");
		return modelandview;
	}

	@RequestMapping("selectDataTable")
	 public ModelAndView selectDataTable(@RequestParam(value = "tableName") String tableName) {
	  ModelAndView modelandview = new ModelAndView("selectdatatable");
	  modelandview.addObject("list", selectDataTable.viewTable(tableName));
	  return modelandview;
	 }

	@RequestMapping("webshop/ShrinkDataDB")
	public ModelAndView shrinkDataDB() throws SQLException{
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("msg", new ShrinkDataDB().shrinkDataDB());
		return modelandview;
	}
}
