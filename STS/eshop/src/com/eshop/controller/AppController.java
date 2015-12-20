package com.eshop.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import com.eshop.model.BackupDB;
import com.eshop.model.InsertDataTable;
import com.eshop.model.SelectDataTable;
import com.eshop.model.ShowTableDB;
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
	@Autowired
	BackupDB backupDB;
	@Autowired
	ShrinkDataDB shrinkDataDB;
	@Autowired
	ShowTableDB show;
	
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

	@RequestMapping("/backup")
	public ModelAndView backupDBView() {
		ModelAndView modelandview = new ModelAndView("backup");		
		return modelandview;
	}
	
	@RequestMapping("/BackupDB")
	public ModelAndView backupDB(@RequestParam(value = "path") String path) {
		ModelAndView modelandview = new ModelAndView("E-Shop");		
		backupDB.setPath(path);
		modelandview.addObject("msg", backupDB.backupResultOutput());
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
	
	@RequestMapping("/ShowTables")
	public ModelAndView show(){
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.setViewName("ShowTables");
		List<String>listTables=show.listTables();
		modelandview.addObject("listTables", listTables);
		modelandview.addObject("OptimizedTables",new ShowTableDB());
		return modelandview;
	}

	@RequestMapping("/ShrinkDataDB")
	public ModelAndView shrinkDataDB(@ModelAttribute("OptimizedTables") ShowTableDB optimizedTables) throws SQLException{
		ModelAndView modelandview = new ModelAndView("E-Shop");
		shrinkDataDB.setTablesToOptimize(optimizedTables.getTablesList());
		modelandview.addObject("listTables", shrinkDataDB.optimizeTables());	
		View view = new InternalResourceView( "/WEB-INF/shrink.jsp") ;
		modelandview.setView(view);
		return modelandview;
	}
}
