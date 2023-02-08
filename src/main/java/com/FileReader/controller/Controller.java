package com.FileReader.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.FileReader.excelGenerator.ExcelGenerator;
import com.FileReader.model.Customer;
import com.FileReader.service.CustomerService;



@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private CustomerService service;

	@RequestMapping(path = "/getdata")
	public void setDataInDB() {
		service.saveCustomerData();
	}
    @RequestMapping(value = "/show")
    public String viewHomePage(Model model) {
        List<Customer> listcustomer = service.listAll();
        model.addAttribute("listcustomer", listcustomer);
        System.out.print("listcustomer");
        return "index";
    }
    @GetMapping("/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Customer" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List <Customer> listCustomers = service.listAll();
        ExcelGenerator generator = new ExcelGenerator(listCustomers);
        generator.generateExcelFile(response);
    }
}
