package com.zte.video.service;

import com.zte.video.entity.Favorites;
import com.zte.video.entity.FavoritesContent;

import java.util.List;

 /**
  * @Author:helloboy
  * @Date:2019-06-26 8:41
  * Description:<描述>
  */
public interface FavoritesContentService {
    /**
     * 查询所有收藏夹内容
     * @return
     */
    public List<FavoritesContent> findAll();
    /**
     * 根据收藏夹查询内容
     * @param favorites
     * @return
     */
    public List<FavoritesContent> findAllById(Favorites favorites);
    /**
     * 添加新收藏夹内容
     * @param favoritesContent
     * @return
     */
    public int addFavoritesContent(FavoritesContent favoritesContent);
    /**
     * 修改收藏夹内容
     * @param favoritesContent
     * @return
     */
    public int modifyFavoritesContent(FavoritesContent favoritesContent);
    /**
     * 删除收藏夹内容
     * @param favoritesContent
     * @return
     */
    public int updateFavoritesContent(FavoritesContent favoritesContent);
}
