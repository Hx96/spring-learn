package com.hx.ddd.adpter;

import com.hx.ddd.infrastructure.annotation.EncryptId;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 用户请求
 *
 * @author kyle
 * @date 2023/03/25
 */
@Data
public class UserRequest {

    @Min(value = 10000000000000000L, groups = Update.class)
    private Long userId;

//    @NotNull(groups = {Save.class, Update.class})
//    @Length(min = 2, max = 10, groups = {Save.class, Update.class})
    @NotEmpty(message = "不能为空")
    @Pattern.List({ @Pattern(regexp = "[1-9]", message = "xx"), @Pattern(regexp = "[\\\\u4e00-\\\\u9fa5]+", message = "中文1") })
    private String userName;

    @NotNull(groups = {Save.class, Update.class})
    @Length(min = 6, max = 20, groups = {Save.class, Update.class})
    private String account;

    @NotNull(groups = {Save.class, Update.class})
    @Length(min = 6, max = 20, groups = {Save.class, Update.class})
    private String password;

    @NotNull(groups = {Save.class, Update.class})
    @Valid
    private Job job;

    @EncryptId
    private String encryptId;

    @Data
    public static class Job {

        @Min(value = 1, groups = Update.class)
        private Long jobId;

        @NotNull(groups = {Save.class, Update.class})
        @Length(min = 2, max = 10, groups = {Save.class, Update.class})
        private String jobName;

        @NotNull(groups = {Save.class, Update.class})
        @Length(min = 2, max = 10, groups = {Save.class, Update.class})
        private String position;
    }

    /**
     * 保存的时候校验分组
     */
    public interface Save {
    }

    /**
     * 更新的时候校验分组
     */
    public interface Update {
    }
}
