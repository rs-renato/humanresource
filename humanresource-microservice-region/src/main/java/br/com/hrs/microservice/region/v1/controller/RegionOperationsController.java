package br.com.hrs.microservice.region.v1.controller;

import br.com.hrs.core.model.Region;
import br.com.hrs.core.usecase.region.RegionUseCase;
import br.com.hrs.microservice.region.v1.docs.RegionOperationsDocumentable;
import br.com.hrs.microservice.region.v1.mapper.RegionMapper;
import br.com.hrs.microservice.region.v1.resource.RegionResource;
import com.hrs.microservice.support.AssertionSupport;
import com.hrs.microservice.support.PatchSupport;
import com.hrs.microservice.support.message.MensagemRetorno;
import com.hrs.microservice.support.message.MensagemRetornoCategoria;
import com.hrs.microservice.support.message.MensagemRetornoResponseEntitySupport;
import com.hrs.microservice.validation.FieldValidationStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonMergePatch;
import java.util.Optional;

@RestController
@RequestMapping("/v1/regions")
public class RegionOperationsController implements RegionOperationsDocumentable {

	private static Logger logger = LogManager.getLogger(RegionOperationsController.class);

	private RegionUseCase regionUseCase;
	private RegionMapper regionMapper;
	private PatchSupport patchSupport;

	@Autowired
	public RegionOperationsController(RegionUseCase regionUseCase, RegionMapper regionMapper, PatchSupport patchSupport) {
		this.regionUseCase = regionUseCase;
		this.regionMapper = regionMapper;
		this.patchSupport = patchSupport;
	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
				 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<RegionResource> create(@Validated(FieldValidationStrategy.Create.class) @RequestBody RegionResource regionResource) {
		logger.info("Performing 'Create Region' Body:{}", regionResource);
		Region regionCreated = this.regionUseCase.save(regionMapper.toModel(regionResource));
		logger.info("Region {} created on 'Create Region'", regionCreated);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(regionMapper.toResource(regionCreated));
	}
	
	@PutMapping(value="/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<RegionResource> update(@PathVariable Integer id, @Validated(FieldValidationStrategy.Update.class)  @RequestBody RegionResource regionResource) {
		logger.info("Performing 'Update Region' Id:{}, Body:{}", id, regionResource);
		regionResource.setId(id);
		this.regionUseCase.update(regionMapper.toModel(regionResource));
		logger.info("Region {} updated on 'Update Region'", regionResource);
		return ResponseEntity.ok(regionResource);
	}

	@PatchMapping(value="/{id}", consumes = "application/merge-patch+json",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<RegionResource> patch(@PathVariable Integer id, @RequestBody JsonMergePatch jsonMergePatch) {
		logger.info("Performing 'Update (Patch) Region' Id:{}, MergePatch:{}", id, jsonMergePatch);
		Optional<Region> region = this.regionUseCase.findById(id);
		AssertionSupport.assertResourceFound(region, "Region not found!");

		RegionResource regionPatched = patchSupport.apply(jsonMergePatch, regionMapper.toResource(regionMapper.unwrap(region)));

		this.regionUseCase.update(regionMapper.toModel(regionPatched));
		logger.info("Region {} updated on 'Update (Patch) Region'", regionPatched);
		return ResponseEntity.ok(regionPatched);
	}

	@DeleteMapping(value="/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<MensagemRetorno> delete(@PathVariable Integer id) {
		logger.info("Performing 'Delete Region' Id:{}", id);
		this.regionUseCase.deleteById(id);
		logger.info("Region {} deleted on 'Delete Region'", id);
		return MensagemRetornoResponseEntitySupport.createResponseEntity(
				MensagemRetornoCategoria.CONFIRMACAO, HttpStatus.OK, "Region successfully deleted");
	}
}
