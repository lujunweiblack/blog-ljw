package com.ljw.blog.common.tools;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author: lujunwei
 * @time: 15:55 2019/4/26
 * @des:
 */
@AllArgsConstructor
@NoArgsConstructor
public class MyAuthenticator extends Authenticator {
    String userName = null;
    String password = null;

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);

    }
}

