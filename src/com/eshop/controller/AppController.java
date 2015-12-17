package com.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping("orderslist")
	public ModelAndView orderListView() {
		ModelAndView modelandview = new ModelAndView("orders");
		modelandview.addObject("list", selectDataTable.viewTable("product"));
		modelandview.addObject("tableTitleList", selectDataTable.getTableColumnName("product"));
		return modelandview;
	}

	@RequestMapping(value = "deleteOrder", method = RequestMethod.POST)
	public ModelAndView orderListDeleteItem(@RequestParam(value = "orderName") String selectedOrderId) {
		deleteDataTable.deleteDataFromTable(selectedOrderId);
		ModelAndView modelandview = new ModelAndView("orders");
		modelandview.addObject("list", selectDataTable.viewTable("product"));
		modelandview.addObject("tableTitleList", selectDataTable.getTableColumnName("product"));
		return modelandview;
	}

	@RequestMapping(value = "insertOrder", method = RequestMethod.POST)
	public ModelAndView orderListAddOrder(@RequestParam(value = "orderName") String orderName) {
		insertDataTable.insertDataInTable(orderName);
		ModelAndView modelandview = new ModelAndView("orders");
		modelandview.addObject("list", selectDataTable.viewTable("product"));
		modelandview.addObject("tableTitleList", selectDataTable.getTableColumnName("product"));
		return modelandview;
	}

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
		modelandview.addObject("tableTitleList", selectDataTable.dataBaseAllTableName());
		return modelandview;
	}

	@RequestMapping("insertDataTable")
	public ModelAndView insertDataTable(@RequestParam(value = "tableTitleList") String tableName,
			@RequestParam(value = "name") String name, @RequestParam(value = "amount") String amount) {
		ModelAndView modelandview = new ModelAndView("insertdata");
		insertDataTable.insertDataInTable(tableName, name, amount);
		modelandview.addObject("tableTitleList", selectDataTable.dataBaseAllTableName());
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
	
	@RequestMapping("describeTable")
	public ModelAndView describeTableView() {
		ModelAndView modelandview = new ModelAndView("describetable");
		return modelandview;
	}
	
	@RequestMapping("describeTableInfoColumns")
	public ModelAndView describeTableInfoColumns(@RequestParam(value = "submit") String submit) {
		ModelAndView modelandview = new ModelAndView("describetable");
		// работа с данными из .jsp файла ... modelandview.addObject(...);
		return modelandview;
	}
}