package com.xwwwww.purchaseplatform.service.data;

import com.xwwwww.purchaseplatform.entity.constant.banner.Banner;
import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface BannerService {
    public Result getAllBanner() throws Exception;

    public Result insertBanner(Banner banner) throws Exception;

    public Result deleteBanner(int id) throws Exception;

    public Result updateBanner(Banner banner) throws Exception;

}
