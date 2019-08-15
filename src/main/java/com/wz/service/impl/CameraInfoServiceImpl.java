package com.wz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.mapper.ICameraInfoMapper;
import com.wz.model.entity.CameraInfo;

import com.wz.service.CameraInfoService;
import org.springframework.stereotype.Service;

@Service
public class CameraInfoServiceImpl extends ServiceImpl<ICameraInfoMapper,CameraInfo> implements CameraInfoService {


}
