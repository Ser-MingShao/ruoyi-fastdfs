package com.ruoyi.system.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.BiFile;
import com.ruoyi.system.service.IBiFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author mao
 * @date 2023/9/15 17:21
 */
@Controller
@CrossOrigin
@RequestMapping("/api/file")
public class BiFileApiController extends BaseController {
    @Autowired
    private IBiFileService biFileService;

    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(BiFile biFile)
    {
        startPage();
        List<BiFile> list = biFileService.selectBiFileList(biFile);
        return getDataTable(list);
    }
}
