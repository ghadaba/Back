
package com.vermeg.settlementModule.instructionManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.settlementModule.model.Asset;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")

public class AssetController {
	@Autowired
	private AssetRepository AssetRepository;

	@GetMapping("/assets")
	public List<com.vermeg.settlementModule.model.Asset> getAllAssets() {
		return AssetRepository.findAll();
	}

	@GetMapping("/assets/{id}")
	public ResponseEntity<com.vermeg.settlementModule.model.Asset> getAssetById(
			@PathVariable(value = "id") Long assetId) throws RessourceNotFoundException {
		com.vermeg.settlementModule.model.Asset asset = AssetRepository.findById(assetId)
				.orElseThrow(
						() -> new RessourceNotFoundException("asset not found for this id :: " + assetId));
		return ResponseEntity.ok().body(asset);
	}

	@PostMapping("/asset")
	public Asset createAsset(@Valid @RequestBody Asset asset) {
		return AssetRepository.save(asset);
	}

	@PutMapping("/assets/{id}")
	public ResponseEntity<Asset> updateAsset(@PathVariable(value = "id") Long assetId,
			@Valid @RequestBody com.vermeg.settlementModule.model.Asset AssetDetails)
			throws RessourceNotFoundException {
		com.vermeg.settlementModule.model.Asset asset = AssetRepository.findById(assetId)
				.orElseThrow(
						() -> new RessourceNotFoundException("asset not found for this id :: " + assetId));

		asset.setIsin(AssetDetails.getIsin());
		asset.setInstrument(AssetDetails.getInstrument());
		asset.setSettelmentplace(AssetDetails.getSettelmentplace());
		asset.setNostrocashacc(AssetDetails.getNostrocashacc());
		asset.setNostrocashacc(AssetDetails.getNostrocashacc());
		
		

		final com.vermeg.settlementModule.model.Asset updatedAsset = AssetRepository
				.save(asset);
		return ResponseEntity.ok(updatedAsset);
	}

	@DeleteMapping("/assets/{Id}")
	public Map<String, Boolean> deleteAsset(@PathVariable(value = "Id") Long assetId)
			throws RessourceNotFoundException {
		com.vermeg.settlementModule.model.Asset asset = AssetRepository.findById(assetId)
				.orElseThrow(
						() -> new RessourceNotFoundException("asset not found for this id :: " + assetId));

		AssetRepository.delete(asset);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}