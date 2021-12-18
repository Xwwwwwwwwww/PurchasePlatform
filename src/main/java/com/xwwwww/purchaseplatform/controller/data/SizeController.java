package com.xwwwww.purchaseplatform.controller.data;

import com.xwwwww.purchaseplatform.service.data.SizeService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/data")
public class SizeController {
    @Autowired
    SizeService sizeService;

    @ResponseBody
    @GetMapping("/size")
    public Result getSizeBySystem(int belongingSystem) throws Exception{
        return sizeService.getSizeBySystem(belongingSystem);
    }
}
