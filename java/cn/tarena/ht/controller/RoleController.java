package cn.tarena.ht.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.ModuleService;
import cn.tarena.ht.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private ModuleService moduleService;
	@RequestMapping("sysadmin/role/list")
	public String toRole(Model model) {
		
		List<Role> list = roleService.queryRoles();
		model.addAttribute("roleList",list);
		return "sysadmin/role/jRoleList";
	}
	//2.模块按钮
	@RequestMapping("sysadmin/role/toModuleJSP")
	public String toModuleJSP(String roleId,Model model) throws IOException {
		model.addAttribute("roleId",roleId);
		
		//2.1查询数据库获得所有的module信息
		List<Module> modules = moduleService.queryModules();
		//2.2使用ObjectMapper转换规则,把list转换为json数组格式的字段
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJson = objectMapper.writeValueAsString(modules);
		//2.3使用model对象封装数据到zTree树
		model.addAttribute("zTreeJson",zTreeJson);
		return "/sysadmin/role/jRoleModule";		
	}
	
	//3.角色管理的模块保存按钮
	@RequestMapping("sysadmin/role/saveRoleModule")
	public String saveRoleModule(String roleId,String moduleIds,Model model) {
		//3.1判断roleId是否为空
		if (roleId == null||"".equals(roleId)) {
			//封装错误提示信息
			model.addAttribute("msg","角色的id编号不能为空");
			//转发错误信息到:toModuleJSP页面上请求上
			return "forword:/sysadmin/role/toModuleJSP";
		}
		roleService.saveRoleModule(roleId, moduleIds.split(","));
		return "redirect:/sysadmin/role/list";
		
	}
}
