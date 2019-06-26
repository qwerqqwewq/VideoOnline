package com.zte.video.service.impl;

import com.zte.video.dao.FavoritesContentDao;
import com.zte.video.entity.Favorites;
import com.zte.video.entity.FavoritesContent;
import com.zte.video.service.FavoritesContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:helloboy
 * @Date:2019-06-26 8:54
 * Description:<描述>
 */
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class FavoritesContentServiceImpl {
    @Autowired
    private FavoritesContentDao favoritescontentDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    /**
     * 查询所有收藏夹内容
     * @return
     */
    public List<FavoritesContent> findAll(){
        return favoritescontentDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public List<FavoritesContent> findAllById(Favorites favorites) {
        return favoritescontentDao.selectAllById(favorites);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int addFavoritesContent(FavoritesContent favoritescontent) {
        return favoritescontentDao.insertFavoritesContent(favoritescontent);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int modifyFavoritesContent(FavoritesContent favoritescontent) {
        return favoritescontentDao.updateFavoritesContent(favoritescontent);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updateFavoritesContent(FavoritesContent favoritescontent) {
        return favoritescontentDao.deleteFavoritesContent(favoritescontent);
    }



}
