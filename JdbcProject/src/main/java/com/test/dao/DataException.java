package com.test.dao;

public class DataException  extends Exception{
	
	private String errCode;
	private String errMsg;
	
	public DataException(String errCode,String errMsg){
		super(errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

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

	@Override
	public String toString() {
		return "DataException [errCode=" + errCode + ", errMsg=" + errMsg
				+ "]";
	}
}
