package service;

import dao.roleMapper;
import pojo.role;

import java.util.List;

public class roleServiceImp implements roleService {
    private dao.roleMapper roleMapper;

    public void setRoleMapper(dao.roleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public List<role> getRoleList() {
        return roleMapper.getRoleList();
    }
}
