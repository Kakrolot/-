package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

@Service
public class UserServiceImpl implements UserService{
	//service≤„–Ë“™“¿¿µmapper≤„
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> queryUsers() {
		// TODO Auto-generated method stub
		return userMapper.queryUsers();
	}

	@Override
	public User queryManagerById(String userId) {
		// TODO Auto-generated method stub
		return userMapper.queryManagerById(userId);
	}

	@Override
	public void updateUserById(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUserById(user);
		
	}

	@Override
	public void updateUserInfoByid(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userMapper.updateUserInfoById(userInfo);
	}

	@Override
	public void updateStateById(int state, String[] userId) {
		// TODO Auto-generated method stub
		userMapper.updateStateById(state, userId);
		
	}

	@Override
	public void deleteUserById(String[] userId) {
		// TODO Auto-generated method stub
		userMapper.deleteUserById(userId);
	}

	@Override
	public void saveUserRole(String userId,String[] roleIds) {
		// TODO Auto-generated method stub
		userMapper.deleteUserRole(userId);
		userMapper.saveUserRole(userId, roleIds);
		
	}

	@Override
	public List<String> queryRoleIdByUserId(String userId) {
		// TODO Auto-generated method stub
		return userMapper.queryRoleIdByUserId(userId);
	}

	



	

}
