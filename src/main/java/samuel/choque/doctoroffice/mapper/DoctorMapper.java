package samuel.choque.doctoroffice.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import samuel.choque.doctoroffice.model.Doctor;

import java.util.List;

@Mapper
public interface DoctorMapper {
    @Delete({
        "delete from doctor",
        "where id_doctor = #{idDoctor,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idDoctor);

    @Insert({
        "insert into doctor (id_doctor, name, ",
        "last_name, speciality, ",
        "birthday, address, ",
        "photo)",
        "values (#{idDoctor,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{lastName,jdbcType=VARCHAR}, #{speciality,jdbcType=VARCHAR}, ",
        "#{birthday,jdbcType=DATE}, #{address,jdbcType=VARCHAR}, ",
        "#{photo,jdbcType=VARCHAR})"
    })
    int insert(Doctor record);

    @InsertProvider(type=DoctorSqlProvider.class, method="insertSelective")
    int insertSelective(Doctor record);


    @Insert({
            "insert into doctor (id_doctor, name, ",
            "last_name, speciality, ",
            "birthday, address, ",
            "photo)",
            "values (#{idDoctor,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{lastName,jdbcType=VARCHAR}, #{speciality,jdbcType=VARCHAR}, ",
            "#{birthday,jdbcType=DATE}, #{address,jdbcType=VARCHAR}, ",
            "#{photo,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true,keyProperty = "idDoctor",keyColumn = "id_doctor")
    void insertDoctor(Doctor record);

    @Select({
        "select",
        "id_doctor, name, last_name, speciality, birthday, address, photo",
        "from doctor",
        "where id_doctor = #{idDoctor,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_doctor", property="idDoctor", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="speciality", property="speciality", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR)
    })
    Doctor selectByPrimaryKey(Integer idDoctor);

    @UpdateProvider(type=DoctorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Doctor record);

    @Update({
        "update doctor",
        "set name = #{name,jdbcType=VARCHAR},",
          "last_name = #{lastName,jdbcType=VARCHAR},",
          "speciality = #{speciality,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "address = #{address,jdbcType=VARCHAR},",
          "photo = #{photo,jdbcType=VARCHAR}",
        "where id_doctor = #{idDoctor,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Doctor record);

    @Select("select * from doctor")
    @Results({
            @Result(column="id_doctor", property="idDoctor", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
            @Result(column="speciality", property="speciality", jdbcType=JdbcType.VARCHAR),
            @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR)
    })
    List<Doctor> getDoctors();
}