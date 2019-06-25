package com.zte.video.dao;

import com.zte.video.entity.Favorites;
import com.zte.video.entity.User;

import java.util.List;

    /**
     * @Author:helloboy
     * @Date:2019-06-25 14:19
     * Description:<描述>
     */
public interface FavoritesDao {
    /**
     * 查询所有收藏夹
     * @return
     */
    public List<Favorites> selectAll();
    /**
     * 根据用户查询收藏夹
     * @param user
     * @return
      */
    public List<Favorites> selectById(User user);
    /**
     * 添加一个收藏夹
     * @param favorites
     * @return
     */
    public void insertFavorites(Favorites favorites);
    /**
     * 修改收藏夹
     * @param favorites
     * @return
      */
    public void updateFavorites(Favorites favorites);
    /**
     * 删除收藏夹
     * @param favorites
     * @return
     */
    public void deleteFavorites(Favorites favorites);
}
