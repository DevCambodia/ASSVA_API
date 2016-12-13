package com.asva.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.asva.form.UserForm;
import com.asva.model.user.Role;
import com.asva.model.user.User;
import com.asva.util.filter.UserFilter;
import com.asva.util.paging.Paging;

@Repository
public interface UserRepository {
	
	/***
	 * Insert User
	 * @param user
	 * @return
	 */
	@Insert(SQL.INSERT)
	public boolean save(User user);

	/***
	 * Delete User
	 * @param id
	 * @return
	 */
	@Delete(SQL.DELETE)
	public boolean remove(int id);

	/***
	 * Update User
	 * @param user
	 * @return
	 */
	@Update(SQL.UPDATE)
	public boolean update(User user);
	
	
	/***
	 * Get All User with filter
	 * @return
	 */
	@Select(SQL.SELECT_ALL)
	@Results({
		@Result(property="id", column="user_id"),
		@Result(property="firstName", column="user_first_name"),
		@Result(property="lastName", column="user_last_name"),
		@Result(property="gender", column="user_gender"),
		@Result(property="email", column="user_email"),
		@Result(property="password", column="user_password"),
		@Result(property="photo", column="user_photo"),
		@Result(property="telephone", column="user_telephone"),
		@Result(property="status", column="user_status_1"),
		@Result(property="role.id", column="role_id"),
		@Result(property="role.name", column="role_name"),
	})
	public ArrayList<User> findAllNoFilter();

	
	/***
	 * Get All User with filter pagination
	 * @param filter
	 * @param paging
	 * @return
	 */
	@Select(SQL.SELECT_PAGING)
	@Results({
		@Result(property="id", column="user_id"),
		@Result(property="firstName", column="user_first_name"),
		@Result(property="lastName", column="user_last_name"),
		@Result(property="gender", column="user_gender"),
		@Result(property="email", column="user_email"),
		@Result(property="password", column="user_password"),
		@Result(property="photo", column="user_photo"),
		@Result(property="telephone", column="user_telephone"),
		@Result(property="status", column="user_status_1"),
		@Result(property="role.id", column="role_id"),
		@Result(property="role.name", column="role_name"),
	})
	public ArrayList<User> findAll(@Param("filter") UserFilter filter, @Param("paging") Paging paging);
	
	
	/***
	 * Find user by email
	 * 
	 * @param email
	 * @return User Object
	 */
	@Select(SQL.SELECT_BY_EMAIL)
	@Results({
		@Result(property="id", column="user_id"),
		@Result(property="firstName", column="user_first_name"),
		@Result(property="lastName", column="user_last_name"),
		@Result(property="gender", column="user_gender"),
		@Result(property="email", column="user_email"),
		@Result(property="photo", column="user_photo"),
		@Result(property="telephone", column="user_telephone"),
		@Result(property="status", column="user_status_1"),
		@Result(property="role.id", column="role_id"),
		@Result(property="role.name", column="role_name"),
	})
	public User findByEmail(String email);
	
	
	/***
	 * Count user with filter
	 * @param filter
	 * @return
	 */
	@Select(SQL.COUNT)
	public Long count(UserFilter filter);
	
	/***
	 * Select single user
	 * @param id
	 * @return
	 */
	@Select(SQL.SELECT_ONE)
	@Results({
		@Result(property="id", column="user_id"),
		@Result(property="firstName", column="user_first_name"),
		@Result(property="lastName", column="user_last_name"),
		@Result(property="gender", column="user_gender"),
		@Result(property="email", column="user_email"),
		@Result(property="photo", column="user_photo"),
		@Result(property="telephone", column="user_telephone"),
		@Result(property="status", column="user_status_1"),
		@Result(property="role.id", column="role_id"),
		@Result(property="role.name", column="role_name"),
	})
	public User findOne(int id);
	
	@Select("SELECT role_id, role_name FROM tb_user_role ORDER BY role_id DESC")
	@Results({
		@Result(property="id", column="role_id"),
		@Result(property="name", column="role_name")
	})
	public ArrayList<Role> findAllRole();
	
	/***
	 * Toggle Status of user
	 * @param id
	 * @return
	 */
	@Update(SQL.TOGGLE_STATUS)
	public boolean toggleStatus(int id);
	
