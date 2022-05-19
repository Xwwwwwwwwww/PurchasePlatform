package com.xwwwww.purchaseplatform.controller.constant;

import com.xwwwww.purchaseplatform.service.shopping.DisplayCategoryService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="商品分类模块")
@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class DisplayCategoryController {
    @Autowired
    DisplayCategoryService displayCategoryService;

    @ApiOperation(value="估计是获取侧边栏分类")
    @ResponseBody
    @GetMapping("/display/first")
    public Result displayFirst() throws Exception{
        return displayCategoryService.DisplayFirst();
    }

    @ApiOperation(value="估计根据侧边栏id获取具体分类")
    @ResponseBody
    @GetMapping("/display/single")
    public Result displaySingle(int id) throws Exception{
        return displayCategoryService.DisplaySingle(id);
    }
}
