package samuel.choque.doctoroffice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import samuel.choque.doctoroffice.mapper.PatientMapper;
import samuel.choque.doctoroffice.model.Doctor;
import samuel.choque.doctoroffice.model.Patient;

import java.util.Collections;
import java.util.List;

@Component
public class PatientDao {

    @Autowired
    PatientMapper patientMapper;

    public List<Patient> getPatients() {
        return Collections.unmodifiableList(patientMapper.getPatients());
    }
    public Patient getDetailPatient(Patient patient) {
        return patientMapper.selectByPrimaryKey(patient.getIdPatient());
    }

    public Patient savePatient(Patient patient) {
        patientMapper.insertPatient(patient);
        return patient;
    }
}
