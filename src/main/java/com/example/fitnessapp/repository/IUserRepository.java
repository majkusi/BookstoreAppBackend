package com.example.fitnessapp.repository;

import com.example.fitnessapp.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends CrudRepository<UserModel, Long> {

    public UserModel findUserByUserName(String userName);

    public boolean existsUserModelByUserName(String userName);

    public boolean existsUserModelByEmail(String email);

}
