package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BiFile;

/**
 * 文件列表Mapper接口
 * 
 * @author ruoyi
 * @date 2023-09-15
 */
public interface BiFileMapper 
{
    /**
     * 查询文件列表
     * 
     * @param id 文件列表主键
     * @return 文件列表
     */
    public BiFile selectBiFileById(Long id);

    /**
     * 查询文件列表列表
     * 
     * @param biFile 文件列表
     * @return 文件列表集合
     */
    public List<BiFile> selectBiFileList(BiFile biFile);

    /**
     * 新增文件列表
     * 
     * @param biFile 文件列表
     * @return 结果
     */
    public int insertBiFile(BiFile biFile);

    /**
     * 修改文件列表
     * 
     * @param biFile 文件列表
     * @return 结果
     */
    public int updateBiFile(BiFile biFile);

    /**
     * 删除文件列表
     * 
     * @param id 文件列表主键
     * @return 结果
     */
    public int deleteBiFileById(Long id);

    /**
     * 批量删除文件列表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBiFileByIds(String[] ids);
}
