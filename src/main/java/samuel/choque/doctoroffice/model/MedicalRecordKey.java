package samuel.choque.doctoroffice.model;

public class MedicalRecordKey {
    private Integer idMedicalRecord;

    private Integer idPatientMedicalRecord;

    private Integer idDoctorMedicalRecord;

    public Integer getIdMedicalRecord() {
        return idMedicalRecord;
    }

    public void setIdMedicalRecord(Integer idMedicalRecord) {
        this.idMedicalRecord = idMedicalRecord;
    }

    public Integer getIdPatientMedicalRecord() {
        return idPatientMedicalRecord;
    }

    public void setIdPatientMedicalRecord(Integer idPatientMedicalRecord) {
        this.idPatientMedicalRecord = idPatientMedicalRecord;
    }

    public Integer getIdDoctorMedicalRecord() {
        return idDoctorMedicalRecord;
    }

    public void setIdDoctorMedicalRecord(Integer idDoctorMedicalRecord) {
        this.idDoctorMedicalRecord = idDoctorMedicalRecord;
    }
}