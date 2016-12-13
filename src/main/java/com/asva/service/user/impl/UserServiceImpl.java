package com.asva.service.user.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asva.form.UserForm;
import com.asva.model.user.Role;
import com.asva.model.user.User;
import com.asva.repository.UserRepository;
import com.asva.service.user.UserService;
import com.asva.util.filter.UserFilter;
import com.asva.util.paging.Paging;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ArrayList<User> findAll(UserFilter filter, Paging paging) {
		try{
			paging.setTotalCount(userRepository.count(filter));
			return userRepository.findAll(filter, paging);
			
		}catch(Exception e){	
			e.printStackTrace();
		}
		return null;
	}

	@Override	
	public ArrayList<User> findAll() {
		try{
			return userRepository.findAllNoFilter();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findOne(int id) {
		try{
			return userRepository.findOne(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean remove(int id) {
		try{
			return userRepository.remove(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean save(User user) {
		try{
			return userRepository.save(user);			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User findByEmail(String email) {
		try{
			return userRepository.findByEmail(email);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(User user) {
		try{
			return userRepository.update(user);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Role> findAllRoles() {
		try{
			return userRepository.findAllRole();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean toggleStatus(int userId) {
		try{
			return userRepository.toggleStatus(userId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateRole(int roleId, int userId) {
		try{
			System.out.println(roleId+","  +userId);
			return userRepository.updateRole(userId, roleId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean resetPassword(UserForm.ResetPasswordForm resetForm) {
		try{
			return userRepository.resetPassword(resetForm);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User findUserByEmail(UserForm.LoginForm loginForm) {
		try{
			return userRepository.findUserByEmail(loginForm);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
