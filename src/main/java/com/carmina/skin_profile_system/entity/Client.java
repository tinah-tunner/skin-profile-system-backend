package com.carmina.skin_profile_system.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    private int age;

    private String phone;
    private String email;

    private LocalDate firstConsultationDate;

    private String skinType;

    @Column(length = 1000)
    private String allergies;

    @Column(length = 2000)
    private String medicalNotes;

    @Column(length = 5000)
private String beforeImage;

@Column(length = 5000)
private String afterImage;

    // Default Constructor
    public Client() {
    }

    // All Arguments Constructor
    public Client(Long id, String firstName, String lastName, int age,
                  String phone, String email,
                  LocalDate firstConsultationDate,
                  String skinType, String allergies,
                  String medicalNotes) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.firstConsultationDate = firstConsultationDate;
        this.skinType = skinType;
        this.allergies = allergies;
        this.medicalNotes = medicalNotes;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFirstConsultationDate() {
        return firstConsultationDate;
    }

    public void setFirstConsultationDate(LocalDate firstConsultationDate) {
        this.firstConsultationDate = firstConsultationDate;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedicalNotes() {
        return medicalNotes;
    }

    public void setMedicalNotes(String medicalNotes) {
        this.medicalNotes = medicalNotes;
    }
}