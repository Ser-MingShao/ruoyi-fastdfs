package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BiFileMapper;
import com.ruoyi.system.domain.BiFile;
import com.ruoyi.system.service.IBiFileService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文件列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-15
 */
@Service
public class BiFileServiceImpl implements IBiFileService 
{
    @Autowired
    private BiFileMapper biFileMapper;

    /**
     * 查询文件列表
     * 
     * @param id 文件列表主键
     * @return 文件列表
     */
    @Override
    public BiFile selectBiFileById(Long id)
    {
        return biFileMapper.selectBiFileById(id);
    }

    /**
     * 查询文件列表列表
     * 
     * @param biFile 文件列表
     * @return 文件列表
     */
    @Override
    public List<BiFile> selectBiFileList(BiFile biFile)
    {
        return biFileMapper.selectBiFileList(biFile);
    }

    /**
     * 新增文件列表
     * 
     * @param biFile 文件列表
     * @return 结果
     */
    @Override
    public int insertBiFile(BiFile biFile)
    {
        return biFileMapper.insertBiFile(biFile);
    }

    /**
     * 修改文件列表
     * 
     * @param biFile 文件列表
     * @return 结果
     */
    @Override
    public int updateBiFile(BiFile biFile)
    {
        biFile.setUpdateTime(DateUtils.getNowDate());
        return biFileMapper.updateBiFile(biFile);
    }

    /**
     * 批量删除文件列表
     * 
     * @param ids 需要删除的文件列表主键
     * @return 结果
     */
    @Override
    public int deleteBiFileByIds(String ids)
    {
        return biFileMapper.deleteBiFileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文件列表信息
     * 
     * @param id 文件列表主键
     * @return 结果
     */
    @Override
    public int deleteBiFileById(Long id)
    {
        return biFileMapper.deleteBiFileById(id);
    }
}
