package aesys.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aesys.entity.DemoUser;

@Repository
public interface DemoUserRepository extends JpaRepository<DemoUser, Long> {
    
}
