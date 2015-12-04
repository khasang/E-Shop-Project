package com.eshop.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.model.BackupDB;
import com.eshop.model.InsertDataTable;

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
		modelandview.addObject("msg", new BackupDB().backupResultOutput());
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

	@RequestMapping(value = ("/"), method = RequestMethod.GET)
	public String startPage() {
		InsertDataTable.getInstance().createDataTable();
		return "InsertData";
	}

	@RequestMapping("webshop/insertDataTable")
	public ModelAndView insertDataTable(@RequestParam(value = "name") String name,
			@RequestParam(value = "amount") String amount) {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		InsertDataTable insertData = InsertDataTable.getInstance();
		insertData.insertDataInTable(name, amount);
		modelandview.addObject("msg", insertData.getInsertResult());
		return modelandview;
	}

	@RequestMapping("webshop/SelectDataTable")
	public ModelAndView selectDataTable() throws SQLException {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		Sql sql = new Sql();
		modelandview.addObject("msg", sql.selectSupplierName());
		return modelandview;
	}

	@RequestMapping("webshop/ShrinkDataDB")
	public ModelAndView shrinkDataDB() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("msg", Sql.sqlCheck);
		return modelandview;
	}
}
