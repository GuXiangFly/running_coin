package com.running.coins.dao;

import com.running.coins.model.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {
    @Delete({
        "delete from User_Info",
        "where UserId = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into User_Info (UserId, GroupId, ",
        "UserName, Status, ",
        "Role, Coins, TotalDistance, ",
        "MetaData, Icon)",
        "values (#{userId,jdbcType=INTEGER}, #{groupId,jdbcType=INTEGER}, ",
        "#{userName,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{role,jdbcType=VARCHAR}, #{coins,jdbcType=INTEGER}, #{totalDistance,jdbcType=REAL}, ",
        "#{metaData,jdbcType=VARCHAR}, #{icon,jdbcType=LONGVARBINARY})"
    })
    int insert(UserInfo record);

    @InsertProvider(type=UserInfoSqlProvider.class, method="insertSelective")
    int insertSelective(UserInfo record);

    @Select({
        "select",
        "UserId, GroupId, UserName, Status, Role, Coins, TotalDistance, MetaData, Icon",
        "from User_Info",
        "where UserId = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="UserId", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="GroupId", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="UserName", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="Status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="Role", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="Coins", property="coins", jdbcType=JdbcType.INTEGER),
        @Result(column="TotalDistance", property="totalDistance", jdbcType=JdbcType.REAL),
        @Result(column="MetaData", property="metaData", jdbcType=JdbcType.VARCHAR),
        @Result(column="Icon", property="icon", jdbcType=JdbcType.LONGVARBINARY)
    })
    UserInfo selectByPrimaryKey(Integer userId);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserInfo record);

    @Update({
        "update User_Info",
        "set GroupId = #{groupId,jdbcType=INTEGER},",
          "UserName = #{userName,jdbcType=VARCHAR},",
          "Status = #{status,jdbcType=VARCHAR},",
          "Role = #{role,jdbcType=VARCHAR},",
          "Coins = #{coins,jdbcType=INTEGER},",
          "TotalDistance = #{totalDistance,jdbcType=REAL},",
          "MetaData = #{metaData,jdbcType=VARCHAR},",
          "Icon = #{icon,jdbcType=LONGVARBINARY}",
        "where UserId = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(UserInfo record);

    @Update({
        "update User_Info",
        "set GroupId = #{groupId,jdbcType=INTEGER},",
          "UserName = #{userName,jdbcType=VARCHAR},",
          "Status = #{status,jdbcType=VARCHAR},",
          "Role = #{role,jdbcType=VARCHAR},",
          "Coins = #{coins,jdbcType=INTEGER},",
          "TotalDistance = #{totalDistance,jdbcType=REAL},",
          "MetaData = #{metaData,jdbcType=VARCHAR}",
        "where UserId = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserInfo record);

    @Select({
            "select",
            "UserId, GroupId, UserName, Status, Role, Coins, TotalDistance, MetaData, Icon",
            "from User_Info",
            "where GroupId = #{groupId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="UserId", property="userId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="GroupId", property="groupId", jdbcType=JdbcType.INTEGER),
            @Result(column="UserName", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="Status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="Role", property="role", jdbcType=JdbcType.VARCHAR),
            @Result(column="Coins", property="coins", jdbcType=JdbcType.INTEGER),
            @Result(column="TotalDistance", property="totalDistance", jdbcType=JdbcType.REAL),
            @Result(column="MetaData", property="metaData", jdbcType=JdbcType.VARCHAR),
            @Result(column="Icon", property="icon", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<UserInfo> selectByGroupId(Integer groupId);
}