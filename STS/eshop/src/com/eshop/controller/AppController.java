package com.eshop.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.eshop.model.*;

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
		modelandview.addObject("result", "Welcome to our Eshop project!");
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

	@RequestMapping("deletetable")
	public String deleteTableView() {
		return "deletetable";
	}

	@RequestMapping("deleteDataTable")
	public ModelAndView deleteDataTable(@RequestParam(value = "tableName") String tableName) {
		ModelAndView modelandview = new ModelAndView("deletetable");
		deleteDataTable.dropDataTable(tableName);
		modelandview.addObject("result", deleteDataTable.getResult());
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

	@RequestMapping("backupdb")
	public ModelAndView backupDB() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("result", new BackupDB().backupResultOutput());
		return modelandview;
	}

	@RequestMapping("shrinkdatadb")
	public ModelAndView shrinkDataDB() throws SQLException {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		//ShrinkDataDB sh = (ShrinkDataDB) context.getBean("shrink");
		modelandview.addObject("result", new ShrinkDataDB().shrinkDataDB());
		return modelandview;
	}

	// @RequestMapping("webshop/DescribeTableInfoColumns")
	// public ModelAndView describeTableInfoColumns() {
	// ModelAndView modelandview = new ModelAndView("E-Shop");
	// return modelandview;
	// }
	// @RequestMapping("webshop/ShrinkDataDB")
	// public ModelAndView shrinkDataDB() {
	// ModelAndView modelandview = new ModelAndView("E-Shop");
	// modelandview.addObject("msg", new ShrinkDataDB().shrinkDataDB());
	// return modelandview;
	// }
}