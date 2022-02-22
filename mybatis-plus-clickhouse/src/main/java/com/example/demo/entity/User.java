package com.example.demo.entity;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class User implements Serializable {
    //clickhouse 不支持自增主键 type=IdType.AUTO java.sql.SQLFeatureNotSupportedException: ClickHouse does not support auto generated keys
    @TableId(value = "id")
    private Integer id;//UInt64 clickhouse主键只提供了数据的一级索引，但是却不是唯一约束。

    private String username;

    private String password;

    private String email;

    private Date createTime;//clickhouse完整日期 DateTime64

    private Date updateTime;//clickhouse完整日期 DateTime64

    @DateTimeFormat(pattern="yyyy-MM-dd")//页面写入数据库时格式化
    public Date partition;//partition 划分依据:按天 clickhouse日期 Date

    private static final long serialVersionUID = 1L;

    public static User copy(User from){
        User user=new User();
        user.setId(from.getId());
        user.setUsername(from.getUsername());
        user.setEmail(from.getEmail());
        user.setPassword(from.getPassword());

        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Date today= DateUtil.parse(DateUtil.today()).toJdkDate();
        user.setPartition(today);
        return user;

    }
}