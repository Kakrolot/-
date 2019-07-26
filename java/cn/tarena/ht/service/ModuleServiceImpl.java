package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;
@Service
public class ModuleServiceImpl implements ModuleService{
	@Autowired
	private ModuleMapper moduleMapper;
	
	@Override
	public List<Module> queryModules() {
		// TODO Auto-generated method stub
		return moduleMapper.queryModules();
	}

}
