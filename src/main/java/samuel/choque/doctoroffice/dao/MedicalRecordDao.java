package samuel.choque.doctoroffice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import samuel.choque.doctoroffice.mapper.MedicalRecordMapper;
import samuel.choque.doctoroffice.mapper.PrescriptionMapper;
import samuel.choque.doctoroffice.model.Doctor;
import samuel.choque.doctoroffice.model.MedicalRecord;
import samuel.choque.doctoroffice.model.Patient;
import samuel.choque.doctoroffice.model.Prescription;

import java.util.Collections;
import java.util.List;

@Component
public class MedicalRecordDao {

    @Autowired
    MedicalRecordMapper medicalRecordMapper;
    @Autowired
    PrescriptionMapper prescriptionMapper;

    public List<MedicalRecord> getPatients() {
        return Collections.unmodifiableList(medicalRecordMapper.getMedicalRecords());
    }

    public List<MedicalRecord> getListMedicalRecordByDoctor(Doctor doctor) {
        return Collections.unmodifiableList(medicalRecordMapper.getListMedicalRecordByDoctor(doctor.getIdDoctor()));
    }

    public List<MedicalRecord> getListMedicalRecordByPatient(Patient patient) {
        return Collections.unmodifiableList(medicalRecordMapper.getListMedicalRecordByPatient(patient.getIdPatient()));
    }

    public MedicalRecord setMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordMapper.insertMedicalRecord(medicalRecord);
        List<Prescription> prescriptionList = medicalRecord.getPrescriptionList();
        prescriptionMapper.insertPrescriptionList(prescriptionList, medicalRecord.getIdMedicalRecord());
        return medicalRecord;
    }
}
