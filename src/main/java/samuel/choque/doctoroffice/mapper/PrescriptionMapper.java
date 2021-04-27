package samuel.choque.doctoroffice.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import samuel.choque.doctoroffice.model.Doctor;
import samuel.choque.doctoroffice.model.Prescription;
import samuel.choque.doctoroffice.model.PrescriptionKey;

import java.util.List;

@Mapper
public interface PrescriptionMapper {
    @Delete({
        "delete from prescription",
        "where id_prescription = #{idPrescription,jdbcType=INTEGER}",
          "and id_medical_record_id_prescription = #{idMedicalRecordIdPrescription,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(PrescriptionKey key);

    @Insert({
        "insert into prescription (id_prescription, id_medical_record_id_prescription, ",
        "medicine_detail, quantity)",
        "values (#{idPrescription,jdbcType=INTEGER}, #{idMedicalRecordIdPrescription,jdbcType=INTEGER}, ",
        "#{medicineDetail,jdbcType=VARCHAR}, #{quantity,jdbcType=VARCHAR})"
    })
    int insert(Prescription record);

    @Insert({
            "<script>",
            "insert into prescription (id_prescription, id_medical_record_id_prescription, ",
            "medicine_detail, quantity)",
            "VALUES" +
                    "<foreach item='each_item_name' collection='recordList' open='' separator=',' close=''>" +
                    "(" +
                        "#{each_item_name.idPrescription,jdbcType=INTEGER},",
                        "#{idMedicalRecord,jdbcType=INTEGER},",
                        "#{each_item_name.medicineDetail,jdbcType=VARCHAR},",
                        "#{each_item_name.quantity,jdbcType=VARCHAR}"+
                    ")" +
                    "</foreach>",
            "</script>"})
    void insertPrescriptionList(@Param("recordList") List<Prescription> recordList, @Param("idMedicalRecord") int idMedicalRecord);


    @InsertProvider(type=PrescriptionSqlProvider.class, method="insertSelective")
    int insertSelective(Prescription record);

    @Select({
        "select",
        "id_prescription, id_medical_record_id_prescription, medicine_detail, quantity",
        "from prescription",
        "where id_prescription = #{idPrescription,jdbcType=INTEGER}",
          "and id_medical_record_id_prescription = #{idMedicalRecordIdPrescription,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_prescription", property="idPrescription", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_medical_record_id_prescription", property="idMedicalRecordIdPrescription", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="medicine_detail", property="medicineDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.VARCHAR)
    })
    Prescription selectByPrimaryKey(PrescriptionKey key);

    @UpdateProvider(type=PrescriptionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Prescription record);

    @Update({
        "update prescription",
        "set medicine_detail = #{medicineDetail,jdbcType=VARCHAR},",
          "quantity = #{quantity,jdbcType=VARCHAR}",
        "where id_prescription = #{idPrescription,jdbcType=INTEGER}",
          "and id_medical_record_id_prescription = #{idMedicalRecordIdPrescription,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Prescription record);

    @Select({
        "select",
        "id_prescription, id_medical_record_id_prescription, medicine_detail, quantity",
        "from prescription",
        "where id_medical_record_id_prescription = #{idMedicalRecord,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id_prescription", property="idPrescription", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="id_medical_record_id_prescription", property="idMedicalRecordIdPrescription", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="medicine_detail", property="medicineDetail", jdbcType=JdbcType.VARCHAR),
            @Result(column="quantity", property="quantity", jdbcType=JdbcType.VARCHAR)
    })
    List<Prescription> getListPrescriptions(@Param("id_medical_record") Integer idMedicalRecord);
}