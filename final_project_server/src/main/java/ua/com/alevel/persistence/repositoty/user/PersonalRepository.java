package ua.com.alevel.persistence.repositoty.user;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.user.Personal;

@Repository
public interface PersonalRepository extends UserRepository<Personal> { }
