package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文件列表对象 bi_file
 * 
 * @author ruoyi
 * @date 2023-09-15
 */
public class BiFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 文件名 */
    @Excel(name = "文件名")
    private String name;

    /** 文件版本 */
    @Excel(name = "文件版本")
    private String version;

    /** 适用系统 */
    @Excel(name = "适用系统")
    private String os;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String ftype;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String url;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long size;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getVersion() 
    {
        return version;
    }
    public void setOs(String os) 
    {
        this.os = os;
    }

    public String getOs() 
    {
        return os;
    }
    public void setFtype(String ftype) 
    {
        this.ftype = ftype;
    }

    public String getFtype() 
    {
        return ftype;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setSize(Long size) 
    {
        this.size = size;
    }

    public Long getSize() 
    {
        return size;
    }
    public void setAddTime(Date addTime) 
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("version", getVersion())
            .append("os", getOs())
            .append("ftype", getFtype())
            .append("url", getUrl())
            .append("size", getSize())
            .append("remark", getRemark())
            .append("addTime", getAddTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
