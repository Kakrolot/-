package cn.tarena.ht.service;

import java.util.List;



import cn.tarena.ht.pojo.Dept;

public interface DeptService {
	//查询列表
	public List<Dept> queryDepts();
	public void updateStateById(int state,String[] deptId);
	public void deleteBydeptId(String[] deptId);
	public void save(Dept dept);
	//保存按钮
	//主键冲突
	public Dept queryById(String deptId);
	//查看部门
	public Dept queryDepartmentById(String deptId);
	//修改部门确认按钮
	public void updateDepartmentById(Dept dept);

}
