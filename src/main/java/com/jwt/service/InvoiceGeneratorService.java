package com.jwt.service;

import com.jwt.exception.InvoiceGeneratorInternalException;
import com.jwt.model.InvoiceFormEntity;
import com.jwt.model.User;

public interface InvoiceGeneratorService {

	void addInvoiceRecord(InvoiceFormEntity invoiceForm)throws InvoiceGeneratorInternalException;

}
