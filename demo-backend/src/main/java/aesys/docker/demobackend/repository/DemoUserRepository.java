package aesys.docker.demobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aesys.docker.demobackend.entity.DemoUser;



@Repository 
public interface DemoUserRepository extends JpaRepository<DemoUser, Long> {
    
}
