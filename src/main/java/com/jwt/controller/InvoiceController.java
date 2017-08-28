package com.jwt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String listEmployee(Model model) throws IOException {
		InvoiceFormEntity invoiceDetails = new InvoiceFormEntity();
		ProductDetail prd = new ProductDetail();
		prd.setDescription("");
		List<ProductDetail> prds = new ArrayList<ProductDetail>();
		prds.add(prd);
		invoiceDetails.setProducts(prds);
		User user = new User();
		
		invoiceDetails.setUser(user);
		model.addAttribute("invoiceDetails", invoiceDetails);
		return "InvoiceFormExp";
	}

	@Valid
	@RequestMapping(value = "/saveInvoice", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@Valid @ModelAttribute("invoiceDetails") InvoiceFormEntity invoiceDetails, BindingResult bindingResult) {
		log.info("from jsp : " + invoiceDetails);
		if (bindingResult.hasErrors()) {
			log.info("validation error : " + invoiceDetails);
			return new ModelAndView("InvoiceFormExp");
		}

		invoiceService.addInvoiceRecord(invoiceDetails);
		return new ModelAndView("success");
	}
}
