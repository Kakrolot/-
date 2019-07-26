package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;

@Controller
public class ModuleController {
	@Autowired
	private ModuleService moduleService;
	//1.模块管理：列表展示
	@RequestMapping("/sysadmin/module/list")
	public String toModuleJSP(Model model) {
		List<Module> modules =  moduleService.queryModules();
		model.addAttribute("moduleList",modules);
		
		return "/sysadmin/module/jModuleList";
	}
	//2.
}
