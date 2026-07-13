package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.dto.DashboardResponse;
import com.carmina.skin_profile_system.entity.Role;
import com.carmina.skin_profile_system.repository.BookingRepository;
import com.carmina.skin_profile_system.repository.ProductRepository;
import com.carmina.skin_profile_system.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final ProductRepository productRepository;

    public DashboardService(
            UserRepository userRepository,
            BookingRepository bookingRepository,
            ProductRepository productRepository
    ) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.productRepository = productRepository;
    }

    public DashboardResponse getDashboardStats() {

        long clients = userRepository.countByRole(Role.CLIENT);
        long bookings = bookingRepository.count();
        long products = productRepository.count();

        // Therapist count removed
        return new DashboardResponse(
                clients,
                bookings,
                products
        );
    }
}