package com.gyc.wenjuan.admin.service;

import java.util.List;

import com.gyc.wenjuan.admin.model.SysMenu;
import com.gyc.wenjuan.admin.model.SysRole;
import com.gyc.wenjuan.admin.model.SysRoleMenu;
import com.gyc.wenjuan.core.service.CurdService;

/**
 * 角色管理
 * @author gyc
 * 
 */
public interface SysRoleService extends CurdService<SysRole> {

	/**
	 * 查询全部
	 * @return
	 */
	List<SysRole> findAll();

	/**
	 * 查询角色菜单集合
	 * @return
	 */
	List<SysMenu> findRoleMenus(Long roleId);

	/**
	 * 保存角色菜单
	 * @param records
	 * @return
	 */
	int saveRoleMenus(List<SysRoleMenu> records);

	/**
	 * 根据名称查询
	 * @param name
	 * @return
	 */
	List<SysRole> findByName(String name);

}
