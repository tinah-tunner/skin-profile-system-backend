package com.carmina.skin_profile_system.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String clientNumber;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;

    private String emergencyContact;

    @Enumerated(EnumType.STRING)
    private SkinType skinType;

    @ElementCollection(targetClass = SkinConcern.class)
    @CollectionTable(
            name = "client_skin_concerns",
            joinColumns = @JoinColumn(name = "client_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "skin_concern")
    private Set<SkinConcern> skinConcerns = new HashSet<>();

    private String allergies;

    private String currentMedication;

    private String medicalConditions;

    @Column(length = 3000)
    private String therapistNotes;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public SkinType getSkinType() {
        return skinType;
    }

    public void setSkinType(SkinType skinType) {
        this.skinType = skinType;
    }

    public Set<SkinConcern> getSkinConcerns() {
        return skinConcerns;
    }

    public void setSkinConcerns(Set<SkinConcern> skinConcerns) {
        this.skinConcerns = skinConcerns;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getCurrentMedication() {
        return currentMedication;
    }

    public void setCurrentMedication(String currentMedication) {
        this.currentMedication = currentMedication;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getTherapistNotes() {
        return therapistNotes;
    }

    public void setTherapistNotes(String therapistNotes) {
        this.therapistNotes = therapistNotes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}