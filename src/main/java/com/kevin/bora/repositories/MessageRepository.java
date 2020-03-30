package com.kevin.bora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.bora.domain.chat.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{
}
