package com.trading.positionservice.repository;

import com.trading.positionservice.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository
        extends JpaRepository<Position,Long>{}