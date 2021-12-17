package com.xwwwww.purchaseplatform.controller.shopping;

import com.xwwwww.purchaseplatform.service.shopping.DisplayCategoryService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class DisplayCategoryController {
    @Autowired
    DisplayCategoryService displayCategoryService;

    @ResponseBody
    @GetMapping("/display/first")
    public Result displayFirst() throws Exception{
        return displayCategoryService.DisplayFirst();
    }

    @ResponseBody
    @GetMapping("/display/single")
    public Result displaySingle(int id) throws Exception{
        return displayCategoryService.DisplaySingle(id);
    }
}
