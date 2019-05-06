package ua.itif.lms.view;

import ua.itif.lms.dao.entity.User;

public class LoginView {

    public static String getLoginPage(){
        IndexSingletonView indexSingletonView = IndexSingletonView.getInstance();
        String indBase = indexSingletonView.getIndexHtml();
        String loginForm = indexSingletonView.getLoginForm();
        return indBase.replace("<!--### insert html here ### -->", loginForm);
    }

    public static String welcomUserPage(User user){
        IndexSingletonView indexSingletonView = IndexSingletonView.getInstance();
        String indBase = indexSingletonView.getIndexHtml();
        String loginForm = indexSingletonView.getLoginForm();
        return indBase.replace("<!--### insert html here ### -->", "Hello " + user.getName());
    }

}
