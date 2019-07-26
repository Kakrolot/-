package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.pojo.Dept;
@Service
public class DeptServiceImpl implements DeptService{

	//ÐèÒªÒÀÀµ×¢Èëmapper
	@Autowired
	private DeptMapper deptMapper;
	@Override
	public List<Dept> queryDepts() {
		// TODO Auto-generated method stub
		return deptMapper.queryDepts();
	}
	@Override
	public void updateStateById(int state, String[] deptId) {
		// TODO Auto-generated method stub
		deptMapper.updateStateById(state, deptId);
	}
	@Override
	public void deleteBydeptId(String[] deptId) {
		// TODO Auto-generated method stub
		deptMapper.deleteById(deptId);
	}
	@Override
	public void save(Dept dept) {
		deptMapper.save(dept);
		
	}
	@Override
	public Dept queryById(String deptId) {
		// TODO Auto-generated method stub
		return deptMapper.queryById(deptId);
		
	}
	@Override
	public Dept queryDepartmentById(String deptId) {
		// TODO Auto-generated method stub
		return deptMapper.queryDepartmentById(deptId);
	}
	@Override
	public void updateDepartmentById(Dept dept) {
		// TODO Auto-generated method stub
		deptMapper.updateDepartmentById(dept);
	}
	

}
