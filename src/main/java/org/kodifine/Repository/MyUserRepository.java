package org.kodifine.Repository;

import java.util.Optional;

import org.kodifine.Entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
	Optional<MyUser> findByUsername(String username);
}
