package com.example.covidbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.covidbackend.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {

}
