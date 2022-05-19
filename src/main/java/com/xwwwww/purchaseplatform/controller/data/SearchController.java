package com.xwwwww.purchaseplatform.controller.data;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Customer;
import com.xwwwww.purchaseplatform.entity.shopping.customer.DeliveryAddress;
import com.xwwwww.purchaseplatform.entity.shopping.customer.Search;
import com.xwwwww.purchaseplatform.mapper.shopping.customer.SearchMapper;
import com.xwwwww.purchaseplatform.service.login.LoginService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialArray;
import java.util.List;

@Api(tags="搜索记录模块")
@CrossOrigin
@RestController
@RequestMapping("/shopping")
public class SearchController {
    @Autowired
    SearchMapper searchMapper;

    /**
     *
     * @param customer_id
     * @return
     * @throws Exception
     * 查询某个顾客的全部搜索记录
     */
    @ApiOperation(value="查询某个顾客的全部搜索记录")
    @ResponseBody
    @GetMapping("/search/customer")
    public List<Search> getSearchByCustomerId(int customer_id) throws Exception{
        QueryWrapper<Search> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("customer_id",customer_id);
        return searchMapper.selectList(queryWrapper);
    }

    @ApiOperation(value="添加数据")
    @ResponseBody
    @PostMapping("/search")
    public int insertSearch(Search search) throws Exception{
        return searchMapper.insert(search);
    }

    @ApiOperation(value="删除数据")
    @ResponseBody
    @DeleteMapping("/search")
    public int deleteSearch(int id) throws Exception{
        return searchMapper.deleteById((id));
    }

    @ApiOperation(value="修改数据")
    @ResponseBody
    @PutMapping("/search")
    public int updateSearch(Search search) throws  Exception{
        return searchMapper.updateById(search);
    }

    /**
     *
     * @return list
     * @throws Exception
     * 查询所有搜索记录
     */
    @ApiOperation(value="查询所有搜索记录")
    @ResponseBody
    @GetMapping("/search/all")
    public List<Search> getAllSearch() throws Exception{
        return searchMapper.selectList(null);
    }

}
