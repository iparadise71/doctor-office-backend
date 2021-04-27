package samuel.choque.doctoroffice.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import samuel.choque.doctoroffice.model.*;

import javax.persistence.SqlResultSetMapping;
import java.util.List;

@Mapper
public interface MedicalRecordMapper {
    @Delete({
        "delete from medical_record",
        "where id_medical_record = #{idMedicalRecord,jdbcType=INTEGER}",
          "and id_patient_medical_record = #{idPatientMedicalRecord,jdbcType=INTEGER}",
          "and id_doctor_medical_record = #{idDoctorMedicalRecord,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(MedicalRecordKey key);

    @Insert({
        "insert into medical_record (id_medical_record, id_patient_medical_record, ",
        "id_doctor_medical_record, description, ",
        "date, prescription_drug)",
        "values (#{idMedicalRecord,jdbcType=INTEGER}, #{idPatientMedicalRecord,jdbcType=INTEGER}, ",
        "#{idDoctorMedicalRecord,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR}, ",
        "#{date,jdbcType=TIMESTAMP}, #{prescriptionDrug,jdbcType=VARCHAR})"
    })
    int insert(MedicalRecord record);

    @InsertProvider(type=MedicalRecordSqlProvider.class, method="insertSelective")
    int insertSelective(MedicalRecord record);

    @Insert({
            "insert into medical_record (id_medical_record, id_patient_medical_record, ",
            "id_doctor_medical_record, description, ",
            "date, prescription_drug)",
            "values (#{idMedicalRecord,jdbcType=INTEGER}, #{idPatientMedicalRecord,jdbcType=INTEGER}, ",
            "#{idDoctorMedicalRecord,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR}, ",
            "#{date,jdbcType=TIMESTAMP}, #{prescriptionDrug,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true,keyProperty = "idMedicalRecord",keyColumn = "id_medical_record")
    int insertMedicalRecord(MedicalRecord record);

    @Select({
        "select",
        "id_medical_record, id_patient_medical_record, id_doctor_medical_record, description, ",
        "date, prescription_drug",
        "from medical_record",
        "where id_medical_record = #{idMedicalRecord,jdbcType=INTEGER}",
          "and id_patient_medical_record = #{idPatientMedicalRecord,jdbcType=INTEGER}",
          "and id_doctor_medical_record = #{idDoctorMedicalRecord,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_medical_record", property="idMedicalRecord", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_patient_medical_record", property="idPatientMedicalRecord", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_doctor_medical_record", property="idDoctorMedicalRecord", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="prescription_drug", property="prescriptionDrug", jdbcType=JdbcType.VARCHAR)
    })
    MedicalRecord selectByPrimaryKey(MedicalRecordKey key);

    @UpdateProvider(type=MedicalRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MedicalRecord record);

    @Update({
        "update medical_record",
        "set description = #{description,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=TIMESTAMP},",
          "prescription_drug = #{prescriptionDrug,jdbcType=VARCHAR}",
        "where id_medical_record = #{idMedicalRecord,jdbcType=INTEGER}",
          "and id_patient_medical_record = #{idPatientMedicalRecord,jdbcType=INTEGER}",
          "and id_doctor_medical_record = #{idDoctorMedicalRecord,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MedicalRecord record);

    @Select("select * from medical_record")
    @Results({
            @Result(column="id_medical_record", property="idMedicalRecord", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="id_patient_medical_record", property="idPatientMedicalRecord", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="id_doctor_medical_record", property="idDoctorMedicalRecord", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="prescription_drug", property="prescriptionDrug", jdbcType=JdbcType.VARCHAR),
            @Result(property="doctor", column="id_doctor_medical_record", javaType=Doctor.class, one=@One(select="samuel.choque.doctoroffice.mapper.DoctorMapper.selectByPrimaryKey")),
            @Result(property="patient", column="id_patient_medical_record", javaType= Patient.class, one=@One(select="samuel.choque.doctoroffice.mapper.PatientMapper.selectByPrimaryKey")),
            @Result(property="prescriptionList", column="id_medical_record", javaType= List.class, many=@Many(select="samuel.choque.doctoroffice.mapper.PrescriptionMapper.getListPrescriptions"))
    })
    List<MedicalRecord> getMedicalRecords();

    @Select({
            "select * from medical_record",
            "where id_doctor_medical_record = #{idDoctor,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id_medical_record", property="idMedicalRecord", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="id_patient_medical_record", property="idPatientMedicalRecord", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="id_doctor_medical_record", property="idDoctorMedicalRecord", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="prescription_drug", property="prescriptionDrug", jdbcType=JdbcType.VARCHAR),
            @Result(property="doctor", column="id_doctor_medical_record", javaType=Doctor.class, one=@One(select="samuel.choque.doctoroffice.mapper.DoctorMapper.selectByPrimaryKey")),
            @Result(property="patient", column="id_patient_medical_record", javaType= Patient.class, one=@One(select="samuel.choque.doctoroffice.mapper.PatientMapper.selectByPrimaryKey")),
            @Result(property="prescriptionList", column="id_medical_record", javaType= List.class, many=@Many(select="samuel.choque.doctoroffice.mapper.PrescriptionMapper.getListPrescriptions"))
    })
    List<MedicalRecord> getListMedicalRecordByDoctor(@Param("idDoctor") Integer idDoctor);

    @Select({
            "select * from medical_record",
            "where id_patient_medical_record = #{idPatient,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id_medical_record", property="idMedicalRecord", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="id_doctor_medical_record", property="idDoctorMedicalRecord", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="id_patient_medical_record", property="idPatientMedicalRecord", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="prescription_drug", property="prescriptionDrug", jdbcType=JdbcType.VARCHAR),
            @Result(property="doctor", column="id_doctor_medical_record", javaType=Doctor.class, one=@One(select="samuel.choque.doctoroffice.mapper.DoctorMapper.selectByPrimaryKey")),
            @Result(property="patient", column="id_patient_medical_record", javaType= Patient.class, one=@One(select="samuel.choque.doctoroffice.mapper.PatientMapper.selectByPrimaryKey")),
            @Result(property="prescriptionList", column="id_medical_record", javaType= List.class, many=@Many(select="samuel.choque.doctoroffice.mapper.PrescriptionMapper.getListPrescriptions"))
    })
    List<MedicalRecord> getListMedicalRecordByPatient(@Param("idPatient") Integer idDoctor);
}