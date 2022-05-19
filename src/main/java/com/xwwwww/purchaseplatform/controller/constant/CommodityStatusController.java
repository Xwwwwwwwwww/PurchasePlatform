package com.xwwwww.purchaseplatform.controller.constant;

import com.xwwwww.purchaseplatform.entity.constant.commodity.status.CommodityStatus;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.status.CommodityStatusMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="不用测")
@CrossOrigin
@RestController
@RequestMapping("/data")
public class CommodityStatusController {
    @Autowired
    CommodityStatusMapper commodityStatusMapper;

    @ResponseBody
    @GetMapping("/commoditystatus")
    public CommodityStatus getCommodityStatusById(int id) throws Exception{
        return commodityStatusMapper.selectById(id);
    }

    @ResponseBody
    @PostMapping("/commoditystatus")
    public int insertCommodityStatus(CommodityStatus commodityStatus) throws Exception{
        return commodityStatusMapper.insert(commodityStatus);
    }

    @ResponseBody
    @DeleteMapping("/commoditystatus")
    public int deleteCommodityStatusById(int id) throws Exception{
        return commodityStatusMapper.deleteById((id));
    }

    @ResponseBody
    @PutMapping("/commoditystatus")
    public int updateCommodityStatus(CommodityStatus commodityStatus) throws  Exception{
        return commodityStatusMapper.updateById(commodityStatus);
    }
}
