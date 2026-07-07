package com.carmina.skin_profile_system.dto;

public class DashboardResponse {

    private long totalClients;
    private long totalTherapists;
    private long totalBookings;
    private long totalProducts;

    public DashboardResponse() {
    }

    public DashboardResponse(long totalClients,
                             long totalTherapists,
                             long totalBookings,
                             long totalProducts) {

        this.totalClients = totalClients;
        this.totalTherapists = totalTherapists;
        this.totalBookings = totalBookings;
        this.totalProducts = totalProducts;
    }

    public long getTotalClients() {
        return totalClients;
    }

    public void setTotalClients(long totalClients) {
        this.totalClients = totalClients;
    }

    public long getTotalTherapists() {
        return totalTherapists;
    }

    public void setTotalTherapists(long totalTherapists) {
        this.totalTherapists = totalTherapists;
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
}