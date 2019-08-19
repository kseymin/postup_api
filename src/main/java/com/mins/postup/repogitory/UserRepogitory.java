package com.mins.postup.repogitory;

import com.mins.postup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepogitory extends JpaRepository<User,Long> {
    List<User> findAll();
    Optional<User> findById(long id);
    Optional<User> findByUserid(String user_id);
    //User deleteById(long id);
    User deleteAllByIdIn(Long id);


//    @Query(value = "SELECT  FROM User")
//    public List<Map<String, Object>> findCount();
}
