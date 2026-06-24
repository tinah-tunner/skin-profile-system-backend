package com.carmina.skin_profile_system.booking.dto;

import java.time.LocalDateTime;

public class BookingDto {

    private Long id;
    private Long clientId;
    private Long therapistId;
    private LocalDateTime appointmentTime;
    private String status; // PENDING, CONFIRMED, CANCELLED

    public BookingDto() {}

    public BookingDto(Long id, Long clientId, Long therapistId,
                      LocalDateTime appointmentTime, String status) {
        this.id = id;
        this.clientId = clientId;
        this.therapistId = therapistId;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public Long getTherapistId() { return therapistId; }
    public void setTherapistId(Long therapistId) { this.therapistId = therapistId; }

    public LocalDateTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalDateTime appointmentTime) { this.appointmentTime = appointmentTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}