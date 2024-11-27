package com.electronicregion.de2.repositories;

import com.electronicregion.de2.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RegionRepo extends JpaRepository<Region, Long> {
}
