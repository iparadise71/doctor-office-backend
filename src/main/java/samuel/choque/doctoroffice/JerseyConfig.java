package samuel.choque.doctoroffice;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import samuel.choque.doctoroffice.controller.CORSResponseFilter;
import samuel.choque.doctoroffice.controller.DoctorController;
import samuel.choque.doctoroffice.controller.MedicalRecordController;
import samuel.choque.doctoroffice.controller.PatientController;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(CORSResponseFilter.class);
        register(DoctorController.class);
        register(PatientController.class);
        register(MedicalRecordController.class);
    }
}