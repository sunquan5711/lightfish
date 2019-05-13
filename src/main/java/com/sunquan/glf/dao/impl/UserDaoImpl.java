package com.sunquan.glf.dao.impl;

import com.sunquan.glf.dao.CommonDao;
import com.sunquan.glf.domain.User;
import com.sunquan.glf.dao.UserDao;
import com.sunquan.glf.support.Support;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl extends CommonDao<User> implements UserDao {

    public User getUserById(String userId) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String userJson = (String)valueOperations.get(userId);

        return Support.json2Object(userJson,User.class);
    }

    public boolean addUser(User user) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        lock.lock();

        try {
            /*
            如果用redis代替关系型数据库，固然有它的优势，但同时弊端也是非常明显的，redis并不能用mysql那种思维模式来考虑数据的存储
            比如有序合理的管理表内容，或者实现根据某个属性查找特定对象数据
            所以完全采用redis做数据库的话，一切都采用纯粹的字符串存储，这样就使得很多复杂关系的查询不能或很难实现
             */
            String userJson = Support.object2Json(user);
            valueOperations.set(user.getUserId(),userJson);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            lock.unlock();
        }

    }

    /**
     * 将用户添加到某一类集合当中
     * @param key
     * @param user
     * @return
     */
    public boolean addUserToTypeList(String key, User user) {

        return super.addEleToTypeList(key,user);
    }

    public List<User> getUserListByType(String key) {

        return super.getListByTypeKey(key);
    }


}
