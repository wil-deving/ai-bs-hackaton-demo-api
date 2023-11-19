package com.aibisaseg.aidemo.repository;

import com.aibisaseg.aidemo.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
