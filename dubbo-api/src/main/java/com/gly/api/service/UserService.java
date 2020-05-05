package com.gly.api.service;

import com.gly.api.domain.UserInfo;

public interface UserService {
    UserInfo getByUserId(Integer userId);
}
