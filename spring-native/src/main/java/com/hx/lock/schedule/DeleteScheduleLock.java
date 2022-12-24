package com.hx.lock.schedule;

import com.hx.lock.LocalScheduleLock;
import com.hx.lock.LockName;

/**
 * 删除表锁
 *
 * @author kyle
 * @date 2022/12/23
 */
public class DeleteScheduleLock extends LocalScheduleLock {

    public DeleteScheduleLock(LockName lockNameEnm) {
        super(lockNameEnm);
    }
}