	/***
	 * Reset Password
	 * @param userId
	 * @param newPassword
	 * @return
	 */
	@Update(SQL.RESET_PASSWORD)
	public boolean resetPassword(UserForm.ResetPasswordForm restForm);
	
	/***
	 * Update user's role
	 * @param userId
	 * @param roleId
	 * @return
	 */
	@Update(SQL.UPDATE_ROLE)
	public boolean updateRole(@Param("userId") int userId, @Param("roleId") int roleId);
	
	/***
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@Select(SQL.LOGIN)
	@Results({
		@Result(property="id", column="user_id"),
		@Result(property="firstName", column="user_first_name"),
		@Result(property="lastName", column="user_last_name"),
		@Result(property="gender", column="user_gender"),
		@Result(property="email", column="user_email"),
		@Result(property="photo", column="user_photo"),
		@Result(property="telephone", column="user_telephone"),
		@Result(property="status", column="user_status_1"),
		@Result(property="role.id", column="role_id"),
		@Result(property="role.name", column="role_name"),
	})
	public User findUserByEmail(UserForm.LoginForm loginFrom);
	
	
	/***
	 * SQL Factory!!!
	 * @author Rath Phearun
	 *
	 */
	interface SQL {
		
		/***
		 * 
		 */
		String COUNT = ""
				+ "	SELECT "
				+ " 	COUNT (*)"
				+ "	FROM"
				+ "		tb_user U"
				+ "	LEFT JOIN tb_user_role UR ON U.user_role = UR.role_id"
				
				+ "	WHERE"
				+ "		LOWER(ur.role_name) LIKE '%' || LOWER(#{roleName}) || '%'"
				+ "	AND u.user_status_1 LIKE '%' || #{status} || '%'"
				+ "	AND ("
				+ "		u.user_last_name LIKE '%'|| #{lastName} || '%' "
				+ "		AND u.user_first_name LIKE '%' || #{firstName} || '%' "
				+ "	)";
		
		/***
		 * 
		 */
		String INSERT = ""
				+ "	INSERT INTO tb_user ("
				+ "		user_first_name,	"
				+ "		user_last_name,		"
				+ "		user_gender,		"
				+ "		user_email,			"
				+ "		user_password,		"
				+ "		user_photo,			"
				+ "		user_telephone, 	"
				+ "		user_status_1,		"
				+ "		user_role			"
				+ "	)"
				+ "	VALUES"
				+ "	("
				+ "		#{ firstName }, 	"
				+ "		#{ lastName }, 		"
				+ "		#{ gender },		"
				+ "		#{ email }, 		"
				+ "		#{ password },		"
				+ "		#{ photo },			"
				+ "		#{ telephone },		"
				+ "		#{ status},			"
				+ "		#{ role.id }		"
				+ "	)";
		
		
		/***
		 * 
		 */
		String UPDATE = ""
				+ "	UPDATE tb_user"
				+ "	SET "
				+ "		user_first_name = #{firstName},"
				+ "		user_last_name = #{lastName},"
				+ "		user_gender = #{gender},"
				+ "		user_email = #{email},"
				+ "		user_telephone = #{telephone},"
				+ "		user_role = #{role.id},"
				+ "		user_status_1 = #{status}"
				+ "	WHERE"
				+ "		user_id = #{id}";
		
		/***
		 * 
		 */
		String DELETE = ""
				+ "	DELETE"
				+ "	FROM"
				+ "		tb_user"
				+ "	WHERE"
				+ "		user_id = #{id}";
		
		/***
		 * 
		 */
		String SELECT_ALL = ""
				+ "	SELECT "
				+ "		u.user_id,				"
				+ "		u.user_first_name,		"
				+ "		u.user_last_name,		"
				+ "		u.user_gender,			"
				+ "		u.user_email,			"
				+ "		u.user_password,		"
				+ "		u.user_photo,			"
				+ "		u.user_telephone, 		"
				+ "		u.user_status_1,			"
				+ "		ur.role_id,				"
				+ "		ur.role_name			"
				+ "	FROM					"
				+ "		tb_user u			"
				
				+ "	LEFT JOIN tb_user_role ur ON u.user_role = ur.role_id"
				
				+ "	ORDER BY				"
				+ "		u.user_id DESC		";
		
