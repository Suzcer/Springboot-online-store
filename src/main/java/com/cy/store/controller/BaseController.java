package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.service.ex.DeleteException;
import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {

    public static final int OK=200;

    @ExceptionHandler({ServiceException.class,FileUploadException.class}) //用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result=new JsonResult<>(e);

        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名已被占用");
        }else if(e instanceof UserNotFoundException){
            result.setState(5001);
            result.setMessage("用户数据不存在");
        }else if(e instanceof AddressCountLimitException){
            result.setState(4003);
            result.setMessage("地址超出上限");
        }else if(e instanceof AddressNotFoundException){
            result.setState(4004);
            result.setMessage("用户的收货地址数据不存在");
        }else if(e instanceof AccessDeniedException){
            result.setState(4005);
            result.setMessage("数据非法访问");
        }else if(e instanceof ProductNotFoundException){
            result.setState(4006);
            result.setMessage("商品数据不存在");
        }else if(e instanceof CartNotFoundException){
            result.setState(4007);
            result.setMessage("购物车数据不存在异常");
        }else if(e instanceof PasswordNotMatchException){
            result.setState(5002);
            result.setMessage("用户名的密码错误");
        }else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册产生未知异常");
        }else if(e instanceof UpdateException){
            result.setState(5003);
            result.setMessage("更新数据产生未知异常");
        }else if(e instanceof DeleteException){
            result.setState(5005);
            result.setMessage("删除数据产生未知异常");
        }else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }

        return result;
    }

    /**
     *  获取session对象中的uid
     * @param session
     * @return
     */
    protected final Integer getuidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     *  虎丘当前登录用户的username
     * @param session
     * @return
     */
    protected final String getUsernameFromSession(HttpSession session){

        return session.getAttribute("username").toString();
    }

}
