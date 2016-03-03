package com.eshop.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.eshop.entity.User;
import com.eshop.model.*;
import com.eshop.repository.*;
import com.eshop.service.PasswordValidator;

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
	ShrinkDataDB shrinkDataDB;
	@Autowired
	ShowTableDB show;
	@Autowired
	BackupDB backup;
	@Autowired
	PasswordValidator passwordValidator;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BasketRepository basketRepository;

	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping("registration")
	public ModelAndView registration() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("User", new User());
		modelandview.setViewName("registration");
		return modelandview;
	}

	@RequestMapping("/")
	public ModelAndView inputForm() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.addObject("result", "Welcome to our Eshop project!");
		return modelandview;
	}

	@RequestMapping("adduser")
	public ModelAndView registerUser(@ModelAttribute("User") User newUser, BindingResult result) {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		passwordValidator.validate(newUser, result);
		if (!result.hasErrors()) {
			try {
				userRepository.save(newUser);
				modelandview.addObject("result", "User " + newUser.getLogin() + " successfully added");
			} catch (DataIntegrityViolationException e) {
				result.reject("user.exists", "User already exists");
			}
		}
		modelandview.setViewName("registration");
		return modelandview;
	}

	@RequestMapping("basket")
	public ModelAndView viewBasket(Principal principal) {
		ModelAndView modelandview = new ModelAndView("basket");
		String login = principal.getName();
		User user = userRepository.findByLogin(login);
		modelandview.addObject("listBasket", basketRepository.findByUser(user));
		return modelandview;
	}

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

	@RequestMapping("insertdatatable")
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
		modelandview.addObject("tableTitleList", selectDataTable.dataBaseAllTableName());
		return modelandview;
	}

	@RequestMapping("selectDataTable")
	public ModelAndView selectDataTable(@RequestParam(value = "tableTitleList") String tableName) {
		ModelAndView modelandview = new ModelAndView("selectdatatable");
		modelandview.addObject("tableTitleList", selectDataTable.dataBaseAllTableName());
		modelandview.addObject("list", selectDataTable.viewTable(tableName));
		return modelandview;
	}

	@RequestMapping("/admin/manageusers")
	public ModelAndView manageusers() {
		ModelAndView modelandview = new ModelAndView("manageusers");
		User user = new User();
		modelandview.addObject("User", user);
		modelandview.addObject("listUserRoles", user.getRolesValues());
		modelandview.addObject("listUsers", userRepository.findAll());
		return modelandview;
	}

	@RequestMapping("/admin/updateRole")
	public String updaterole(@ModelAttribute("User") User user) {
		System.out.println("login =");
		userRepository.setRole(user.getLogin(), user.getRole());
		return "redirect:/admin/manageusers";
	}

	@RequestMapping("/admin/backup")
	public ModelAndView backupDBView() {
		ModelAndView modelandview = new ModelAndView("backup");
		return modelandview;
	}

	@RequestMapping("/admin/BackupDB")
	public ModelAndView backupDB(@RequestParam(value = "path") String path) {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		backup.setPath(path);
		modelandview.addObject("result", backup.backupResultOutput());
		return modelandview;
	}

	@RequestMapping("/admin/describe")
	public ModelAndView describeView() {
		ModelAndView modelandview = new ModelAndView("describetable");
		modelandview.addObject("tablesInDB", selectDataTable.dataBaseAllTableName());
		return modelandview;
	}

	@RequestMapping(value = "/admin/describeTable", method = RequestMethod.POST)
	public ModelAndView describeTable(@RequestParam(value = "tablesInDB") String selectedTable) {
		ModelAndView modelandview = new ModelAndView("describetable");
		modelandview.addObject("tablesInDB", selectDataTable.dataBaseAllTableName());
		modelandview.addObject("listOfTableColumns", selectDataTable.getTableColumnName(selectedTable));
		return modelandview;
	}

	@RequestMapping("/admin/showtables")
	public ModelAndView show() {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		modelandview.setViewName("/showtables");
		List<String> listTables = show.listTables();
		modelandview.addObject("listTables", listTables);
		modelandview.addObject("OptimizedTables", new ShowTableDB());
		return modelandview;
	}

	@RequestMapping("/admin/ShrinkDataDB")
	public ModelAndView shrinkDataDB(@ModelAttribute("OptimizedTables") ShowTableDB optimizedTables) {
		ModelAndView modelandview = new ModelAndView("E-Shop");
		shrinkDataDB.setTablesToOptimize(optimizedTables.getTablesList());
		modelandview.addObject("listTables", shrinkDataDB.optimizeTables());
		modelandview.setViewName("shrink");
		return modelandview;
	}
}
