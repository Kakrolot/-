package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Dept;

//专门执行sql语句
public interface DeptMapper {
	//查询列表
	public List<Dept> queryDepts();
	//更新状态:
	//参数一:state 参数二:deotId
	public void updateStateById(@Param(value="state") int state,
								@Param(value="deptId") String[] deptId);
	
	public void deleteById(String[] deptId);
	
	public void save(Dept dept);
	//保存按钮
	//主键冲突
	public Dept queryById(String deptId);
	
	public Dept queryDepartmentById(String deptId); 
	
	public void updateDepartmentById(Dept dept);
		
	
}
