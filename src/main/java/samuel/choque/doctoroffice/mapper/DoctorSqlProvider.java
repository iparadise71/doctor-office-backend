package samuel.choque.doctoroffice.mapper;

import org.apache.ibatis.jdbc.SQL;
import samuel.choque.doctoroffice.model.Doctor;

public class DoctorSqlProvider {

    public String insertSelective(Doctor record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("doctor");
        
        if (record.getIdDoctor() != null) {
            sql.VALUES("id_doctor", "#{idDoctor,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getLastName() != null) {
            sql.VALUES("last_name", "#{lastName,jdbcType=VARCHAR}");
        }
        
        if (record.getSpeciality() != null) {
            sql.VALUES("speciality", "#{speciality,jdbcType=VARCHAR}");
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

    public String updateByPrimaryKeySelective(Doctor record) {
        SQL sql = new SQL();
        sql.UPDATE("doctor");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getLastName() != null) {
            sql.SET("last_name = #{lastName,jdbcType=VARCHAR}");
        }
        
        if (record.getSpeciality() != null) {
            sql.SET("speciality = #{speciality,jdbcType=VARCHAR}");
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
        
        sql.WHERE("id_doctor = #{idDoctor,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}