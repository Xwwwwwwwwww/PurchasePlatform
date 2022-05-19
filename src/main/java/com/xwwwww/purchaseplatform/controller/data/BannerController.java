package com.xwwwww.purchaseplatform.controller.data;

import com.xwwwww.purchaseplatform.entity.constant.banner.Banner;
import com.xwwwww.purchaseplatform.service.data.BannerService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="不用测")
@CrossOrigin
@RestController
@RequestMapping("/data")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @ResponseBody
    @GetMapping("/banner/all")
    public Result getAllBanner() throws Exception{
        return bannerService.getAllBanner();
    }

    @ResponseBody
    @PostMapping("/banner")
    public Result insertBanner(Banner banner) throws Exception{
        return bannerService.insertBanner(banner);
    }

    @ResponseBody
    @DeleteMapping("/banner")
    public Result deleteBanner(int id) throws Exception{
        return bannerService.deleteBanner(id);
    }

    @ResponseBody
    @PutMapping("/banner")
    public Result updateBanner(Banner banner) throws Exception{
        return bannerService.updateBanner(banner);
    }
}
