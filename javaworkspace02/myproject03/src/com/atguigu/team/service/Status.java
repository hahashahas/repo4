package com.atguigu.team.service;

/**
 * 
 * @Description 员工的状态
 * @author FLD
 * @version
 * @date 2020年3月14日上午10:40:27
 *
 */
public class Status {
	private final String NAME;

	private Status(String NAME) {
		this.NAME = NAME;
	}

	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOCATION = new Status("VOCATION");

	public String getNAME() {
		return NAME;
	}
	@Override
		public String toString() {
			return NAME;
		}
}
