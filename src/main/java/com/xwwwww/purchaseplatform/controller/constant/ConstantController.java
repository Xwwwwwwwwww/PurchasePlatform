package com.xwwwww.purchaseplatform.controller.constant;

import com.xwwwww.purchaseplatform.entity.constant.commodity.category.FirstCategory;
import com.xwwwww.purchaseplatform.entity.constant.commodity.category.SecondCategory;
import com.xwwwww.purchaseplatform.entity.constant.commodity.category.ThirdCategory;
import com.xwwwww.purchaseplatform.entity.constant.commodity.express.ExpressCompany;
import com.xwwwww.purchaseplatform.entity.constant.commodity.size.Size;
import com.xwwwww.purchaseplatform.entity.constant.commodity.size.SizeSystem;
import com.xwwwww.purchaseplatform.entity.constant.commodity.specification.SpecificationSystem;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.category.FirstCategoryMapper;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.category.SecondCategoryMapper;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.category.ThirdCategoryMapper;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.express.ExpressCompanyMapper;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.size.SizeMapper;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.size.SizeSystemMapper;
import com.xwwwww.purchaseplatform.mapper.constant.commodity.specification.SpecificationSystemMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 查询常量
 */
@Api(tags="常量信息模块")
@CrossOrigin
@RestController
@RequestMapping("/data")
public class ConstantController {
//    @Autowired
//    FirstCategoryMapper firstCategoryMapper;
//
//    @Autowired
//    SecondCategoryMapper secondCategoryMapper;
//
//    @Autowired
//    ThirdCategoryMapper thirdCategoryMapper;

    @Autowired
    ExpressCompanyMapper expressCompanyMapper;

    @Autowired
    SizeMapper sizeMapper;

    @Autowired
    SizeSystemMapper sizeSystemMapper;

    @Autowired
    SpecificationSystemMapper specificationSystemMapper;

//    @ResponseBody
//    @GetMapping("/constant/firstCategory")
//    public FirstCategory getFirstCategoryById(int id) throws Exception{
//        return firstCategoryMapper.selectById(id);
//    }
//
//    @ResponseBody
//    @GetMapping("/constant/secondCategory")
//    public SecondCategory getSecondCategoryById(int id) throws Exception{
//        return secondCategoryMapper.selectById(id);
//    }
//
//    @ResponseBody
//    @GetMapping("/constant/thirdCategory")
//    public ThirdCategory getThirdCategoryById(int id) throws Exception{
//        return thirdCategoryMapper.selectById(id);
//    }

    @ApiOperation(value="根据id获取快递公司")
    @ResponseBody
    @GetMapping("/constant/expressCompany")
    public ExpressCompany getExpressCompanyById(int id) throws Exception{
        return expressCompanyMapper.selectById(id);
    }

    @ApiOperation(value="根据id获取商品尺码（三级分类）")
    @ResponseBody
    @GetMapping("/constant/size")
    public Size getSizeById(int id) throws Exception{
        return sizeMapper.selectById(id);
    }

    @ApiOperation(value="根据id获取商品尺码系统（二级分类）")
    @ResponseBody
    @GetMapping("/constant/sizeSystem")
    public SizeSystem getSizeSystemById(int id) throws Exception{
        return sizeSystemMapper.selectById(id);
    }

    @ApiOperation(value="根据id获取商品分类（一级分类）")
    @ResponseBody
    @GetMapping("/constant/specificationSystem")
    public SpecificationSystem getSpecificationSystemById(int id) throws Exception{
        return specificationSystemMapper.selectById(id);
    }
}
