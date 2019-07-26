package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Role> queryRoles() {
		// TODO Auto-generated method stub
		return roleMapper.queryRoles();
	}
	
	@Override
	public void saveRoleModule(String roleId, String[] moduleIds) {
		// TODO Auto-generated method stub
		roleMapper.deleteModuleIdByRoleId(roleId);
		roleMapper.saveRoleModule(roleId, moduleIds);
		
		
	}

}
