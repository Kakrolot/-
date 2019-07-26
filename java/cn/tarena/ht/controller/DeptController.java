package cn.tarena.ht.controller;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;
import net.sf.json.JSONObject;

@Controller
public class DeptController {
	//需要依赖注入service
	@Autowired
	private DeptService deptService;
	//1.部门管理--->列表展示
	@RequestMapping("/sysadmin/dept/list")
	public String toListJSP(Model model) {
		//先查询数据库，得到结果集
		List<Dept> list = deptService.queryDepts();
		//进行数据封装和绑定	
		model.addAttribute("deptList",list);
		//页面跳转
		return "/sysadmin/dept/jDeptList";
	}
	
	//2.部门管理-启动停用
	@RequestMapping("/sysadmin/dept/stop")
	//参数为:复选框类型的数组,可以批量停用
	public String stop(
			@RequestParam(defaultValue="4", value="deptId" ) 
			String[] deptId) {
		//stop方法就是停止状态
		int state = 0;
		//调用service的方法
		deptService.updateStateById(state, deptId);
		//请求的重定向
		return "redirect:/sysadmin/dept/list";
		
	}
	
	@RequestMapping("/sysadmin/dept/start")
	public String start(
			@RequestParam(defaultValue="4" ,value="deptId") 
			String[] deptId) {
		//stop方法就是停止状态
		int state = 1;
		//调用service的方法
		deptService.updateStateById(state, deptId);
		//请求的重定向
		return "redirect:/sysadmin/dept/list";
		
	}
	@RequestMapping("/sysadmin/dept/delete")
	public String delete(@RequestParam(defaultValue="4" ,value="deptId") String[] deptId) {
		deptService.deleteBydeptId(deptId);
		return "redirect:/sysadmin/dept/list";
	}
	
	//4.部门管理:新增按钮--定位页面
	@RequestMapping("/sysadmin/dept/toSaveJSP")
	public String toSaveJSP(Model model) {
		//先查询数据库，获取部门信息
		List<Dept> list = deptService.queryDepts();
		//把上级部门的数据封装到model中
		//key来自于页面中的name
		model.addAttribute("parentDeptList",list);
		//页面跳转
		return "/sysadmin/dept/jDeptSave";
		
	}
	
	//5.部门管理 保存按钮
	@RequestMapping("/sysadmin/dept/save")
	public String save(Dept dept,Model model) {
		//获取deptId
		String deptId = dept.getDeptId();
		//非空校验
		if(deptId ==null||"".equals(deptId)){
			//使用model封装一个错误信息提示
			model.addAttribute("errorInfo","部门编号不能为空");
			//如果没有id信息，那么返回当前页面
			//情形1:return "/sysadmin/dept/jDeptSave";
			//情形2:重定向到toSaveJSP页面
			//      但是重定向不能够携带数据
			//return "redirect:/sysadmin/dept/toSaveJSP";
			//情形3:使用转发到toSaveJSP请求！！
			return "forward:/sysadmin/dept/toSaveJSP";
			
	
		}
		//主键冲突的校验
		Dept check = deptService.queryById(deptId);
		if(check != null){
			
			return "forward:/sysadmin/dept/toSaveJSP";
		}
		deptService.save(dept);
		//最终重定向到:list请求，刷新列表
		return "redirect:/sysadmin/dept/list";
	}
	
	//6.部门管理:新增--ajax校验
	@RequestMapping("/sysadmin/dept/checkDeptId")
	@ResponseBody//该注解专门用于返回ajax的结果
	public JSONObject checkDeptId(String deptId) {
		JSONObject json = new JSONObject();
		//查询数据库,根据deptId获取部门
		Dept dept = deptService.queryById(deptId);
		//判断dept部门是否为空
		if (dept==null) {//表示部门编号可以使用
			json.put("result", "false");
			
		}else {
			//表示部门编号已存在
			json.put("result", "true");
		}
		
		//ajax异步，返回结果不是一个界面
		//而是一个 json对象
		//存放了数据{result:true}/{result:false}
		return json;
	}
	
	//7.部门查看功能
	@RequestMapping("/sysadmin/dept/toViewJSP")
	public String tojDeptView(String deptId,Model model) {
		Dept dept = deptService.queryDepartmentById(deptId);
		model.addAttribute("dept",dept);
		return "/sysadmin/dept/jDeptView";
	}
	
	//8.部门的修改界面
	@RequestMapping("/sysadmin/dept/toUpdateJSP")
	public String toUpdateJSP(String deptId,Model model) {
		//8.1查询部门信息
		Dept dept = deptService.queryDepartmentById(deptId);
		//8.2封装部门信息
		model.addAttribute("dept",dept);
		//8.3查询并封装上级部门信息
		List<Dept> parentList = deptService.queryDepts();
		model.addAttribute("parentDeptList",parentList);
		return "sysadmin/dept/jDeptUpdate";
	}
	//9.修改的保存按钮
	@RequestMapping("/sysadmin/dept/update")
	public String update(Dept dept,Model model) {
		deptService.updateDepartmentById(dept);
		model.addAttribute("dept",dept);
		return "redirect:/sysadmin/dept/list";
	}
}
