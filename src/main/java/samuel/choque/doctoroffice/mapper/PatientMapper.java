package samuel.choque.doctoroffice.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import samuel.choque.doctoroffice.model.Doctor;
import samuel.choque.doctoroffice.model.Patient;

import java.util.List;

@Mapper
public interface PatientMapper {
    @Delete({
        "delete from patient",
        "where id_patient = #{idPatient,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idPatient);

    @Insert({
        "insert into patient (id_patient, name, ",
        "last_name, birthday, ",
        "address, photo)",
        "values (#{idPatient,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{lastName,jdbcType=VARCHAR}, #{birthday,jdbcType=DATE}, ",
        "#{address,jdbcType=VARCHAR}, #{photo,jdbcType=VARCHAR})"
    })
    int insert(Patient record);

    @InsertProvider(type=PatientSqlProvider.class, method="insertSelective")
    int insertSelective(Patient record);


    @Insert({
            "insert into patient (id_patient, name, ",
            "last_name, birthday, ",
            "address, photo)",
            "values (#{idPatient,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{lastName,jdbcType=VARCHAR}, #{birthday,jdbcType=DATE}, ",
            "#{address,jdbcType=VARCHAR}, #{photo,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true,keyProperty = "idPatient",keyColumn = "id_patient")
    void insertPatient(Patient record);

    @Select({
        "select",
        "id_patient, name, last_name, birthday, address, photo",
        "from patient",
        "where id_patient = #{idPatient,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_patient", property="idPatient", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR)
    })
    Patient selectByPrimaryKey(Integer idPatient);

    @UpdateProvider(type=PatientSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Patient record);

    @Update({
        "update patient",
        "set name = #{name,jdbcType=VARCHAR},",
          "last_name = #{lastName,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "address = #{address,jdbcType=VARCHAR},",
          "photo = #{photo,jdbcType=VARCHAR}",
        "where id_patient = #{idPatient,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Patient record);

    @Select("select * from patient")
    @Results({
            @Result(column="id_patient", property="idPatient", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
            @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR)
    })
    List<Patient> getPatients();
}