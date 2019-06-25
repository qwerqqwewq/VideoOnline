package com.zte.video.service.impl;

import com.zte.video.dao.FavoritesDao;
import com.zte.video.entity.Favorites;
import com.zte.video.entity.Video;
import com.zte.video.service.PowerService;
import com.zte.video.utils.CurrentDate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-06-25 17:09
 * Description:<描述>
 */
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class FavoritesServiceImpl implements PowerService.FavoritesService {
    @Autowired
    private FavoritesDao favoritesDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    /**
     * 查询所有收藏夹
     */
    public List<Favorites> findAll() {
        return favoritesDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int addFavorites(Favorites favorites) {
        return favoritesDao.insertFavorites(favorites);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int modifyFavorites(Favorites favorites) {
        return favoritesDao.updateFavorites(favorites);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updateFavorites(Favorites favorites) {
        return favoritesDao.deleteFavorites(favorites);
    }
}
