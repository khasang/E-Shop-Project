package com.eshop.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		modelandview.addObject("msg", "You can buy different things at our shop!");
		return modelandview;
	}

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

	@RequestMapping("/BackupDB")
	public ModelAndView backupDB() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("result", new BackupDB().backupResultOutput());
		return modelandview;
	}

	@RequestMapping("describe")
	public ModelAndView describeView() {
		ModelAndView modelandview = new ModelAndView("describetable");
		modelandview.addObject("tablesInDB", selectDataTable.dataBaseAllTableName());
		return modelandview;
	}

	@RequestMapping(value = "describeTable", method = RequestMethod.POST)
	public ModelAndView describeTable(@RequestParam(value = "tablesInDB") String selectedTable) {
		ModelAndView modelandview = new ModelAndView("describetable");
		modelandview.addObject("tablesInDB", selectDataTable.dataBaseAllTableName());
		modelandview.addObject("listOfTableColumns", selectDataTable.getTableColumnName(selectedTable));
		return modelandview;
	}

	@RequestMapping("/ShowTables")
	public ModelAndView show() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.setViewName("ShowTables");
		List<String> listTables = show.listTables();
		modelandview.addObject("listTables", listTables);
		modelandview.addObject("OptimizedTables", new ShowTableDB());
		return modelandview;
	}

	//todo new
	@RequestMapping("/ShrinkDataDB")
	public ModelAndView shrinkDataDB(@ModelAttribute("OptimizedTables") ShowTableDB optimizedTables)
			throws SQLException { //todo fix Exception
		ModelAndView modelandview = new ModelAndView("E-Shop");
		shrinkDataDB.setTablesToOptimize(optimizedTables.getTablesList());
		modelandview.addObject("listTables", shrinkDataDB.optimizeTables());
		View view = new InternalResourceView("/WEB-INF/shrink.jsp");
		modelandview.setView(view);
		return modelandview;
	}
}
