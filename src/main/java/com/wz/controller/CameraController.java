package com.wz.controller;


import com.wz.model.entity.CameraInfo;
import com.wz.model.Response;
import com.wz.model.param.CameraInfoPARAM;
import com.wz.service.impl.CameraInfoServiceImpl;
import com.wz.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import java.util.Set;

@RestController
@RequestMapping(value = "/camera")
@Slf4j
public class CameraController extends SuperController{

    @Autowired
    CameraInfoServiceImpl cameraInfoService;

    @PostMapping(value = "/add")
    public Response addCamera(@RequestBody CameraInfoPARAM cameraInfo) {

        /**
         * 1.参数校验 hibernate validator
         */
        Set<ConstraintViolation<CameraInfoPARAM>> validate = validate(cameraInfo);
        if (!CollectionUtils.isEmpty(validate)) {
            if(validate.iterator().hasNext()) {
                ConstraintViolation<CameraInfoPARAM> next = validate.iterator().next();
                String message = next.getMessage();
                return ResponseUtil.fail(message, 400);
            }
        }

        /**
         * 2.持久化到数据库
         *
         */
        CameraInfo camera = new CameraInfo();
        BeanUtils.copyProperties(cameraInfo,camera);
        boolean save = cameraInfoService.save(camera);
        if(!save) {
            ResponseUtil.fail("保存到数据失败", 400);
        }

        /**
         * 3.正常返回
         */

        return ResponseUtil.success(cameraInfo,"保存成功");

    }
}
