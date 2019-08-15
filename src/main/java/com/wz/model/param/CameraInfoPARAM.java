package com.wz.model.param;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CameraInfoPARAM {

    /**
     *  编号id
     */
    @NotBlank(message = "摄像头id不为空")
    @TableId(type = IdType.AUTO)
    private String id;
    /**
     * 城市
     */
    @NotBlank(message = "摄像头所属城市不为空")
    private String city;
    /**
     * 所属区县
     */
    @NotBlank(message = "摄像头所属区县不为空")
    private String county;
    /**
     * 详细地址
     *
     */
    @NotBlank(message = "详细地址不为空")
    private String addr;
    /**
     * rtsp url地址
     */
    @NotBlank(message = "rtspuri不为空")
    private String rtspuri;

    /**
     * 摄像头状态
     */

    @Max(message = "状态最大为1",value = 1)
    @Min(message = "状态最小为0",value = 0)
    private Integer status;// off,on

    /**
     * 摄像头端口
     */
    @NotNull(message = "端口不为null")
    private Integer port;

    /**
     * 摄像头名称
     */
    @NotBlank(message = "摄像头名称不为空")
    private String name;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不为空")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不为空")
    private String password;

    /**
     * 摄像头能力 0: 抓拍模式 1： 取ipc流软解码 2：取IPC流硬解码 3：取rtsp流软解码 4：取rtsp流硬解码
     */
   /* @Max(value = 4)
    @Min(value = 0)*/
    private Integer capability;//
    /**
     * 1 2 3 类高清
     */
   /* @Max(value = 3)
    @Min(value = 1)*/
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
