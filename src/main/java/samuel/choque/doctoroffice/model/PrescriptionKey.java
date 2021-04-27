package samuel.choque.doctoroffice.model;

public class PrescriptionKey {
    private Integer idPrescription;

    private Integer idMedicalRecordIdPrescription;

    public Integer getIdPrescription() {
        return idPrescription;
    }

    public void setIdPrescription(Integer idPrescription) {
        this.idPrescription = idPrescription;
    }

    public Integer getIdMedicalRecordIdPrescription() {
        return idMedicalRecordIdPrescription;
    }

    public void setIdMedicalRecordIdPrescription(Integer idMedicalRecordIdPrescription) {
        this.idMedicalRecordIdPrescription = idMedicalRecordIdPrescription;
    }
}