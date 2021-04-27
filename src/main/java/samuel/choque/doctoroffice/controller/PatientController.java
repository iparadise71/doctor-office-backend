package samuel.choque.doctoroffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import samuel.choque.doctoroffice.dao.DoctorDao;
import samuel.choque.doctoroffice.dao.PatientDao;
import samuel.choque.doctoroffice.model.Doctor;
import samuel.choque.doctoroffice.model.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@Path("/patient")
public class PatientController {

    @Autowired
    PatientDao patientDao;

    @GET
    @Path("/list")
    @Produces("application/json")
    public Response getPatients() {

        LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            List<Patient> listPatients = patientDao.getPatients();
            if (listPatients == null) {
                response.put("patients", Collections.emptyMap());
            } else {
                response.put("total", listPatients.size());
                response.put("patients", listPatients);
            }
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception ex) {

            response.put("patients", "Not Found Patients");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
    }


    @POST
    @Path("/detail-patient")
    @Produces("application/json")
    public Response getDetailDoctor(@RequestBody Patient patient) {
        HashMap<String, Object> response = new HashMap<String, Object>();
        try {
            Patient patientDetail = patientDao.getDetailPatient(patient);
            if (patientDetail == null) {
                response.put("patient", Collections.emptyMap());
            } else {
                response.put("patient", patientDetail);
            }
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception ex) {

            response.put("patient", "Not Found Doctor");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
    }

    @PUT
    @Path("/enroll")
    @Produces("application/json")
    public Response savePatient(@RequestBody Patient patient) {
        HashMap<String, Object> response = new HashMap<String, Object>();
        try {
            Patient patientDetail = patientDao.savePatient(patient);
            if (patientDetail == null) {
                response.put("patient", Collections.emptyMap());
            } else {
                response.put("patient", patientDetail);
            }
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception ex) {

            response.put("patient", "Not Found Doctor");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
    }
}
