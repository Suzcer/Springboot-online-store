package com.cy.store.service.impl;
import com.cy.store.VO.CartVO;
import com.cy.store.entity.Cart;
import com.cy.store.entity.Product;
import com.cy.store.mapper.CartMapper;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.ICartService;
import com.cy.store.service.IProductService;
import com.cy.store.service.ex.AccessDeniedException;
import com.cy.store.service.ex.CartNotFoundException;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/** 处理购物车数据的业务层实现类 */
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {

        Cart result = cartMapper.findByUidAndPid(uid, pid);
        if(result==null){

            Cart cart=new Cart();
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);

            Product product = productMapper.findById(pid);
            cart.setPrice(product.getPrice());
            cart.setCreatedTime(new Date());
            cart.setModifiedTime(new Date());
            cart.setCreatedUser(username);
            cart.setModifiedUser(username);

            Integer rows=cartMapper.insert(cart);
            if(rows!=1){
                throw new InsertException("插入产生未知的异常");
            }

        }else{
            int num = result.getNum() + amount;
            Integer rows = cartMapper.updateNumByCid(
                    result.getCid(),
                    num,
                    username,
                    new Date()
            );

            if(rows!=1){
                throw new UpdateException("更新购物车异常");
            }
        }
    }

    @Override
    public List<CartVO> getVOByUid(Integer uid) {
        return cartMapper.findVOByUid(uid);
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        if(result==null){
            throw new CartNotFoundException("用户数据不存在");
        }
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("数据非法访问");
        }

        Integer num= result.getNum()+1;
        Integer rows = cartMapper.updateNumByCid(cid, num, username, new Date());
        if(rows!=1){
            throw new UpdateException("数据更新失败");
        }

        return num;
    }

    @Override
    public Integer minusNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        if(result==null){
            throw new CartNotFoundException("用户数据不存在");
        }
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("数据非法访问");
        }

        if(result.getNum()==0) return 0;  //直接结束就好了
        Integer num= result.getNum()-1;
        Integer rows = cartMapper.updateNumByCid(cid, num, username, new Date());
        if(rows!=1){
            throw new UpdateException("数据更新失败");
        }

        return num;
    }

    @Override
    public List<CartVO> getVOByCid(Integer uid, Integer[] cids) {
        List<CartVO> list = cartMapper.findVOByCid(cids);
        Iterator<CartVO> it = list.iterator();
//        while(it.hasNext()){
//            CartVO cartVO = it.next();
//            if(!cartVO.getUid().equals(uid)){
//                list.remove(cartVO);
//            }
//        }
        return list;
    }


}