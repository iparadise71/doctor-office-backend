package samuel.choque.doctoroffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import samuel.choque.doctoroffice.dao.MedicalRecordDao;
import samuel.choque.doctoroffice.dao.PatientDao;
import samuel.choque.doctoroffice.model.Doctor;
import samuel.choque.doctoroffice.model.MedicalRecord;
import samuel.choque.doctoroffice.model.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@Path("/medical-record")
public class MedicalRecordController {

    @Autowired
    MedicalRecordDao medicalRecordDao;

    @GET
    @Path("/list")
    @Produces("application/json")
    public Response getMedicalRecords() {

        LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            List<MedicalRecord> listMedicalRecords = medicalRecordDao.getPatients();
            if (listMedicalRecords == null) {
                response.put("medicalRecord", Collections.emptyMap());
            } else {
                response.put("total", listMedicalRecords.size());
                response.put("medicalRecord", listMedicalRecords);
            }
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception ex) {
            response.put("medicalRecord", "Not Found Medical Records");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
    }

    @POST
    @Path("/list-record-by-doctor")
    @Produces("application/json")
    public Response getListMedicalRecordByDoctor(@RequestBody Doctor doctor) {
        LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            List<MedicalRecord> listMedicalRecordsByDoctor = medicalRecordDao.getListMedicalRecordByDoctor(doctor);
            if (listMedicalRecordsByDoctor == null) {
                response.put("medicalRecord", Collections.emptyMap());
            } else {
                response.put("total", listMedicalRecordsByDoctor.size());
                response.put("medicalRecord", listMedicalRecordsByDoctor);
            }
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception ex) {

            response.put("medicalRecord", "Not Found Doctor");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
    }

    @POST
    @Path("/list-record-by-patient")
    @Produces("application/json")
    public Response getListMedicalRecordByPatient(@RequestBody Patient patient) {
        LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            List<MedicalRecord> listMedicalRecordsByPatient = medicalRecordDao.getListMedicalRecordByPatient(patient);
            if (listMedicalRecordsByPatient == null) {
                response.put("medicalRecord", Collections.emptyMap());
            } else {
                response.put("total", listMedicalRecordsByPatient.size());
                response.put("medicalRecord", listMedicalRecordsByPatient);
            }
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception ex) {

            response.put("medicalRecord", "Not Found Doctor");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
    }

    @PUT
    @Path("/register")
    @Produces("application/json")
    public Response setMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            MedicalRecord saveMedicalRecord = medicalRecordDao.setMedicalRecord(medicalRecord);
            if (saveMedicalRecord == null) {
                response.put("medicalRecord", Collections.emptyMap());
            } else {
                response.put("medicalRecord", saveMedicalRecord);
            }
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception ex) {

            response.put("medicalRecord", "Not Found Doctor");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
    }
}
