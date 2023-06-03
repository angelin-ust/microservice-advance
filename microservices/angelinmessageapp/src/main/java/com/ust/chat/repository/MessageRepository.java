package com.ust.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.chat.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
