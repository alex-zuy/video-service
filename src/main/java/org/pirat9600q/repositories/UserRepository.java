package org.pirat9600q.repositories;

import org.pirat9600q.entities.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {

    User findByUsername(String username);

}
