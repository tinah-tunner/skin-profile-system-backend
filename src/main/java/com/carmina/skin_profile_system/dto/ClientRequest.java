package com.carmina.skin_profile_system.dto;

import com.carmina.skin_profile_system.entity.Gender;
import com.carmina.skin_profile_system.entity.SkinConcern;
import com.carmina.skin_profile_system.entity.SkinType;

import java.time.LocalDate;
import java.util.Set;

public class ClientRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    private Gender gender;

    private String address;
    private String emergencyContact;

    private SkinType skinType;

    private Set<SkinConcern> skinConcerns;

    private String allergies;
    private String currentMedication;
    private String medicalConditions;
    private String beforeImage;
private String afterImage;
    private String therapistNotes;

    public ClientRequest() {}

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

    public SkinType getSkinType() { return skinType; }
    public void setSkinType(SkinType skinType) { this.skinType = skinType; }

    public Set<SkinConcern> getSkinConcerns() { return skinConcerns; }
    public void setSkinConcerns(Set<SkinConcern> skinConcerns) { this.skinConcerns = skinConcerns; }

    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }

    public String getCurrentMedication() { return currentMedication; }
    public void setCurrentMedication(String currentMedication) { this.currentMedication = currentMedication; }

    public String getMedicalConditions() { return medicalConditions; }
    public void setMedicalConditions(String medicalConditions) { this.medicalConditions = medicalConditions; }

    public String getBeforeImage() {
    return beforeImage;
}

public void setBeforeImage(String beforeImage) {
    this.beforeImage = beforeImage;
}

public String getAfterImage() {
    return afterImage;
}

public void setAfterImage(String afterImage) {
    this.afterImage = afterImage;
}

    public String getTherapistNotes() { return therapistNotes; }
    public void setTherapistNotes(String therapistNotes) { this.therapistNotes = therapistNotes; }
}