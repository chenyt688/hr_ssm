package com.neuedu.hr.business.service;

import com.neuedu.hr.business.dao.PositionDao;
import com.neuedu.hr.business.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    private PositionDao positionDao;

    public List<Position> getAllPosition() {
        return positionDao.getAllPosition();
    }

    public void insertPosition(Position position) {
        positionDao.insertPosition(position);
    }

    public void deletePosition(String position_code) {
        positionDao.deletePosition(position_code);
    }

    public void updatePosition(Position position) {
        positionDao.updatePosition(position);
    }
}
