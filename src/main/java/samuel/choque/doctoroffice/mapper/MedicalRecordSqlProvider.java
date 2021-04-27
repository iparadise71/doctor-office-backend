package samuel.choque.doctoroffice.mapper;

import org.apache.ibatis.jdbc.SQL;
import samuel.choque.doctoroffice.model.MedicalRecord;

public class MedicalRecordSqlProvider {

    public String insertSelective(MedicalRecord record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("medical_record");
        
        if (record.getIdMedicalRecord() != null) {
            sql.VALUES("id_medical_record", "#{idMedicalRecord,jdbcType=INTEGER}");
        }
        
        if (record.getIdPatientMedicalRecord() != null) {
            sql.VALUES("id_patient_medical_record", "#{idPatientMedicalRecord,jdbcType=INTEGER}");
        }
        
        if (record.getIdDoctorMedicalRecord() != null) {
            sql.VALUES("id_doctor_medical_record", "#{idDoctorMedicalRecord,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            sql.VALUES("date", "#{date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrescriptionDrug() != null) {
            sql.VALUES("prescription_drug", "#{prescriptionDrug,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(MedicalRecord record) {
        SQL sql = new SQL();
        sql.UPDATE("medical_record");
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            sql.SET("date = #{date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrescriptionDrug() != null) {
            sql.SET("prescription_drug = #{prescriptionDrug,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id_medical_record = #{idMedicalRecord,jdbcType=INTEGER}");
        sql.WHERE("id_patient_medical_record = #{idPatientMedicalRecord,jdbcType=INTEGER}");
        sql.WHERE("id_doctor_medical_record = #{idDoctorMedicalRecord,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}