package projet3.maison.leloire.service;

import projet3.maison.leloire.entity.Mensuration;
import projet3.maison.leloire.entity.dto.MensurationDto;

public interface MensurationService {
    Mensuration saveMensuration(MensurationDto mensurationDto);
}
