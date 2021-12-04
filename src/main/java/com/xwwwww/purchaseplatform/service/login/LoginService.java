package com.xwwwww.purchaseplatform.service.login;

import com.xwwwww.purchaseplatform.utils.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public Result login(String phoneNumber, String password) throws Exception;
}
