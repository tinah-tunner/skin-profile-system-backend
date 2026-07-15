package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.dto.DashboardResponse;
import com.carmina.skin_profile_system.repository.BookingRepository;
import com.carmina.skin_profile_system.repository.ClientRepository;
import com.carmina.skin_profile_system.repository.ConsultationRepository;
import com.carmina.skin_profile_system.repository.NotificationRepository;
import com.carmina.skin_profile_system.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final ClientRepository clientRepository;
    private final BookingRepository bookingRepository;
    private final ProductRepository productRepository;
    private final NotificationRepository notificationRepository;
    private final ConsultationRepository consultationRepository;

    public DashboardService(
            ClientRepository clientRepository,
            BookingRepository bookingRepository,
            ProductRepository productRepository,
            NotificationRepository notificationRepository,
            ConsultationRepository consultationRepository
    ) {
        this.clientRepository = clientRepository;
        this.bookingRepository = bookingRepository;
        this.productRepository = productRepository;
        this.notificationRepository = notificationRepository;
        this.consultationRepository = consultationRepository;
    }

    public DashboardResponse getDashboardStats() {

        DashboardResponse response = new DashboardResponse();

        // Totals
        response.setTotalClients(clientRepository.count());
        response.setTotalBookings(bookingRepository.count());
        response.setTotalProducts(productRepository.count());
        response.setTotalNotifications(notificationRepository.count());
        response.setTotalConsultations(consultationRepository.count());

        // Recent Records
          response.setRecentClients(null);
        response.setRecentBookings(null);
        response.setRecentNotifications(null);  

        return response;
    }
}