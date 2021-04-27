package samuel.choque.doctoroffice.mapper;

import org.apache.ibatis.jdbc.SQL;
import samuel.choque.doctoroffice.model.Prescription;

public class PrescriptionSqlProvider {

    public String insertSelective(Prescription record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("prescription");
        
        if (record.getIdPrescription() != null) {
            sql.VALUES("id_prescription", "#{idPrescription,jdbcType=INTEGER}");
        }
        
        if (record.getIdMedicalRecordIdPrescription() != null) {
            sql.VALUES("id_medical_record_id_prescription", "#{idMedicalRecordIdPrescription,jdbcType=INTEGER}");
        }
        
        if (record.getMedicineDetail() != null) {
            sql.VALUES("medicine_detail", "#{medicineDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getQuantity() != null) {
            sql.VALUES("quantity", "#{quantity,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Prescription record) {
        SQL sql = new SQL();
        sql.UPDATE("prescription");
        
        if (record.getMedicineDetail() != null) {
            sql.SET("medicine_detail = #{medicineDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getQuantity() != null) {
            sql.SET("quantity = #{quantity,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id_prescription = #{idPrescription,jdbcType=INTEGER}");
        sql.WHERE("id_medical_record_id_prescription = #{idMedicalRecordIdPrescription,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}