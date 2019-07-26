package cn.tarena.ht.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Role;

public interface RoleService {
	public List<Role> queryRoles();
	//public void deleteModuleIdByRoleId(String roleId);
	public void saveRoleModule(String roleId,
			  String[] moduleIds);

}