		/***
		 * 
		 * 
		 * 
		 */
		String SELECT_PAGING = ""
				+ "	SELECT "
				+ "		u.user_id,				"
				+ "		u.user_first_name,		"
				+ "		u.user_last_name,		"
				+ "		u.user_gender,			"
				+ "		u.user_email,			"
				+ "		u.user_password,		"
				+ "		u.user_photo,			"
				+ "		u.user_telephone, 		"
				+ "		u.user_status_1,		"
				+ "		ur.role_id,				"
				+ "		ur.role_name			"
				
				+ "	FROM					"
				+ "		tb_user u			"
				
				+ "	LEFT JOIN tb_user_role ur ON u.user_role = ur.role_id"
				+ "	WHERE"
				+ "	LOWER(ur.role_name) LIKE '%' || LOWER(#{filter.roleName }) || '%' "
				+ "	AND u.user_status_1 LIKE '%' || #{filter.status} || '%' "
				
				+ "	AND "
				+ "	("
				+ "		LOWER(u.user_last_name) LIKE '%' || LOWER(#{filter.lastName}) || '%'"
				+ "		AND "
				+ "		LOWER(u.user_first_name) LIKE '%' || LOWER(#{filter.firstName}) || '%'"
				+ "	)"
				
				+ "	ORDER BY				"
				+ "		u.user_id DESC	"
				
				+ "	LIMIT #{paging.limit} "
				+ "	OFFSET #{paging.offset}";
		
		String SELECT_ONE = ""
				+ "	SELECT"
				+ "		u.user_id,"
				+ "		u.user_first_name,"
				+ "		u.user_last_name,"
				+ "		u.user_gender,"
				+ "		u.user_email,"
				+ "		u.user_photo,"
				+ "		u.user_telephone,"
				+ "		u.user_status_1,"
				+ "		ur.role_id,"
				+ "		ur.role_name	"
				+ "	FROM"
				+ "		tb_user U"
				+ "	LEFT JOIN tb_user_role UR ON U.user_role = UR.role_id"
				+ "	WHERE"
				+ "		U.user_id = #{id}";
		
		String SELECT_BY_EMAIL = ""
				+ "	SELECT"
				+ "		u.user_id,"
				+ "		u.user_first_name,"
				+ "		u.user_last_name,"
				+ "		u.user_gender,"
				+ "		u.user_email,"
				+ "		u.user_photo,"
				+ "		u.user_telephone,"
				+ "		u.user_status_1,"
				+ "		ur.role_id,"
				+ "		ur.role_name"
				+ "	FROM"
				+ "		tb_user U"
				+ "	LEFT JOIN "
				+ "		tb_user_role UR ON U.user_role = UR.role_id"
				+ " WHERE "
				+ "		LOWER( U.user_email ) = LOWER( #{email} )";
		
		String TOGGLE_STATUS = ""
				+ "	UPDATE "
				+ "		tb_user "
				+ "	SET "
				+ "		user_status_1 = "
				+ "		("
				+ "			CASE user_status_1 "
				+ "				WHEN '1' "
				+ "					THEN '0' "
				+ "					ELSE '1' "
				+ "			END"
				+ "		) "
				+ "	WHERE "
				+ "		user_id = #{id}";
		
		/***
		 * 
		 */
		String RESET_PASSWORD = ""
				+ " UPDATE "
				+ "		tb_user "
				+ "	SET "
				+ "		user_password = #{password}"
				+ "	WHERE "
				+ "		user_id = #{userId}";
		/***
		 * 
		 */
		String UPDATE_ROLE = ""
				+ "	UPDATE "
				+ "		tb_user "
				+ "	SET "
				+ "		user_role = #{roleId} "
				+ "	WHERE "
				+ "		user_id = #{userId}";
		
		String LOGIN = ""
				+ "	SELECT"
				+ "		u.user_id,"
				+ "		u.user_first_name,"
				+ "		u.user_last_name,"
				+ "		u.user_gender,"
				+ "		u.user_email,"
				+ "		u.user_photo,"
				+ "		u.user_telephone,"
				+ "		u.user_status_1,"
				+ "		ur.role_id,"
				+ "		ur.role_name	"
				+ "	FROM"
				+ "		tb_user U"
				+ "	LEFT JOIN tb_user_role UR ON U.user_role = UR.role_id"
				+ " WHERE "
				+ "			user_status_1='1'"
				+ "		AND"
				+ "			user_email = #{email}"
				+ "		AND "
				+ "			user_password = #{password}";
		
	}
}
