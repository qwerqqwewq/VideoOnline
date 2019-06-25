package com.zte.video.dao;

import com.zte.video.entity.Favorites;
import com.zte.video.entity.FavoritesContent;

import java.util.List;

/**
 * @Author:helloboy
 * @Date:2019-06-25 14:51
 * Description:<描述>
 */
public interface FavoritesContentDao {
    /**
     * 查询所有收藏夹内容
     * @return
     */
    public List<FavoritesContent> selectAll();
    /**
     * 根据收藏夹查询内容
     * @param favorites
     * @return
     */
    public List<FavoritesContent> selectAllById(Favorites favorites);
    /**
     * 添加新收藏夹内容
     * @param favoritesContent
     * @return
     */
    public void insertFavoritesContent(FavoritesContent favoritesContent);
    /**
     * 修改收藏夹内容
     * @param favoritesContent
     * @return
     */
    public void updateFavoritesContent(FavoritesContent favoritesContent);
    /**
     * 删除收藏夹内容
     * @param favoritesContent
     * @return
     */
    public void deleteFavoritesContent(FavoritesContent favoritesContent);
}
