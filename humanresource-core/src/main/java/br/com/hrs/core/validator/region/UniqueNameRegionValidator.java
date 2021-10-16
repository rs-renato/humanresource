package br.com.hrs.core.validator.region;

import br.com.hrs.core.common.error.Error;
import br.com.hrs.core.common.error.FIELD;
import br.com.hrs.core.exception.HrsBusinessException;
import br.com.hrs.core.model.Region;
import br.com.hrs.core.repository.RegionRepository;
import br.com.hrs.core.validator.SaveValidator;
import br.com.hrs.core.validator.UpdateValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Objects;

@Named
public class UniqueNameRegionValidator implements SaveValidator<Region>, UpdateValidator<Region> {

	private static Logger logger = LogManager.getLogger(UniqueNameRegionValidator.class);

	private RegionRepository regionRepository;

	@Inject
	public UniqueNameRegionValidator(RegionRepository regionRepository) {
		this.regionRepository = regionRepository;
	}
	
	@Override
	public void validate(Region region) {
		logger.debug("Validating if region has unique name");

		if (Objects.isNull(region)) {
			Error.of("Region").when(FIELD.MANDATORY).trows();
		}

		if (Objects.isNull(region.getName())) {
			Error.of("Region Name").when(FIELD.MANDATORY).trows();
		}

		// if has regionId, so its an update
		Integer regionId = region.getId();

		if ((regionId == null && this.regionRepository.findByName(region.getName()).isPresent())
				|| (regionId != null && !regionRepository.findById(regionId).get().getName().equals(region.getName()))){
			throw new HrsBusinessException("Region name should be unique");
		}
	}
}