package com.jwt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.InvoiceFormEntity;
import com.jwt.model.ProductDetail;
import com.jwt.model.User;
import com.jwt.service.InvoiceGeneratorService;
import com.jwt.service.UserService;

@Controller
public class InvoiceController {

	private static final Logger log = Logger.getLogger(InvoiceController.class);

	@Autowired
	UserService userService;
	
	@Autowired
	InvoiceGeneratorService invoiceService;

	@RequestMapping(value = "/invoiceForm")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		// User user = new User();
		InvoiceFormEntity invoiceDetails = new InvoiceFormEntity();
		ProductDetail prd = new ProductDetail();
		prd.setDescription("");
		List<ProductDetail> prds = new ArrayList<ProductDetail>();
		prds.add(prd);
		invoiceDetails.setProducts(prds);
		User user = new User();
		//user.setName("name");
		invoiceDetails.setUser(user);
		model.addObject("invoiceDetails", invoiceDetails);
		model.setViewName("InvoiceFormExp");
		return model;
	}

	@RequestMapping(value = "/saveInvoice", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute InvoiceFormEntity invoiceForm) {
		log.info("from jsp : "+invoiceForm);
		//User user=getUserFromInvoiceForm(invoiceForm)
		invoiceService.addInvoiceRecord(invoiceForm);
		return new ModelAndView("success");
	}

}
