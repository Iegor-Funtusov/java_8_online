package ua.com.alevel.persistence.repositoty.user;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.user.Admin;

@Repository
public interface AdminRepository extends UserRepository<Admin> { }
