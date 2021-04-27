package samuel.choque.doctoroffice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import samuel.choque.doctoroffice.mapper.DoctorMapper;
import samuel.choque.doctoroffice.model.Doctor;

import java.util.Collections;
import java.util.List;

@Component
public class DoctorDao {

    @Autowired
    DoctorMapper doctorMapper;

    public List<Doctor> getDoctors() {
        return Collections.unmodifiableList(doctorMapper.getDoctors());
    }
    public Doctor getDetailDoctor(Doctor doctor) {
        return doctorMapper.selectByPrimaryKey(doctor.getIdDoctor());
    }
    public Doctor saveDoctor(Doctor doctor) {
        doctorMapper.insertDoctor(doctor);
        return doctor;
    }
}
