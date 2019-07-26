package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

public interface UserService {
	//≤È—Ø¡–±Ì
	public List<User> queryUsers();
	public User queryManagerById(String userId);
	public void updateUserById(User user);
	public void updateUserInfoByid(UserInfo userInfo);
	public void updateStateById(int state,String[] userId);
	public void deleteUserById(String[] userId);
	public void saveUserRole(String userId,String[] roleIds);
	public List<String> queryRoleIdByUserId(String userId);

}
