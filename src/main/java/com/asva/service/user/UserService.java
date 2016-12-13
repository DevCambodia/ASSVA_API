package com.asva.service.user;

import java.util.ArrayList;

import com.asva.form.UserForm;
import com.asva.form.UserForm.LoginForm;
import com.asva.model.user.Role;
import com.asva.model.user.User;
import com.asva.util.filter.UserFilter;
import com.asva.util.paging.Paging;
/**
 * @version 1.0
 * @author Rath Phearun
 * Created Date: 14/07/2016
 * Email: rathphearun123@gmail.com
 * 
 * */
public interface UserService {
	
	/***
	 * Get all users with filtering and pagination.
	 * Return ArrayList of users
	 * 
	 * @param filter
	 * @param paging
	 * @return
	 */
	public ArrayList<User> findAll(UserFilter filter, Paging paging);
	
	
	/***
	 * Get all users with no filtering
	 * Return ArrayList of users object
	 * 
	 * @return
	 */
	public ArrayList<User> findAll();
	

	/***
	 * Get only one user filtering by user id
	 * Return user object
	 * 
	 * @param id
	 * @return
	 */
	public User findOne(int id);
	
	
	
	/***
	 * Remove user by user id
	 * Return boolean value. if true->success, else failed
	 * 
	 * @param id
	 * @return
	 */
	public boolean remove(int id);
	

	/***
	 * Save user
	 * Return boolean value. if true->success, else failed
	 * 
	 * @param user
	 * @return
	 */
	public boolean save(User user);
	

	/***
	 * Update user
	 * Return boolean value. if true->success, else failed
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(User user);
	
	
	/***
	 * Get user filtering by user's email
	 * Return user object
	 * 
	 * @param email
	 * @return
	 */
	public User findByEmail(String email);
	
	/***
	 * 
	 * @return
	 */
	public ArrayList<Role> findAllRoles();
	
	/***
	 * 
	 * @param userId
	 * @return
	 */
	public boolean toggleStatus(int userId);
	
	/***
	 * 
	 * @param roleId
	 * @param userId
	 * @return
	 */
	public boolean updateRole(int roleId, int userId);
	
	/***
	 * 
	 * @param userId
	 * @param newPassword
	 * @return
	 */
	public boolean resetPassword(UserForm.ResetPasswordForm resetForm);
	
	/***
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public User findUserByEmail(UserForm.LoginForm loginForm);
}
