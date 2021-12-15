package com.xwwwww.purchaseplatform.service.shopping;

import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface DisplayCategoryService {
    Result DisplayFirst();

    Result DisplaySingle(int id);
}
