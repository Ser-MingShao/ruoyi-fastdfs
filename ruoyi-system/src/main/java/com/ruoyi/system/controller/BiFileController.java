package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.service.ISysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.BiFile;
import com.ruoyi.system.service.IBiFileService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文件列表Controller
 *
 * @author ruoyi
 * @date 2023-09-15
 */
@Controller
@CrossOrigin
@RequestMapping("/system/file")
public class BiFileController extends BaseController {
    private String prefix = "system/file";

    @Autowired
    private IBiFileService biFileService;

    @Autowired
    private ISysConfigService configService;

    @RequiresPermissions("system:file:view")
    @GetMapping()
    public String file(ModelMap mmap) {
        String ftype = getRequest().getParameter("ftype");
        if (ftype == null) {
            ftype = "";
        }
        mmap.put("ftype", ftype);
        return prefix + "/file";
    }

    /**
     * 查询文件列表列表
     */
    @RequiresPermissions("system:file:list")
    @PostMapping("/list")
    @ResponseBody

    public TableDataInfo list(BiFile biFile) {
//        String ftype = getRequest().getParameter("ftype");
//        biFile.setFtype(ftype);
        startPage();
        List<BiFile> list = biFileService.selectBiFileList(biFile);
        return getDataTable(list);
    }

    /**
     * 导出文件列表列表
     */
    @RequiresPermissions("system:file:export")
    @Log(title = "文件列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiFile biFile) {
        List<BiFile> list = biFileService.selectBiFileList(biFile);
        ExcelUtil<BiFile> util = new ExcelUtil<BiFile>(BiFile.class);
        return util.exportExcel(list, "文件列表数据");
    }

    /**
     * 新增文件列表
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        String gofastdfsHost = Convert.toStr(configService.selectConfigByKey("bi.file.upload.host"), "");
        Integer gofastdfsPort = Convert.toInt(configService.selectConfigByKey("bi.file.upload.port"), 0);
        mmap.put("fsHost", gofastdfsHost);
        mmap.put("fsPort", gofastdfsPort);
        return prefix + "/add";
    }

    /**
     * 新增保存文件列表
     */
    @RequiresPermissions("system:file:add")
    @Log(title = "文件列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BiFile biFile) {
        return toAjax(biFileService.insertBiFile(biFile));
    }

    /**
     * 修改文件列表
     */
    @RequiresPermissions("system:file:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        BiFile biFile = biFileService.selectBiFileById(id);
        mmap.put("biFile", biFile);
        return prefix + "/edit";
    }

    /**
     * 修改保存文件列表
     */
    @RequiresPermissions("system:file:edit")
    @Log(title = "文件列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BiFile biFile) {
        return toAjax(biFileService.updateBiFile(biFile));
    }

    /**
     * 删除文件列表
     */
    @RequiresPermissions("system:file:remove")
    @Log(title = "文件列表", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(biFileService.deleteBiFileByIds(ids));
    }
}
