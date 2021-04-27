package samuel.choque.doctoroffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import samuel.choque.doctoroffice.dao.DoctorDao;
import samuel.choque.doctoroffice.model.Doctor;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Controller
@Path("/doctor")
public class DoctorController {

    @Autowired
    DoctorDao doctorDao;

    @GET
    public String sayHello() {
        return "Hello Doctor!";
    }

    @GET
    @Path("/list")
    @Produces("application/json")
    public Response getDoctors() {
        LinkedHashMap<String, Object> response = new LinkedHashMap<String, Object>();
        try {
            List<Doctor> listDoctors = doctorDao.getDoctors();
            if (listDoctors == null) {
                System.out.println("NULL DOCTORS");
                response.put("doctors", Collections.emptyMap());
            } else {
                System.out.println("ALL DOCTORS");
                response.put("total", listDoctors.size());
                response.put("doctors", listDoctors);
            }
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception ex) {

            response.put("doctor", "Not Found Doctors");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
    }

    @POST
    @Path("/detail-doctor")
    @Produces("application/json")
    public Response getDetailDoctor(@RequestBody Doctor doctor) {
        HashMap<String, Object> response = new HashMap<String, Object>();
        try {
            Doctor doctorDetail = doctorDao.getDetailDoctor(doctor);
            if (doctorDetail == null) {
                response.put("doctor", Collections.emptyMap());
            } else {
                response.put("doctor", doctorDetail);
            }
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception ex) {

            response.put("doctor", "Not Found Doctor");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
    }

    @PUT
    @Path("/enroll")
    @Produces("application/json")
    public Response saveDoctor(@RequestBody Doctor doctor) {
        HashMap<String, Object> response = new HashMap<String, Object>();
        try {
            Doctor doctorDetail = doctorDao.saveDoctor(doctor);
            if (doctorDetail == null) {
                response.put("doctor", Collections.emptyMap());
            } else {
                response.put("doctor", doctorDetail);
            }
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception ex) {

            response.put("doctor", "Not Found Doctor");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
        }
    }
}
