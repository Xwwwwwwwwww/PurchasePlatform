package com.xwwwww.purchaseplatform.service.login;

import com.xwwwww.purchaseplatform.utils.result.Result;
import com.xwwwww.purchaseplatform.utils.result.ResultCode;
import com.xwwwww.purchaseplatform.utils.token.AesUtils;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public Result login(String phoneNumber, String password) throws Exception{
        Result result = new Result(ResultCode.SUCCESS, AesUtils.encrypt(phoneNumber+","+password));
        return result;
    }
}
