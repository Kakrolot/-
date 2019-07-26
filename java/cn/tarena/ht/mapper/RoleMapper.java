package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.tarena.ht.pojo.Role;

//专门用于访问和增删改查数据库
public interface RoleMapper {
	//只能用在简单的sql语句查询
	//最好用来查单表数据
	@Select("select *, role_id as id,'' as p_id from role_p")
	//@Update("")
	//@Insert("")
	//@Delete("")
	public List<Role> queryRoles();
	//删除中间表role_module_p
	public void deleteModuleIdByRoleId(String roleId);
	//批量插入中间表
	public void saveRoleModule(@Param("roleId")String roleId,
							   @Param("moduleIds")String[] moduleIds);
}
