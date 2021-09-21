package com.jmu.uacs.user.enums;

public enum UserExceptionEnum {

	//相当于调用构造器
	USER_EXIST(1,"用户账号已经存在"),
	EMAIL_EXIST(2,"用户邮箱已经存在"),
	USER_SAVE_ERROR(3,"用户保存失败"),
	USER_UNEXIST(4,"用户不存在"),
	USER_PASSWORD_ERROR(5,"用户密码错误"),
	USER_TOKEN_INVALID(6,"用户token不合法"),
	USER_CLOSE(7,"用户为关闭状态");
	
	
	private int code;
	private String message;
	
	private UserExceptionEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
