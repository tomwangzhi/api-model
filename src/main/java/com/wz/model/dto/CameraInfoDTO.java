package com.wz.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CameraInfoDTO {

    /**
     *  编号id
     */
    @TableId(type = IdType.AUTO)
    private String id;
    /**
     * 城市
     */
    private String city;
    /**
     * 所属区县
     */
    private String county;
    /**
     * 详细地址
     *
     */
    private String addr;
    /**
     * rtsp url地址
     */
    private String rtspuri;

    /**
     * 摄像头状态
     */
    private Integer status;// off,on

    /**
     * 摄像头端口
     */
    private Integer port;

    /**
     * 摄像头名称
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 摄像头能力 0: 抓拍模式 1： 取ipc流软解码 2：取IPC流硬解码 3：取rtsp流软解码 4：取rtsp流硬解码
     */
    private Integer capability;//
    /**
     * 1 2 3 类高清
     */
    private int cType;

    /**
     * 应用场景类型
     */
    private String appType;
    /**
     * 应用场景类型具体值
     */
    private String appValue;

    /**
     * 在线率（0-未知 1-禁用 2-在线 3-断线）
     */
    private Integer online;
    /**
     * 抓拍状态（0-未知 1-禁用 2-异常 3-正常）
     */
    private Integer snap;

    /**
     * 场所id
     */
    private Integer placeTypeId;

    /**
     * 设备类型id
     */
    private Integer deviceTypeId;
}
