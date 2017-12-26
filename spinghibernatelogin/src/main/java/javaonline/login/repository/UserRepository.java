package javaonline.login.repository;

import javaonline.login.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByEmail(String email);
    
    User findByMobile(String mobile);
    
    User findByEmailOrMobile(String email, String mobile);
    
    @Query("select p from User p where p.email = :email and p.mobile = :mobile")
    User findByEmailAndMobile(@Param("email") String email,
                                 @Param("mobile") String mobile);
   
}
