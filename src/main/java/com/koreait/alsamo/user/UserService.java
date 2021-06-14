
package com.koreait.alsamo.user;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private HttpSession session;

    public int join(UserEntity param) {
        String crypPw = BCrypt.hashpw(param.getUpw(), BCrypt.gensalt());
        param.setUpw(crypPw);
        return mapper.insUser(param);
    }

    public String login(UserEntity param) {

        UserEntity result = mapper.selUser(param);

        if (result == null) {
            //아이디 없음
            return "/user/login?err=1";
        } else if (BCrypt.checkpw(param.getUpw(), result.getUpw())) {
            //로그인 성공
            result.setUpw(null);
            session.setAttribute("loginUser", result);
            return "/board/list";
        } else {
            //비밀번호 틀림
            return "/user/login?err=2";
        }

    }
}