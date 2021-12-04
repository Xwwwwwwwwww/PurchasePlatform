package com.xwwwww.purchaseplatform.controller.data;

import com.xwwwww.purchaseplatform.entity.constant.commodity.category.ThirdCategory;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.category.ThirdCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class ThirdCategoryController {
    @Autowired
    ThirdCategoryMapper thirdCategoryMapper;

    @ResponseBody
    @GetMapping("/ThirdCategory")
    public ThirdCategory getThirdCategoryByid(int id) throws Exception{
        return thirdCategoryMapper.selectById(id);
    }

    @ResponseBody
    @PostMapping("/ThirdCategory")
    public int insertThirdCategory(ThirdCategory ThirdCategory) throws Exception{
        return thirdCategoryMapper.insert(ThirdCategory);
    }

    @ResponseBody
    @DeleteMapping("/ThirdCategory")
    public int deleteThirdCategoryByid(int id) throws Exception{
        return thirdCategoryMapper.deleteById((id));
    }

    @ResponseBody
    @PutMapping("/ThirdCategory")
    public int updateThirdCategory(ThirdCategory ThirdCategory) throws  Exception{
        return thirdCategoryMapper.updateById(ThirdCategory);
    }
}
