package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;

public class TeamService {
	private static int count = 1;// 给memberid赋值
	private final int MAX_MEMBER = 5;
	private Programmer[] team = new Programmer[MAX_MEMBER];// 保存开发成员
	private int total;// 记录开发团队中实际人数

	public TeamService() {
		super();
	}

	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < team.length; i++) {
			team[i] = this.team[i];
		}
		return team;
	}

	public void addMember(Employee e) throws TeamException {
		if(total>=MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发成员，无法添加");
		}
		if(isExist(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}
		Programmer p=(Programmer)e;
		if("BUSY".equals(p.getStatus().getNAME())){
			throw new TeamException("该员工已是某团队成员");
		}else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {//可以忽略大小写
			throw new TeamException("该员工正在休假");
		}
		
		int numOfArch=0,numOfDes=0,numOfPro=0;
		for(int i=0;i<total;i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
			}else if(team[i] instanceof Designer) {
				numOfDes++;
			}else {
				numOfPro++;
			}
		}
		if(p instanceof Architect) {
			if(numOfArch>=1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		}else if(p instanceof Designer) {
			if(numOfDes>=2) {
				throw new TeamException("团队中至多只能有两名设计师");
			}
		}else {
			if(numOfPro>=3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}
		team[total++]=p;
		p.setStatus(Status.BUSY);
		p.setMemberId(count++);
	}
	
	
	
	
	private boolean isExist(Employee e) {
		for(int i=0;i<total;i++) {
			if(team[i].getId()==e.getId()) {
				return true;
			}
		}
		return false;
	}
	
	public void removeMember(int memberId) throws TeamException {
		int i;
		for(i=0;i<total;i++) {
			if(team[i].getMemberId()==memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		if(i==total) {
			throw new TeamException("找不到指定memberId的员工，删除失败");
		}
		for(int j=i+1;j<total;j++) {
			team[j-1]=team[j];
		}
		team[--total]=null;
		
	}

}
