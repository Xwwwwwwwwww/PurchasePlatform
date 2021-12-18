package com.xwwwww.purchaseplatform.service.data;

import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface SizeService {
    public Result getSizeBySystem(int belongingSystem) throws Exception;
}
