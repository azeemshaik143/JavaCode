package com.aja.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Integer> {

}
