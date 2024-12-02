package com.electronicregion.de2.repositories;

import com.electronicregion.de2.models.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepo extends JpaRepository<RegionEntity, Long> {
}
