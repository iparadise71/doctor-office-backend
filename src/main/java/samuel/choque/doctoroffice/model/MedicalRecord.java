package samuel.choque.doctoroffice.model;

import java.util.Date;
import java.util.List;

public class MedicalRecord extends MedicalRecordKey {
    private String description;

    private Date date;

    private String prescriptionDrug;

    private Doctor doctor;
    private Patient patient;
    private List<Prescription> prescriptionList;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPrescriptionDrug() {
        return prescriptionDrug;
    }

    public void setPrescriptionDrug(String prescriptionDrug) {
        this.prescriptionDrug = prescriptionDrug == null ? null : prescriptionDrug.trim();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }
}