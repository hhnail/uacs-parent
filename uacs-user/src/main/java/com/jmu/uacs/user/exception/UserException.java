package com.jmu.uacs.user.exception;

import com.jmu.uacs.user.enums.UserExceptionEnum;

//默认RuntimeException异常触发事务回滚
public class UserException extends RuntimeException {

	public UserException() {
	}

	public UserException(UserExceptionEnum enums) {
		super(enums.getMessage());
	}
}