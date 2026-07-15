package com.carmina.skin_profile_system.dto;

import java.util.List;

public class DashboardResponse {

    private long totalClients;
    private long totalBookings;
    private long totalProducts;
    private long totalNotifications;
    private long totalConsultations;

    private List<?> recentClients;
    private List<?> recentBookings;
    private List<?> recentNotifications;

    public DashboardResponse() {
    }

    public long getTotalClients() {
        return totalClients;
    }

    public void setTotalClients(long totalClients) {
        this.totalClients = totalClients;
    }

    public long getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(long totalBookings) {
        this.totalBookings = totalBookings;
    }

    public long getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(long totalProducts) {
        this.totalProducts = totalProducts;
    }

    public long getTotalNotifications() {
        return totalNotifications;
    }

    public void setTotalNotifications(long totalNotifications) {
        this.totalNotifications = totalNotifications;
    }

    public long getTotalConsultations() {
        return totalConsultations;
    }

    public void setTotalConsultations(long totalConsultations) {
        this.totalConsultations = totalConsultations;
    }

    public List<?> getRecentClients() {
        return recentClients;
    }

    public void setRecentClients(List<?> recentClients) {
        this.recentClients = recentClients;
    }

    public List<?> getRecentBookings() {
        return recentBookings;
    }

    public void setRecentBookings(List<?> recentBookings) {
        this.recentBookings = recentBookings;
    }

    public List<?> getRecentNotifications() {
        return recentNotifications;
    }

    public void setRecentNotifications(List<?> recentNotifications) {
        this.recentNotifications = recentNotifications;
    }
}