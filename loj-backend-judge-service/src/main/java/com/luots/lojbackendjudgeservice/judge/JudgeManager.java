package com.luots.lojbackendjudgeservice.judge;

import com.luots.lojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.luots.lojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.luots.lojbackendjudgeservice.judge.strategy.JudgeContext;
import com.luots.lojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.luots.lojbackendmodel.model.codesandbox.JudgeInfo;
import com.luots.lojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
