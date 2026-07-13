package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.entity.Booking;
import com.carmina.skin_profile_system.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository repo;
private final NotificationService notificationService;

public BookingService(
        BookingRepository repo,
        NotificationService notificationService
) {
    this.repo = repo;
    this.notificationService = notificationService;
}
    // ===============================
    // CREATE BOOKING
    // Prevent double bookings
    // ===============================
    public Booking create(Booking booking) {

        boolean bookingExists = repo.findAll().stream().anyMatch(b ->
                b.getDate().equals(booking.getDate())
                        && b.getTime().equals(booking.getTime())
                        && !"CANCELLED".equalsIgnoreCase(b.getStatus())
        );

        if (bookingExists) {
            throw new RuntimeException(
                    "This appointment time has already been booked."
            );
        }

       Booking savedBooking = repo.save(booking);

notificationService.create(
        "Booking",
        "New booking created for " + savedBooking.getClientName()
);

return savedBooking;
    }

    // ===============================
    // GET ALL BOOKINGS
    // ===============================
    public List<Booking> getAll() {
        return repo.findAll();
    }

    // ===============================
    // UPDATE BOOKING STATUS
    // ===============================
    public Booking updateStatus(Long id, String status) {

        Booking booking = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(status);

      Booking updatedBooking = repo.save(booking);

notificationService.create(
        "Booking",
        "Booking for " + updatedBooking.getClientName()
                + " has been " + status
);

return updatedBooking;
    }

    // ===============================
    // DELETE BOOKING
    // ===============================
    public void delete(Long id) {

        if (!repo.existsById(id)) {
            throw new RuntimeException("Booking not found");
        }
        Booking booking = repo.findById(id)
        .orElseThrow(() -> new RuntimeException("Booking not found"));

notificationService.create(
        "Booking",
        "Booking for " + booking.getClientName() + " was deleted"
);

repo.deleteById(id);

        repo.deleteById(id);
    }
}