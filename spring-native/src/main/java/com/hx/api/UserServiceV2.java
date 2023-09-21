package com.hx.api;

/**
 * @author kyle
 * @date 2023/09/21
 */
public interface UserServiceV2 extends UserService {
    /**
     * 1
     * @param id
     */
    void getUser(Integer id);

    /**
     * @param id
     */
    void getOrganization(Integer id);
}
