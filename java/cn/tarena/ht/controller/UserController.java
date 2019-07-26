package cn.tarena.ht.controller;

import java.io.IOException;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserService;

@Controller
@RequestMapping("/sysadmin/user/")
public class UserController extends BaseController{
	//成员变量依赖注入service层
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private RoleService roleService;
	
	//1.用户管理的定位列表页面
	@RequestMapping("list")
	public String toListJSP(Model model) {
		
		
		//先查询数据库
		List<User> list = userService.queryUsers();
		
		//model进行数据的封装
		model.addAttribute("userList",list);
		
		return "/sysadmin/user/jUserList";
	}
	
	//2.部门管理的定位查看页面
	@RequestMapping("toViewJSP")
	public String toViewJSP(String userId,Model model) {
		//先查询数据库，获取用户的详细信息
		User user = userService.queryManagerById(userId);
		System.out.println(user);
		model.addAttribute("user",user);
		//使用model进行数据的绑定
		return "/sysadmin/user/jUserView";
	}
	
	//3.用户管理定位修改页面
	@RequestMapping("toUpdateJSP")
	public String toUpdateJSP(String userId,Model model) {
		
		//更新的信息是先查询数据库
		
		//3.1查询user对象的详细信息
		User user = userService.queryManagerById(userId);
		//3.2查询所有的部门信息作为上级部门
		List<Dept> depts = deptService.queryDepts();
		//3.3查询所有的用户名字作为上级领导
		List<User> superior = userService.queryUsers();
		
		//使用model对象封装上述三个步骤
		model.addAttribute("user",user);
		model.addAttribute("deptList",depts);
		model.addAttribute("userInfoList",superior);
		
		return "/sysadmin/user/jUserUpdate";
	}
	
	@RequestMapping("update")
	public String update(User user,Model model) {
		userService.updateUserById(user);
		model.addAttribute("user",user);
		//重定向到:List请求
		return "redirect:/sysadmin/user/list";
	}
	//4.角色的启用与停用
	//4.1停用
	@RequestMapping("stop")
	public String stop(@RequestParam(defaultValue="4" ,value="userId") String[] userId) {
		int state=0;
		userService.updateStateById(state, userId);
		
		return "redirect:/sysadmin/user/list";
	}
	@RequestMapping("start")
	public String start(@RequestParam(defaultValue="4" ,value="userId") String[] userId) {
		int state=1;
		userService.updateStateById(state, userId);
		
		return "redirect:/sysadmin/user/list";
	}
	//5.角色的删除
	@RequestMapping("delete")
	public String delete(@RequestParam(defaultValue="4", value="userId")String[] userId){
		userService.deleteUserById(userId);
		return "redirect:/sysadmin/user/list";
	}
	//6.1角色的新增界面
	@RequestMapping("toSaveJSP")
	public String toSaveJSP(Model model){
		//查询数据库获得部门信息和上级领导信息
		List<User> userInfoList = userService.queryUsers();
		
		List<Dept> deptList = deptService.queryDepts();
		model.addAttribute("deptList",deptList);
		model.addAttribute("userInfoList",userInfoList);
		return "/sysadmin/user/jUserSave";
	}
	/*//6.2用户新增的保存
	@RequestMapping("save")
	public String save(){
		return "redirect:/sysadmin/user/list";
	}*/
	//7.1用户管理 ：角色按钮
	//页面展示zTree树
	@RequestMapping("toRoleJSP")
	public String toRoleJSP(String userId,Model model) throws IOException {
		
		//1.先查询数据库,得到所有的role角色信息
		List<Role> roles = roleService.queryRoles();
		//1.1查询当前用户下的拥有的角色
		List<String> roleList = userService.queryRoleIdByUserId(userId);
		for (String roleId : roleList) {//循环已拥有角色
			for(Role role:roles){//循环所有角色
				if(roleId.equals(role.getRoleId())){
					//如果匹配成功，需要设置zTree树的check属性
					role.setChecked(true);
				}
			}
		}
		model.addAttribute("userId",userId);
		//2.把list集合转换为zTree树的json数组格式
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJson = objectMapper.writeValueAsString(roles);
		System.out.println("========"+zTreeJson);
		
		model.addAttribute("zTreeJson",zTreeJson);
		//3.使用model对象，封装json数组
		return "/sysadmin/user/jUserRole";
	}
	//8.用户管理的保存角色按钮'\
	@RequestMapping("saveUserRole")
	public String saveUserRole(String userId,String roleIds,Model model) {
		//1.判断用户的id是否为空
		
		if (userId == null || "".equals(userId)) {
			//不能进行数据的保存了
			model.addAttribute("msg","用户id不能为空，请勾选一个员工");
			return "forward:/sysadmin/user/toRoleJSP";
		}
		//2.调用service层的方法，插入数据
		//roleIds:是数组格式的字符串
		userService.saveUserRole(userId, roleIds.split(","));
		return "redirect:/sysadmin/user/list";
	}

}
