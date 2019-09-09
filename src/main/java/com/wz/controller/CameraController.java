package com.wz.controller;

import com.wz.exception.CustomException;
import com.wz.model.entity.CameraInfo;
import com.wz.model.Response;
import com.wz.model.param.CameraInfoPARAM;
import com.wz.service.impl.CameraInfoServiceImpl;
import com.wz.util.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.wz.constant.ResponseEnum.CAMERAL_NOT_EXITS;

@RestController
@RequestMapping(value = "/camera")
@Slf4j
@Api(tags = {"camera-api"},description = "摄像头相关的restful api")
public class CameraController extends SuperController{

    @Autowired
    CameraInfoServiceImpl cameraInfoService;

    @PostMapping(value = "/add")
    @ApiOperation(value = "添加摄像头")
    @Cacheable(value = "camraResp")
    public Response addCamera(@RequestBody CameraInfoPARAM cameraInfo) {

        /**
         * 1.参数校验 hibernate validator
         */
        Set<ConstraintViolation<CameraInfoPARAM>> validate = validate(cameraInfo);
        if (!CollectionUtils.isEmpty(validate)) {
            if(validate.iterator().hasNext()) {
                ConstraintViolation<CameraInfoPARAM> next = validate.iterator().next();
                String message = next.getMessage();
                return ResponseUtils.fail(message, 400);
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
            ResponseUtils.fail("保存到数据失败", 400);
        }

        /**
         * 3.正常返回
         */

        return ResponseUtils.success(cameraInfo,"保存成功");

    }

    @GetMapping(value = "/get")
    @ApiOperation(value = "分页获取所有摄像头")
    @ApiImplicitParams(
            {
            @ApiImplicitParam(name = "page",value = "page",dataType = "Integer",required = true,example = "1"),
            @ApiImplicitParam(name = "limit",value = "limit",dataType = "Integer",required = true,example = "10")
            }
    )

    public Response getCamerasByPage(@RequestParam("page") @Validated @NotEmpty Integer page,
                                     @RequestParam("limit") @Validated @NotEmpty  Integer limit) {
        log.info("################请求到来###########");
        String cacheKey = page + ":" + limit;
        List<CameraInfo> pageReuslt = cameraInfoService.page(cacheKey, page, limit);
        return ResponseUtils.success(pageReuslt);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "根据摄像id获取摄像头信息")
    public Response getCameraById(@PathVariable("id") Long id) throws CustomException {
        log.info(">>请求的id={}",id);
        CameraInfo cameraInfo = cameraInfoService.query().eq("id", id).one();
        // 抛出异常 交给全局异常处理 业务参数校验用一个枚举来进行定义
        if(Objects.isNull(cameraInfo)) {
            throw new CustomException(CAMERAL_NOT_EXITS.getCode(), CAMERAL_NOT_EXITS.getMessage());
        }
        return ResponseUtils.success(cameraInfo);

    }
}
