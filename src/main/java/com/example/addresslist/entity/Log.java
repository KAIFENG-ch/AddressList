package com.example.addresslist.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.addresslist.baseClass.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Transient;

public class Log extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "日志标题")
    private String name;

    @ApiModelProperty(value = "日志类型")
    private Integer logType;

    @ApiModelProperty(value = "日志代码")
    private String code;

    @ApiModelProperty(value = "设备")
    private String device;

    @ApiModelProperty(value = "请求URL")
    private String requestUrl;

    @ApiModelProperty(value = "请求方式")
    private String requestType;

    @ApiModelProperty(value = "参数")
    private String requestParam;

    @ApiModelProperty(value = "触发者")
    private String username;

    @ApiModelProperty(value = "IP地址")
    private String ip;

    @ApiModelProperty(value = "IP定位")
    private String ipInfo;

    @ApiModelProperty(value = "消耗毫秒数")
    private Integer costTime;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "搜索开始时间")
    private String startDate;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "搜索结束时间")
    private String endDate;
}