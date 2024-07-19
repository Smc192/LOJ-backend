package com.luots.lojbackendjudgeservice.judge.codesandbox;

import com.luots.lojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.luots.lojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
