package com.rollerspeed.rollerspeed.Repository;

import com.rollerspeed.rollerspeed.Models.user;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<user, Long> {
    


}
