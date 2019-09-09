package com.wz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.mapper.ICameraInfoMapper;
import com.wz.model.entity.CameraInfo;

import com.wz.service.CameraInfoService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CameraInfoServiceImpl extends ServiceImpl<ICameraInfoMapper,CameraInfo> implements CameraInfoService {

    /**
     * 当参数的key与第一次的一致时会走缓存，缓存的名字是find_cameras_by_page
     * @param key
     * @param page
     * @param limit
     * @return
     */
    @Cacheable(value = "find_cameras_by_page",condition = "#key")
    public List<CameraInfo> page(String key,Integer page,Integer limit) {
        IPage<CameraInfo> cameraLists = page(new Page<>(page, limit));
        List<CameraInfo> records = cameraLists.getRecords();
        return records;
    }

}
