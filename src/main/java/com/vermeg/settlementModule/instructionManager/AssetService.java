package com.vermeg.settlementModule.instructionManager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.settlementModule.model.Asset;
@Service
public class AssetService {
@Autowired
private AssetRepository repo ;

public List<Asset> ListAll() {
	return repo.findAll();
}
 public void save(Asset asset) {
	 repo.save(asset);
	 
	 
 }
 public Asset get (Long id ) {
	 return repo.findById(id).get();
 }
 public void delete(long id) {
	 repo.deleteById(id);
 }

}  