package com.carmina.skin_profile_system.repository;

import com.carmina.skin_profile_system.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}