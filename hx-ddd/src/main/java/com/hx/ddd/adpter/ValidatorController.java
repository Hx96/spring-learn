package com.hx.ddd.adpter;

import com.hx.ddd.infrastructure.annotation.CaseUpper;
import com.hx.ddd.infrastructure.annotation.EncryptId;
import lombok.Data;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * 验证器控制器
 *
 * @author kyle
 * @date 2023/03/24
 */
@RestController
@Validated
public class ValidatorController {

    /**
     * 创建项目申请签证官
     *
     * @author kyle
     * @date 2023/03/24
     */
    @Data
    @ToString
    class CreateProjectReqVO {
        /**
         * 请求序列号
         */
        @NotNull(message = "请求序列号不可为空")
        @Max(value = 10, message = "111")
        private Integer requestNo;

        /**
         * 请求序列号
         */
        @NotNull(message = "不能大于20")
        @Max(value = 20, message = "xxx")
        private Integer requestNo1;
    }
    @GetMapping("/check")
    public String check(@Validated CreateProjectReqVO createProjectReqVO
            , @Validated(UserRequest.Save.class) UserRequest userRequest) {
        System.out.println(createProjectReqVO);
        return "success" + createProjectReqVO.toString();
    }

    @GetMapping("/checkEn")
    public String checkEn(@Validated @EncryptId String enyId, @Validated Person person) {
        return "success" + enyId.toString();
    }

    @GetMapping("/request")
    public Object request(UserRequest userRequest) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    @Data
    class Person {
        //@NotNull(message = "personId不能为null",groups = Select.class)
        private Integer personId;
        //@NotEmpty(message = "name不能为空",groups = Insert.class)
        private String name;
        private String age;
        @CaseUpper(message = "num必须大写")
        private String num;
    }

}
