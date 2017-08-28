package com.jwt.exception;

public class InvoiceGeneratorInternalException extends Exception {
	private static final long serialVersionUID = 1L;

	private String errCode;
	private String errMsg;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public InvoiceGeneratorInternalException(String errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	

}
