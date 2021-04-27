package samuel.choque.doctoroffice.mapper;

import org.apache.ibatis.jdbc.SQL;
import samuel.choque.doctoroffice.model.Patient;

public class PatientSqlProvider {

    public String insertSelective(Patient record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("patient");
        
        if (record.getIdPatient() != null) {
            sql.VALUES("id_patient", "#{idPatient,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getLastName() != null) {
            sql.VALUES("last_name", "#{lastName,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            sql.VALUES("birthday", "#{birthday,jdbcType=DATE}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoto() != null) {
            sql.VALUES("photo", "#{photo,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Patient record) {
        SQL sql = new SQL();
        sql.UPDATE("patient");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getLastName() != null) {
            sql.SET("last_name = #{lastName,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            sql.SET("birthday = #{birthday,jdbcType=DATE}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoto() != null) {
            sql.SET("photo = #{photo,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id_patient = #{idPatient,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}