package com.atguigu.team.service;
/**
 * 
 * @Description自定义异常类
 * @author FLD
 * @version
 * @date 2020年3月15日上午9:49:55
 *
 */
public class TeamException extends Exception{
	static final long serialVersionUID = -338751124229948L;
	public TeamException() {
		super();
	}
	public TeamException(String msg) {
		super(msg);
	}
}
