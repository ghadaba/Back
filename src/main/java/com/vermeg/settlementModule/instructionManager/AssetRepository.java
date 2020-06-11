package com.vermeg.settlementModule.instructionManager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.settlementModule.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long>{

}
