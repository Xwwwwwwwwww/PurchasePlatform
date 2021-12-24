package com.xwwwww.purchaseplatform.service.data.Impl;

import com.xwwwww.purchaseplatform.entity.constant.banner.Banner;
import com.xwwwww.purchaseplatform.mapper.constant.banner.BannerMapper;
import com.xwwwww.purchaseplatform.service.data.BannerService;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public Result getAllBanner() throws Exception {
        return Result.SUCCESS(bannerMapper.selectList(null));
    }

    @Override
    public Result insertBanner(Banner banner) throws Exception {
        bannerMapper.insert(banner);
        return Result.SUCCESS(banner.getId());
    }

    @Override
    public Result deleteBanner(int id) throws Exception {
        bannerMapper.deleteById(id);
        return Result.SUCCESS();
    }

    @Override
    public Result updateBanner(Banner banner) throws Exception {
        bannerMapper.updateById(banner);
        return Result.SUCCESS();
    }
}
