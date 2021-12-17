package com.xwwwww.purchaseplatform.controller.data;

import com.xwwwww.purchaseplatform.entity.constant.commodity.category.FirstCategory;
import com.xwwwww.purchaseplatform.entity.constant.commodity.status.CommodityStatus;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.category.FirstCategoryMapper;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.status.CommodityStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/data")
public class FirstCategoryController {
    @Autowired
    FirstCategoryMapper firstCategoryMapper;

    @ResponseBody
    @GetMapping("/FirstCategory")
    public FirstCategory getFirstCategoryByid(int id) throws Exception{
        return firstCategoryMapper.selectById(id);
    }

    @ResponseBody
    @PostMapping("/FirstCategory")
    public int insertFirstCategory(FirstCategory firstCategory) throws Exception{
        return firstCategoryMapper.insert(firstCategory);
    }

    @ResponseBody
    @DeleteMapping("/FirstCategory")
    public int deleteFirstCategoryByid(int id) throws Exception{
        return firstCategoryMapper.deleteById((id));
    }

    @ResponseBody
    @PutMapping("/FirstCategory")
    public int updateFirstCategory(FirstCategory firstCategory) throws  Exception{
        return firstCategoryMapper.updateById(firstCategory);
    }
}
