package com.example.demo.domain.application.repository;

import com.example.demo.domain.application.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
