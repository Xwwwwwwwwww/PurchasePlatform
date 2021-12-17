package com.xwwwww.purchaseplatform.controller.data;

import com.xwwwww.purchaseplatform.entity.constant.commodity.category.SecondCategory;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.category.SecondCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/data")
public class SecondCategoryController {
    @Autowired
    SecondCategoryMapper SecondCategoryMapper;

    @ResponseBody
    @GetMapping("/SecondCategory")
    public SecondCategory getSecondCategoryByid(int id) throws Exception{
        return SecondCategoryMapper.selectById(id);
    }

    @ResponseBody
    @PostMapping("/SecondCategory")
    public int insertSecondCategory(SecondCategory secondCategory) throws Exception{
        return SecondCategoryMapper.insert(secondCategory);
    }

    @ResponseBody
    @DeleteMapping("/SecondCategory")
    public int deleteSecondCategoryByid(int id) throws Exception{
        return SecondCategoryMapper.deleteById((id));
    }

    @ResponseBody
    @PutMapping("/SecondCategory")
    public int updateSecondCategory(SecondCategory secondCategory) throws  Exception{
        return SecondCategoryMapper.updateById(secondCategory);
    }
}
