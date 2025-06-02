package com.rollerspeed.rollerspeed.Repository;

import com.rollerspeed.rollerspeed.Models.user;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;


@Repository
public interface userRepository extends JpaRepository<user, Long> {
    


}
