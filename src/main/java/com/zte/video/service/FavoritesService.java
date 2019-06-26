package com.zte.video.service;

import com.zte.video.entity.Favorites;
import com.zte.video.entity.User;

import java.util.List;

/**
 * @Author:helloboy
 * @Date:2019-06-25 17:24
 * Description:<描述>
 */
public interface FavoritesService {

        /**
         * 查询所有收藏夹
         * @return
         */
        public List<Favorites> findAll();
        /**
         * 根据用户查询收藏夹
         * @param user
         * @return
         */
        public List<Favorites> findById(User user);
        /**
         * 添加一个收藏夹
         * @param favorites
         * @return
         */
        public int addFavorites(Favorites favorites);
        /**
         * 修改收藏夹
         * @param favorites
         * @return
         */
        public int modifyFavorites(Favorites favorites);
        /**
         * 删除收藏夹
         * @param favorites
         * @return
         */
        public int updateFavorites(Favorites favorites);
}
